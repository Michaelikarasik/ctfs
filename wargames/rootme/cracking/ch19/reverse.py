if __name__ == '__main__':
	KEY = 'I know, you love decrypting Byte Code !'
	I = 5
	SOLUCE = [57, 73, 79, 16, 18, 26, 74, 50, 13, 38, 13, 79, 86, 86, 87]
	KEYOUT = []
	for X in SOLUCE:
		KEYOUT.append(((X ^ ord(KEY[I])) - I) % 255)
		I = (I + 1) % len(KEY)
	
	print(''.join(chr(i) for i in KEYOUT))
