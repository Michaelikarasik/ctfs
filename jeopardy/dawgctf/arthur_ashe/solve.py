from pwn import *
import time

io = remote('arthurashe.ctf.umbccd.io', 8411)

io.recvuntil('?')
io.send('y')

final = []

while(True):
	time.sleep(0.05)
	next = io.recv()
	print(next)
	try:
		next = next.split('is ')[-1]
		next = next.split('.')[0]
		next = next.replace('love', '0')
		next = next.replace('set', '15')
		next = next.replace('game', '1000')
		next = next.split('-')
		next = [int(i) for i in next]
		result = '0' if next[0] > next[1] else '1'
		final.append(result)
		print('result: ' + repr(result))
		io.send(result)
		
	except:
		print(''.join(final))