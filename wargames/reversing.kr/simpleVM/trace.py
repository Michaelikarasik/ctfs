import gdb

gdb.execute("starti")

while(True):
    gdb.write (gdb.execute('x /i $pc', to_string=True).rstrip('\n'), gdb.STDOUT)
    gdb.execute("stepi", to_string=False)
    gdb.flush()
