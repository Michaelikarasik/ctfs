from z3 import *
import numpy as np

def decrypt(original, input):
	result = [None] * len(original)
	j = 0
	for index in range(len(original)):
		j = j + 1
		if input[j % len(input)] == 0:
			j = 0
		inp = input[j % len(input)]
		org = original[index]
		result[index] = ((org ^ inp) + 86) & 0xff
	return result
	

def xorBack(key):
	empty = [0] * 12
	for i in range(len(key)):
		empty[i % 12] = empty[i % 12] ^ key[i]
	return empty
	
	
def BitVecVector(sz, N):
  """Create a vector with N Bit-Vectors of size sz"""
  return [ BitVec('vector__%s' % i, sz) for i in range(N) ]


def addRule(solver, ques, ans, bits):
	result = xorBack(decrypt(ques, bits))
	for i in range(len(result)):
		solver.add(result[i] == ans[i])


quesOne = np.fromfile("firstXord.bin", dtype="byte").tolist()
ansOne = np.fromfile("firstChecksum.bin", dtype="byte").tolist()

quesTwo = np.fromfile("secondXord.bin", dtype="byte").tolist()
ansTwo = np.fromfile("secondChecksum.bin", dtype="byte").tolist()

quesThree = np.fromfile("thirdXord.bin", dtype="byte").tolist()
ansThree = np.fromfile("thirdChecksum.bin", dtype="byte").tolist()

size = int(input("length: "))
print(size)
s = Solver()
myBits = BitVecVector("vector", 8, int(size))
	
addRule(s, quesOne, ansOne, myBits)
addRule(s, quesTwo, ansTwo, myBits)
addRule(s, quesThree, ansThree, myBits)

print("starting")
if s.check() == sat:
	result = s.model()
	print([result[i] for i in myBits])
	print(''.join(chr(int(repr(result[i]))) for i in myBits))

print("done")