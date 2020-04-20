from idc import *

def decryptDword(start, size, key):
	for i in range(size):
		x = Dword(start)	
		x = (x^key)   
		PatchDword(start,x)
		start = start + 4
		
def decryptByte(start, size, key):
	for i in range(size):
		x = Dword(start)	
		x = (x^key)   
		PatchDword(start,x)
		start = start + 1