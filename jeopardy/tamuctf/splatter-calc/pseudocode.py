from z3 import *
from pwn import *

long_mask = 0xffffffffffffffff

zero = lambda a, b: a
one = lambda a, b: a + b
two = lambda a, b: a - b
three = lambda a, b: a * b
four = lambda a, b: a * a
five = lambda a, b: 0 if (b > 64) else a << b
six = lambda a, b: a >> b
seven = lambda a, b: a ^ b

messup = lambda a: (0x83F66D0E3 * a + 0x24A452F8E) & long_mask
lambda_chart = [zero, one, two, three, four, five, six, seven]

def do_next(input, result):
	next_lambda = lambda_chart[input % 8]
	
	print("%d, %d, %d" % (result, input, input % 8))
	result = next_lambda(result, input) & long_mask
	input = (0x83F66D0E3 * input + 0x24A452F8E) & long_mask
	
	return [input, result]
	
def do_rng(input):
	next = 0xcafebabe
	
	for i in range(8):
		input, next = do_next(input, next)
		
	return [input, next]

def mess_up(input):
	for i in range(8):
		input = messup(input)
	return input
	
input = int(input("Please enter an initial rng: "))
result = do_rng(input)

if result[0] == result[1]:
	print_flag()