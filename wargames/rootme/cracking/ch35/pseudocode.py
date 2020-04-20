from string import ascii_uppercase
from z3 import *
import time

MAX_PROCS = 25
proc_list = []
user_input = []

class proc:
	def __init__(self, count):
		self.mode = 0
		self.proc_class = 0
		self.count = count
		self.negate_next = 0
		self.result_counter = 0
		self.finished = 0
		
		
	def _init_class(self):
		cur_group = (0xCCCCCCCCCCCCCCCD * (self.count - 1) >> 64) >> 2
		v21 = self.count - 1 - 5 * cur_group
		if ( cur_group <= v21 ):
			if ( cur_group >= v21 ):
				self.proc_class = -1
			else:
				self.proc_class = 1
		else:
			self.proc_class = 0
		
	
	def _set_next(self, next_value, next_mode):
		self.value = next_value
		self.mode = next_mode
		
	
	def _mode_zero(self, traced_p):
		self._init_class()
		
		if self.count == 25:
			self._set_next(user_input[0] ^ (user_input[1] << 8), 1)
		else:
			self._set_next(0, 0)
	
	
	def _mode_one(self, traced_p):
		value = traced_p.value
		
		value_byte0 = value & 0xff
		value_byte1 = (value >> 8) & 0xff
		class_indicator = (value >> 16) & 0xff
		input_index = (value >> 24) & 0xff
		negated_previous = (value >> 32) & 0xff
		
		if value_byte0 == self.count:
			if value_byte1 != 0:
				if match_check(value_byte0, value_byte1) and class_indicator == self.proc_class:
					self.proc_class = -1
				else:
					self.negate_next = -1 & 0xff
				
				value_byte0 = value_byte1
				value_byte1 = 0
				
				next_value = (self.negate_next << 32) ^ (input_index << 24) ^ (class_indicator << 16) ^ (value_byte0)
				
				self._set_next(next_value, 1)
			else:
				if negated_previous != -1 & 0xff and self.proc_class == -1:
					self.proc_class = class_indicator
					self.result_counter = self.result_counter + 1
				else:
					self.negate_next = -1 & 0xff
					
				input_index = input_index + 1
				if user_input[input_index * 2] != 26 or user_input[input_index * 2 + 1] != 26:
					value_byte0 = user_input[input_index * 2]
					value_byte1 = user_input[input_index * 2 + 1]
					
					next_value = (self.negate_next << 32) ^ (input_index << 24) ^ ((class_indicator ^ 1) << 16) ^ (value_byte1 << 8) ^ (value_byte0)
					self._set_next(next_value, 1)
				else:
					print_debug(input_index * 2, class_indicator ^ 1)
					self._set_next(0, 2)
		else:
			self._set_next(value, 1)
	
	
	def _mode_two(self, traced_p):
		if self.count == 25:
			result_holder = self.result_counter
			
			if self.proc_class != -1:
				result_holder = result_holder | 0x8000000000000000
			
			self._set_next(result_holder, 3)
		else:
			self._set_next(0, 2)
			
	
	def _mode_three(self, traced_p):
		value = traced_p.value
		result_holder = self.result_counter + value
		
		if self.count == 1:
			if self.proc_class != -1:
				result_holder = result_holder | 0x8000000000000000
				
			self._set_next(result_holder, 4)
		else:
			cur_group = (0xCCCCCCCCCCCCCCCD * (self.count - 1) >> 64) >> 2;
			v21 = self.count - 1 - 5 * cur_group;
			if ( cur_group >= v21 ):
				if ( cur_group <= v21 ):
					if self.proc_class != -1:
						result_holder = result_holder | 0x8400000000000000
				else:
					if self.proc_class != 1:
						result_holder = result_holder | 0x8200000000000000
			else:
				if self.proc_class != 0:
					result_holder = result_holder | 0x8100000000000000
			
			self._set_next(result_holder, 3)
			
			
	def _mode_four(self, traced_p):
		value = traced_p.value
		
		self.finished = 1
		
		if self.count == 1:
			self.result = value
			print("finished: %s" % hex(value))
			
		else:
			self._set_next(value, 4)
				
		
	
	def control_next(self, traced_p):
		mode = traced_p.mode
		
		[self._mode_zero, self._mode_one, self._mode_two, self._mode_three, self._mode_four][mode](traced_p)
			
			
