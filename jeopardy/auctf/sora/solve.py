messup = lambda x: ((8 * x) + 19) % 61 + 65

result = []
for val in 'aQLpavpKQcCVpfcg':
	found = 0
	for i in range(0x20, 0x80):
		if messup(i) == ord(val):
			found = i
			break
	result.append(chr(found))
	
print(''.join(result))
