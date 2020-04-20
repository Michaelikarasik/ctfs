filename = AskFile(1, "*.bin", "Output file name")
address = AskLong(1, "address: ")
size = AskLong(1, "size: ")
dbgr = False
with open(filename, "wb") as out:
	data = GetManyBytes(address, size, use_dbg=dbgr)
	out.write(data)
	out.close()	