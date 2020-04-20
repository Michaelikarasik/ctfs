def encode(string):
	result = "@@@@@@@@" * 8
	result = list(result)
	
	for index, char in enumerate(string):
		weirdParam = index >> 3
		
		for i in range(8):
			shifter = (index + i) % 8
			
			nextIdx = i * 8 + shifter
			
			orValue = ((1 << i) & ord(char)) >> i << weirdParam

			result[nextIdx] = chr(ord(result[nextIdx]) | orValue)
	
	return ''.join(result)
	
	
def reverse(string):
	result = [0] * 32
		
	for i in range(4):
		for line in range(8):
			for j in range(8):
				curResChar = i * 8 + ((j - line) % 8)
				result[curResChar] = result[curResChar] | ((ord(string[line * 8 + j]) & (1 << i)) >> i << line)
	return result
			
			
flag_result = "CCHJEHMKCFKJCEOLFOJLMOJJBDN@H@BAODMJHFCJMOOKMOOOOOAOFOGI@@@@@@@@"
	
flag = reverse(flag_result)
flag = ''.join(chr(x) for x in flag)

print(flag)
			
			
		