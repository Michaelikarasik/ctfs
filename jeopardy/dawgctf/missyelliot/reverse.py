#!/usr/bin/env python3

import angr
import sys

def main():
	project = angr.Project('missyelliott')
	initial_state = project.factory.entry_state()
	simulation = project.factory.simgr(initial_state)
	
	def is_successful(state):
		return b'Correct' in state.posix.dumps(sys.stdout.fileno())
	
	def should_abort(state):
		return b'You did it' in state.posix.dumps(sys.stdout.fileno())
	
	simulation.explore(find=is_successful, avoid=should_abort)
	
	if simulation.found:
		solution_state = simulation.found[0]
		result = solution_state.posix.dumps(sys.stdin.fileno())
		print(result)
		with open("result.txt", 'wb') as f:
			f.write(result)
			f.close()
	else:
		raise Exception('Could not find the solution')
	
if __name__ == '__main__':
  main()
