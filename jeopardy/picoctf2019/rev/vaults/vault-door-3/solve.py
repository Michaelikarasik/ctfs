final = "jU5t_a_sna_3lpm13g34c_u_4_m3rf48"

x = ['a'] * 32

for i in range(8):
    x[i] = final[i]

for i in range(8, 16):
    x[23 - i] = final[i]

for i in range(16, 32, 2):
    x[46 - i] = final[i]

for i in range(31, 16, -2):
    x[i] = final[i]

print(''.join(x))


