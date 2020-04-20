from z3 import *
import itertools

s = Solver()
#set_option(max_args=10000000, max_lines=1000000, max_depth=10000000, max_visited=1000000)

ALPHABET = [chr(i) for i in range(ord("*"), ord("z")+1)]

a = lambda c: ord(ALPHABET[0]) + (c % len(ALPHABET))

print("alphabet: %r with length %d" % (''.join(ALPHABET), len(ALPHABET)))
	
def indexes(mys, needle):
	a = 0
	for idx, c in enumerate(mys):
		if c == needle:
			a += idx
	return a


def makeone(bits, char, place):
	for idx in range(len(bits)):
		if idx == place:
			s.add(bits[idx] == ord(char))
		else:
			s.add(bits[idx] != ord(char))

def m(one, two, three, four):
	d = len(ALPHABET)//2
	mys = ord(ALPHABET[0])
	s1, s2, s3 = one - mys, two - mys, three - mys
	s.add(sum([s1, s2, s3]) % d == four % d)

def validate(email, key):
	#email = email.strip()
	#key = key.strip()
	
	email += [42]
	
	#s.add(email.count(ord("@")) == 1)

	s.add(key[0] == ord("Z"))

	#dotcount = email.count(ord("."))
	#s.add(dotcount >= 0)

	s.add(a(1) == key[1])  #s.add(a(dotcount) == key[1])

	s.add(key[3] == a(key[1]%30 + key[2]%30) + 5)

	s.add(key[2] == a(31 + 9 + 7))#a(indexes(email, "*") + 7))
	
	print((a(sum(email) % 60 + key[5])).sexpr())
	
	s.add(key[4] == a(sum(email) % 60 + key[5]))

	s.add(key[5] == a(key[3] + 52))

	s.add(key[6] == a((key[7]%8)*2))

	s.add(key[7] == a(key[1] + key[2] - key[3]))

	s.add(key[8] == a((key[6]%16) / 2))

	s.add(key[9] == a(key[6] + key[4] + key[8] - 4))

	s.add(key[10] == a((key[1]%2) * 8 + key[2] % 3 + key[3] % 4))

	m(email[3], key[11], key[12], 8)
	m(email[7], key[13], key[4], 18)
	m(email[9], key[14], key[3], 23)
	m(email[10], key[15], key[10], 3)
	m(email[11], key[13], key[16], 792)
	m(email[12], key[17], key[4], 1)#email.count(ord("d")))
	m(email[13], key[18], key[7], 1)#email.count(ord("a")))
	m(email[14], key[19], key[8], 1)#email.count(ord("w")))
	m(email[15], key[20], key[1], 1)#email.count(ord("g")))
	m(email[16], email[17], key[21], 1)#email.count(ord("s")))
	m(email[18], email[19], key[22], 1)#email.count(ord("m")))
	m(email[20], key[23], key[17], 9)
	m(email[21], key[24], key[13], 41)
	m(email[22], key[25], key[10], 3)
	m(email[23], key[26], email[14], 1)#email.count(ord("1")))
	m(email[24], email[25], key[27], 2)#email.count(ord("*")))
	m(email[26], email[27], key[28], 7)
	m(email[28], email[29], key[29], 2)
	m(email[30], key[30], email[18], 4)
	m(email[31], key[31], email[4], 7)

	return
	
	
def BitVecVector(prefix, sz, N):
	"""Create a vector with N Bit-Vectors of size sz"""
	return [ BitVec('%s__%s' % (prefix, i), sz) for i in range(N) ]
	
email = BitVecVector('email', 32, 31)
makeone(email, '@', 20)
makeone(email, 'd', 4)
makeone(email, 'a', 3)
makeone(email, 'w', 1)
makeone(email, 'g', 5)
makeone(email, 's', 6)
makeone(email, 'm', 7)
makeone(email, '1', 12)
makeone(email, '*', 9)
makeone(email, '.', 13)
for i in email:
	s.add(i >= ord('*'))
	s.add(i <= ord('z'))
	
key = BitVecVector('key', 32, 32)
for i in key:
	s.add(i >= ord('*'))
	s.add(i <= ord('z'))

validate(email, key)

print("finished validate")

if s.check() == sat:
	finalmodel = s.model()
	print(finalmodel)
	finalemail = [finalmodel[i].as_long() for i in email[:31]]
	
	print(a(indexes(finalemail + [42], ord('*')) + 7))
	
	
	print("finalemail: %s" % ''.join(chr(i) for i in finalemail))
	
	finalkey = [finalmodel[i].as_long() for i in key]
	print("finalkey: %s" % ''.join(chr(i) for i in finalkey))
	
else:
	print("unsolvable")