def setup(proc_list):
	for i in range(MAX_PROCS): 
		proc_list.append(proc(i + 1))


def do_control(proc_list, current):
	traced_p = proc_list[current]
	controlling_p = proc_list[(current - 1) % MAX_PROCS]
	
	controlling_p.control_next(traced_p)
	
	
def find_matches(count):
	result = ''
	for i in range(1, 26):
		if i != count and match_check(i, count) == 1:
			result = result + chr(i + ord('@'))
			
	return result
	
	
def print_debug(position, next):
	#return
	print('\n' + ' ' * position + 'v')
	print(''.join(chr(i + ord('@')) for i in user_input))
	print("next: %d" % next)
	for i in proc_list:
		cur_group = (0xCCCCCCCCCCCCCCCD * (i.count - 1) >> 64) >> 2
		v21 = i.count - 1 - 5 * cur_group
		if ( cur_group <= v21 ):
			if ( cur_group >= v21 ):
				proc_class = -1
				need = -1
			else:
				proc_class = 1
				need = 0
		else:
			proc_class = 0
			need = 1
		
		isgood = "NO "
		if proc_class == -1 and proc_class == i.proc_class:
			isgood = "YES"
		elif (proc_class == 1 or proc_class == 0) and proc_class == 1 - i.proc_class:
			isgood = "YES"
			
		possibilities = ''.join(["%s %d, " % (i, proc_list[ord(i) - ord('@') - 1].proc_class) for i in find_matches(i.count)])[:-2]
		print("%s : %02d | %s | %02d | %s" % (chr(i.count + ord('@')), i.proc_class, isgood, need, possibilities))
				
				
def match_check(rdi0, rdi1):
	v4 = rdi0 - 1;
	v3 = rdi1 - 1;
	if ( rdi0 - 1 == rdi1 - 1 ):
		return 0;
	v6 = v4 % 5;
	v5 = v3 % 5;
	if ( abs(int(v4 / 5) - int(v3 / 5)) == 1 and abs(v6 - v5) == 2 ):
		return 1;
	if ( abs(int(v4 / 5) - int(v3 / 5)) != 2 or abs(v6 - v5) != 1 ):
		return 0;
	return 1;
	
	
def start_with_input(trial_input):
	if len(trial_input) % 2 == 0 and all(i in user_input_range for i in trial_input):
		trial_input = trial_input + "ZZ"
		user_input = [ord(i) - ord('@') for i in trial_input]
		
		proc_list = []
		setup(proc_list)
		current = MAX_PROCS - 1
		
		while(proc_list[0].finished != 1):
			do_control(proc_list, current)
			current = (current - 1) % MAX_PROCS
		
		result = proc_list[0].result
		if result == 32:
			print("Well done!")
		else:
			print("nope")
		
	else:
		print("Error: wrong input.")
		
	return [proc_list, result]
		
		
def main():
	global user_input
	global proc_list
	
	user_input_range = ascii_uppercase[:-1]
	trial_input = input('input: ')
	
	#DEBUG
	__import__('os').system('echo|set /p="%s"| clip' % trial_input)
	
	if len(trial_input) % 2 == 0 and all(i in user_input_range for i in trial_input):
		trial_input = trial_input + "ZZ"
		user_input = [ord(i) - ord('@') for i in trial_input]
		
		proc_list = []
		setup(proc_list)
		current = MAX_PROCS - 1
		
		while(proc_list[0].finished != 1):
			do_control(proc_list, current)
			current = (current - 1) % MAX_PROCS
		
		final_board = [i.proc_class for i in proc_list]
		print(final_board)
		print("result: %d" % sum([i == j for i, j in zip(final_board, desired)]))
		
		result = proc_list[0].result
		if result == 32:
			print("Well done!")
		else:
			print("nope")
		
	else:
		print("Error: wrong input.")
	

