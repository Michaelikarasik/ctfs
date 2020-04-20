import sys

res = sys.argv[1]
print(res)
res = res.split(': ')[1]
final = ''.join(chr(ord(x) ^ 42) for x in res)

print(final)
