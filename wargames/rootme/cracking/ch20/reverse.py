#!/usr/bin/env python3

import angr
import sys

def main():
	project = angr.Project('ch20.bin')
	initial_state = project.factory.entry_state()
	simulation = project.factory.simgr(initial_state)
	
	def is_successful(state):
		return b'Well ' in state.posix.dumps(sys.stdout.fileno())
	
	def should_abort(state):
		return b'Try' in state.posix.dumps(sys.stdout.fileno())
	
	simulation.explore(find=is_successful, avoid=should_abort)
	
	if simulation.found:
		solution_state = simulation.found[0]
		result = solution_state.posix.dumps(sys.stdin.fileno())
		with open("pass", 'wb') as f:
			f.write(result)
			f.close()
	else:
		raise Exception('Could not find the solution')
	
if __name__ == '__main__':
	main()
