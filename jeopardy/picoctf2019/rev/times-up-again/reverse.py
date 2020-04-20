from subprocess import *

io = Popen(["./times-up-again"], stdout=PIPE, stdin=PIPE)

io.stdin.write(str(eval(io.stdout.readline()[11:]) & 0xffffffff) + " ")

print(io.stdout.read())

'''import os
import sys

from pwn import *

finished = False
context.log_level = 'error'

io = process("./times-up-again")
io.send(str(eval(io.recvuntil('\n')[11:])) + " ")

print(io.recvall())

finished = True

if io.poll == None:
	io.shutdown('send')
	io.wait_for_close()'''