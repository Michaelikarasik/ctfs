#!/usr/bin/env python3

import angr
import sys

def main():
		project = angr.Project('ch12')
		initial_state = project.factory.entry_state()
		simulation = project.factory.simgr(initial_state)

		avoid_addr = 0x080563EC
		find_addr = 0x08056342

		simulation.explore(find=find_addr, avoid=avoid_addr)

		if simulation.found:
				solution_state = simulation.found[0]
				result = solution_state.posix.dumps(sys.stdin.fileno())
				print(result)
				with open("pass", 'wb') as f:
						f.write(result)
						f.close()
		else:
				raise Exception('Could not find the solution')

if __name__ == '__main__':
		main()