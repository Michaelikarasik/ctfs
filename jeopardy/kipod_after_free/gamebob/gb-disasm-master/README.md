gb-disasm
=========

GameBoy ROMs disassembler.

<pre>Usage: ./gb-disasm &lt;ROM&gt; -s &lt;HEX&gt; -b &lt;BANK&gt; -a -nc -nj
&lt;ROM&gt; -> obligatory, ROM file to be disassembled
  -s  -> optional, start address (PC), default is 0x100
  -e  -> optional, end adress (PC), default is 0x8000
  -b  -> optional, memory bank number, default is 1
  -a  -> optional, print assembly, default is print binary dump
  -nc -> optional, don't follow call instructions, default is to follow
  -nj -> optional, don't follow jump instructions, default is to follow</pre>

It is not finished and can disassemble only parts of the ROMs binaries.
I didn't test it extensively on ROMs with MBC (Memory Bank Controller).

Most of the code is autogenerated by script (generator.py) that uses 
opcodes table (opcodes.html) to generate parsing code in C.

To compile it on linux, in src directory execute `gcc main.c -O2 -o gb-disasm`.