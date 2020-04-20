from idautils import *
from idaapi import *
from idc import *
import re

result = [0] * 256
nexthexpos = "0"
nexthexval = "0"
nextval = 0
nextpos = 0

pattern = re.compile("f[\d_]+")

for segea in Segments():
	for funcea in Functions(segea, SegEnd(segea)):
		functionName = GetFunctionName(funcea)
		if pattern.match(functionName):
			nextpos = 0
			nexthexpos = "0"
			if len(list(CodeRefsTo(funcea, 1))) > 0:
				for (startea, endea) in Chunks(funcea):
					for head in Heads(startea, endea):
						ins = GetMnem(head)
						opnd = GetOpnd(head, 0)
						if "add" in ins and "rax" in opnd:
							nexthexpos = GetOpnd(head, 1).replace("h", "")
							nextpos = int(nexthexpos, 16)
						
						if "sub" in ins and "rax" in opnd:
							nexthexpos = GetOpnd(head, 1).replace("h", "")
							nextpos = (-int(nexthexpos, 16)) & 0xff
							nexthexpos = hex(nextpos)[2:]
							
						if "cmp" in ins and "al" in opnd:
							nexthexval = GetOpnd(head, 1).replace("h", "")
							nextval = int(nexthexval, 16)
						
				print "function", functionName, "pos", nexthexpos, "val", nexthexval
				result[nextpos] = nextval

print result
finalresult = ''.join([chr(x) for x in result])
print finalresult
