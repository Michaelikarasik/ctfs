from Crypto.Cipher import AES
import time
from hashlib import md5

def is_repeat(s):
	return all(s[i] == s[i-1] for i in range(len(s)))
	
def is_ascii(s):
    return all(ord(c) < 128 for c in s)
	
def main():
	with open("encrypted", 'r') as encrypted:
		flag = encrypted.read().decode("base64")
		encrypted.close()

	hour = 60 * 60
	day = hour * 24

	now = int(time.time())
	before = now - 2 * day - 2 * hour

	for i in range(before, now):
		key = md5(str(i)).digest()
		aes = AES.new(key, AES.MODE_ECB)
		result = aes.decrypt(flag)
		
		for j in range(len(result)):
			if(is_repeat(result[j:])):
				break
		
		flag_try = result[:j]
		if(is_ascii(flag_try)):
			print(flag_try)
		
if __name__ == "__main__":
	main()