import subprocess as sp
import os

proc = sp.Popen("./a_happy_family")
file_name = sp.check_output(["./generate_fifo", str(proc.pid)]).strip("\n")

print("creating fifo file: %s" % file_name)

os.mkfifo(file_name)

payload = "insert eyzenberg magic"

with open(file_name, "w") as f:
	f.write(payload)
	f.close()
	