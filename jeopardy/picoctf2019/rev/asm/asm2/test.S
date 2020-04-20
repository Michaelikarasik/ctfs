asm2:
	<+0>:	push   ebp
	<+1>:	mov    ebp,esp
	<+3>:	sub    esp,0x10
	<+6>:	mov    eax, arg2
	<+9>:	mov    i ,eax ; i = 0x15
	<+12>:	mov    eax, arg1
	<+15>:	mov    arg1 ,eax
	<+18>:	jmp    <asm2+31>
	<+20>:	add    i,0x1
	<+24>:	add    arg1,0xaf
	<+31>:	cmp    arg1,0xa3d3
	<+38>:	jle    <asm2+20>
	<+40>:	mov    eax, i
	<+43>:	leave  
	<+44>:	ret    

