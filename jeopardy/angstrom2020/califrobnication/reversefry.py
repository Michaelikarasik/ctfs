with open('randarray.txt', 'r') as file:
        data = file.read()

data = data.split('\n')[:-1]
print(data)
data = [int(x) for x in data]

result = "tcomci0_fndr4nc2fcdi}r81a5a5of_ialf6toada49_e1b{"
result = list(result)

for i in range(len(data) - 1, -1, -1):
    c = result[i]
    result[i] = result[data[i]]
    result[data[i]] = c

print(''.join(result))
    
