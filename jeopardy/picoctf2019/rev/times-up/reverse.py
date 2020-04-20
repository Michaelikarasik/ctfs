from pwn import *

finished = False
context.log_level = 'error'

io = None

while not finished:
	try:
		io = process("./times-up")
		
		try:
			question = io.recvuntil('\n')[11:]

			answer = str(eval(question) & 0xffffffff)

			io.send(answer + " ")

			print(io.recvall())

			finished = True

		except:
			pass

		finally:
			if io.poll == None:
				io.shutdown('send')
				io.wait_for_close()

	except:
		print("failed to start")
