def check(my_input):
	if my_input[-1] == '\n':
		my_input = my_input[:-1]
	inp_len = len(my_input)
	callocd = [0] * (inp_len + 1)

	v4 = 0;
	v5 = 0;
	if inp_len <= 0:
		v4 = 0;
	else:
		while True:
			if v5:
				v6 = my_input[v4];
				v4 = v4 + 1
				callocd[v5] = v6;
			v5 = v5 + v4 + 2;
			
			if not (v5 < inp_len):
				break
		
		v7 = 0;
		v8 = 0;
		v30 = 0;
		v28 = 0;
		
		while True:
			v9 = my_input[v4];
			v4 = v4 + 1
			if ( not v30 ):
				v7 = 1;
			v10 = v28;
			v11 = v8 + 1;
			if ( v30 ):
				v10 = v11;
			v28 = v10;
			callocd[v30] = v9;
			v8 = v28;
			v7 = v7 + v28 + 2;
			v30 = v7;
			if not (v7 < inp_len ):
				break
		
		v12 = 1;
		i = 0
		while(v12 < inp_len):
			v14 = i + 1;
			if ( v12 < 7 ):
				v14 = i;
			i = v14;
			callocd[v12] = my_input[v4];
			v4 = v4 + 1
			
			v12 = v12 + v14 + 3
			
	v15 = len(my_input)
	v16 = 3;
	v30 = 3;
	if ( v4 < v15 ):
		v29 = 3;
		v17 = v15 - 3
		
		while True:
			v18 = v16;
			v19 = v16;
			v20 = (v17 - 3);
			if ( v30 ):
				v20 = v17;
			v21 = my_input[v4];
			v4 = v4 + 1
			callocd[v20] = v21;
			v26 = (v20 - 1)
			v22 = v29 - 1;
			if ( v18 ):
				v22 = v18;
			v23 = v29 - 1;
			v16 = v22 - 1;
			v30 = v16;
			if ( v19 ):
				v23 = v29;
				
			v29 = v23;
			v17 = v26;
			
			if not (v4 < v15 ):
				break
		
	return callocd

if __name__ == "__main__":
	inp = 'abcdefghijklmnopqrstuv'
	out = check(inp)
	places = [inp.find(i) for i in out[:-1]]

	want = 'welcome_to_the_jungle!'
	final = [0] * 22
	for index, i in enumerate(places):
		final[i] = want[index]

	print(''.join(final))