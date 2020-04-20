from checksum import checks, results
import numpy as np

long = lambda x: x % 2**64

'''excel function pseudocode'''
def check_flag(flag):
	flag_len = len(flag)
	outer = 0
	for outer in range(flag_len):
		total = 0
		for inner in range(flag_len):
			mul_val = checksum[outer][inner]
			current = flag[inner]
			total = total + mul_val * current
		
		total = long(total)
		compare = checksum[outer][flag_len]
		if(compare != total):
			return False
			
	return True

solution = np.linalg.solve(checks,results)
flag = np.rint(solution).astype(int)
print(''.join([chr(i) for i in flag]))