starting_board = [-1, 1, 1, 1, 1, 0, -1, 1, 1, 1, 0, 0, -1, 1, 1, 0, 0, 0, -1, 1, 0, 0, 0, 0, -1]
desired = [[1, 0, -1][i] for i in starting_board]	
user_input_range = ascii_uppercase[:-1]
	
	
def match_check_minimax(rdi0, rdi1):
	v4 = rdi0
	v3 = rdi1
	if ( rdi0 - 1 == rdi1 - 1 ):
		return 0;
	v6 = v4 % 5;
	v5 = v3 % 5;
	if ( abs(int(v4 / 5) - int(v3 / 5)) == 1 and abs(v6 - v5) == 2 ):
		return 1;
	if ( abs(int(v4 / 5) - int(v3 / 5)) != 2 or abs(v6 - v5) != 1 ):
		return 0;
	return 1;
	
	
mycount = 0
def do_min_max(board, depth, max_depth):
	global mycount
	mycount = mycount + 1
	
	current_score = sum([i == j for i, j in zip(board, desired)])
	if depth == max_depth:
		if board[4] != desired[4] or board[20] != desired[20]:
			return [-1, '']
		return [current_score, '']
		
	#if current_score < int(depth):
#		return [-1, '']
		
	my_children = []
	my_inputs = []
	
	for fst in range(0, 25):
		for scd in range(0, 25):
			parity = depth % 2
			
			if board[scd] != -1 or board[fst] != parity or not match_check_minimax(fst, scd):
				continue
			
			cur_board = board.copy()
			cur_board[fst], cur_board[scd] = board[scd], board[fst]
			
			result = do_min_max(cur_board, depth + 1, max_depth)
			my_children.append(result[0])
			my_inputs.append(chr(fst + 64 + 1) + chr(scd + 64 + 1) + result[1])
			
			
	if not len(my_children):
		print("board: " + repr(board))
		print("parity: %d" % parity)
		print("depth: %d" % depth)
		return [-1, '']
		
	max_val = max(my_children)
	max_input = my_inputs[my_children.index(max_val)]
	return [max_val, max_input]

	
def BitVecVector(prefix, sz, N):
	  """Create a vector with N Bit-Vectors of size sz"""
	  return [ BitVec('%s__%s' % (prefix, i), sz) for i in range(N) ]
  
  
def IntVector(prefix, N):
	  """Create a vector with N Bit-Vectors of size sz"""
	  return [ Int('%s__%s' % (prefix, i)) for i in range(N) ]

def BoolVector(prefix, N):
	  """Create a vector with N Bit-Vectors of size sz"""
	  return [ Bool('%s__%s' % (prefix, i)) for i in range(N) ]
	  
z3_abs = lambda x: If(x >= 0,x,-x)
	
	
findintcount = 0
def findIntIdx(arr, findidx, solver):
	global findintcount
	answer = Int("find%d" % findintcount)
	findintcount = findintcount + 1
	for idx, val in enumerate(arr):
		solver.add(answer == If(idx == findidx, val, answer))
		
	return answer
	
	
