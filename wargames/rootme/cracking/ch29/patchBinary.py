from __future__ import print_function

import idaapi
import idautils
import idc

funcLoc = 0x400c60
funcLen = 199

decryptedFunc = open('decryptedFunc.bin', 'rb').read()

for idx, val in enumerate(decryptedFunc):
	idc.PatchByte(funcLoc + idx, ord(val))

print("finished patching")
