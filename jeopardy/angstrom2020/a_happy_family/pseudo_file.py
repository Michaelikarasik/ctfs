import math
def tobase(n):
	ret = ['a'] * 18
	i = 17
	while i >= 0:
		 ret[i] = basechars[int(n % 13)]
		 n = n / 13
		 i = i - 1
	return ''.join(ret)

def find(n, sol):
	return basechars.find(sol[n])

def reverse(final):
	num = 0
	for i in range(0, 18):
		num += find(17 - i, final) * (13 ** i)
	return num

def frombase13(string):
    res = 0;
    for i in range(0, len(string)):
        res += base13.find(string[-i - 1]) * (math.pow(13,i))
    return res;

def reversebase(final):
    res = ""
    for i in final:
        res += base13[basechars.find(i)]
    return res

basechars = "angstromctf20"
base13 = "0123456789abc"

if __name__ == "__main__":
    end = ""
    for i in "ng0fa0mat0tmmmra0c":
    	end += hex(basechars.find(i))[2:]
    print(end)
    
    print(bytearray.fromhex("315f6e7270723761").decode()) # "artomtf2srn00tgm2f"
    print(bytearray.fromhex("6c685f3fccc54cc9").decode()) # "artomtf2srn00tgm2f"