def z3_simplified():
	s = Solver()
	board = starting_board.copy()
	board = [2 if i == -1 else i for i in board]
	
	desired_board = desired.copy()
	desired_board = [2 if i == -1 else i for i in desired_board]
	
	sol_len = 32
	find_first = 25
	
	IntVecBoard = [IntVector("board%d" % i, 25) for i in range(int(sol_len / 2) + 1)]
	
	for i, j in zip(board, IntVecBoard[0]):
		s.add(j == i)
		
	sol = IntVector("sol", sol_len)
	for i in sol:
		s.add(i < 25)
		s.add(i >= 0)
	
	for i in range(0, len(sol), 2):
		fst = sol[i]
		scd = sol[i + 1]
		
		last_board = IntVecBoard[int(i / 2)]
		cur_board = IntVecBoard[int(i / 2) + 1]
		
		s.add(fst != scd)
		s.add(Or(And(z3_abs(fst / 5 - scd / 5) == 1, z3_abs((fst % 5) - (scd % 5)) == 2), And(z3_abs(fst / 5 - scd / 5) == 2, z3_abs((fst % 5) - (scd % 5)) == 1)))
		
		parity = (i / 2) % 2
		
		for idx, val in enumerate(last_board):
			s.add(val == If(fst == idx, parity, If(scd == idx, 2, val)))
		
		for idx, val in enumerate(cur_board):
			s.add(val == If(fst == idx, 2, If(scd == idx, answer, last_board[idx])))
			
	
	for i, j in zip(desired_board, IntVecBoard[-1]):
		s.add(j == i)
		
	
	#print(s)
	
	if s.check() == sat:
		print(s.model())
		result = s.model()
		print([result[i] for i in sol])
		return [result[i].as_long() for i in sol]
		
	else:
		print("not found")
		return []
		
		
def z3_trial():
	s = Solver()
	board = starting_board.copy()
	board = [2 if i == -1 else i for i in board]
	
	desired_board = desired.copy()
	desired_board = [2 if i == -1 else i for i in desired_board]
	
	A = Array('A',IntSort(),IntSort())
	
	#boardIntArray = IntVector("board", 25)
	#for i, j in zip(boardIntArray, board):
	#	s.add(i == j)
		
	for i in range(25):
		A = Store(A, i, board[i])
		
	sol_len = 64
	sol = IntVector("sol", sol_len)
	for i in sol:
		s.add(i < 25)
		s.add(i >= 0)
		
	for i in range(0, len(sol), 2):
		fst = sol[i]
		scd = sol[i + 1]
		
		s.add(fst != scd)
		s.add(Or(And(z3_abs(fst / 5 - scd / 5) == 1, z3_abs((fst % 5) - (scd % 5)) == 2), And(z3_abs(fst / 5 - scd / 5) == 2, z3_abs((fst % 5) - (scd % 5)) == 1)))
		
		parity = (i / 2) % 2
		s.add(Select(A, fst) == parity)
		s.add(Select(A, scd) == 2)
		
		A = Store(A, fst, 2)
		A = Store(A, scd, parity)
	
	
	for i in range(4):
		s.add(Select(A, i) == desired_board[i])
		
	#print(s)
	
	if s.check() == sat:
		print(s.model())
		result = s.model()
		print([result[i] for i in sol])
		return [result[i].as_long() for i in sol]
		
	else:
		print("not found")
		return []
	
	
	
