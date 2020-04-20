#!/usr/bin/env python3

import angr
import sys

def main():
        project = angr.Project('ch18.bin')
        initial_state = project.factory.entry_state()
        simulation = project.factory.simgr(initial_state)

		desired_string = b'Great'
		undesired_string = b'Not yet'
        is_successful = lambda state: desired_string in state.posix.dumps(sys.stdout.fileno())
        should_abort = lambda state: undesired_string in state.posix.dumps(sys.stdout.fileno())

        simulation.explore(find=is_successful, avoid=should_abort)

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