def z3_trial_fixed():
	s = Solver()
	board = starting_board.copy()
	board = [2 if i == -1 else i for i in board]
	
	desired_board = desired.copy()
	desired_board = [2 if i == -1 else i for i in desired_board]
	
	A = Array('A',IntSort(),IntSort())
	
	#boardIntArray = IntVector("board", 25)
	#for i, j in zip(boardIntArray, board):
	#	s.add(i == j)
		
	for i in range(25):
		A = Store(A, i, board[i])
		
		
	sol_len = 64
	sol = IntVector("sol", sol_len)
	for i in sol:
		s.add(i < 25)
		s.add(i >= 0)
		
		
	parity_table = IntVector("parity", int(sol_len/2))
	patch_table = IntVector("patch", int(sol_len / 2))
	extra_table = BoolVector("extra", int(sol_len / 2) + 1)
	s.add(extra_table[0] == False)
	
	for i in patch_table:
		s.add(i < 25)
		s.add(i >= 0)
		
	for i in range(0, len(sol), 2):
		fst = sol[i]
		scd = sol[i + 1]
		
		s.add(fst != scd)
		s.add(Or(And(z3_abs(fst / 5 - scd / 5) == 1, z3_abs((fst % 5) - (scd % 5)) == 2), And(z3_abs(fst / 5 - scd / 5) == 2, z3_abs((fst % 5) - (scd % 5)) == 1)))
		
		parity = (i / 2) % 2
		parity_bool = (i/2)%2 == 1
		s.add(Select(A, fst) != 2)
		s.add(Select(A, scd) == 2)
		
		one = Select(A, fst)
		
		actual_parity = Xor(parity_bool, extra_table[int(i/2)])
		s.add(If(one != If(actual_parity, 1, 0), extra_table[int(i/2)] != extra_table[int(i/2) + 1], extra_table[int(i/2)] == extra_table[int(i/2) + 1]))
		for char in sol[i:]:
			s.add(If(one != If(actual_parity, 1, 0), patch_table[int(i/2)] != char, True))
			
			
		s.add(parity_table[int(i/2)] == Select(A, fst))
		A = Store(A, fst, 2)
		A = Store(A, scd, one)
	
	
	for i in range(4):
		s.add(Select(A, i) == desired_board[i])
		
	#print(s.sexpr())
	
	print("starting to solve...")
	if s.check() == sat:
		print(s.model())
		result = s.model()
		print("result: %s" % [result[i] for i in sol])
		patch_result = [result[i].as_long() for i in patch_table]
		print("patch: %s" % patch_result)
		print("extra z3: %s" % [result[i] for i in extra_table])
		
		extra = 0
		final_parity_table = []
		for idx, val in enumerate([result[i].as_long() for j, i in enumerate(parity_table)]):
			parity = (idx + extra) % 2
			if val == parity:
				final_parity_table.append(True)
			else:
				final_parity_table.append(False)
				extra = extra + 1
			
		return [[result[i].as_long() for i in sol], final_parity_table, patch_result]
		
	else:
		print("not found")
		return [[], []]
		


def fix_parity(input, parity_table):
	input = [input[i:i+2] for i in range(0, len(input), 2)]
	print(input)
	
	extra = 0
	
	for i in range(len(input)):
		parity = (i + extra) % 2
		if parity_table[i] != parity:
			for char in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
				if char == 'Z': print("not actually found")
				if all([char not in hurdle for hurdle in input[i + 1:]]):
					input[i] = char * 2 + input[i]
					extra = extra + 1
					break
					
	return ''.join(input)
				
	

if __name__ == "__main__":
	start = time.time()
	result = z3_trial_fixed()
	#result = z3_simplified()
	result_input = result[0]
	parity_table = result[1]
	patch_table = result[2]
	result_string = [chr(result_input[i] + 65) + chr(result_input[i+1] + 65) for i in range(0, len(result_input), 2)]
	print("input: %s" % ''.join([chr(i + 65) for i in result_input]))
	print("parity: %s" % parity_table)
	patched_input = ''.join([chr(patch_table[j] + 65) * 2 + val if not parity_table[j] else val for j, val in enumerate(result_string)])
	print(patched_input)
	#print("fixed input: %s" % fix_parity(result_string, parity_table))
	#print(parity_table)
	print("that took %f secs" % (time.time() - start))
	#already_found = "LAHSQHILRINQURENHELUAHBMIBCLFCMFRINGWNORVMTWMTSVHSJMXOMX"
	#board = [-1, 0, 0, 1, 0, 1, 1, -1, 0, -1, 0, 1, -1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, -1]
	#result = [0, '']
	#result = do_min_max(board, 28, 34)
	#print("score: %s" % repr(result[0]))
	#print("input: %s" % already_found + result[1])
	#print("count: %d" % mycount)
	#
	#main()
	
	