from Crypto.Cipher import AES
import binascii


def counter(iv, pos):
	first_half = iv[:pos]
	second_half = iv[pos + 1:]
	
	old_val = iv[pos]
	new_val = (iv[pos] + 1) % (2**8)
	
	new_val_converted = hex(new_val)[2:]
	if new_val >=0 and new_val <= 15:
		new_val_converted = '0' + new_val_converted
	
	ret = first_half + binascii.unhexlify(new_val_converted) + second_half

	#checking
	if new_val < old_val:
		if pos - 1 < 0:
			return b'\x00' * 16
		ret = counter(ret, pos - 1)
	
	return ret

def strxor(str1, str2):
	#these strings are bytes objects
	#the function returns normal string with hexdecimal characters
	ret = ""
	if len(str1) <= len(str2):
		min = len(str1)
	else:
		min = len(str2)
		
	i = 0
	while i < min:
		temp = str1[i] ^ str2[i]
		if temp >= 0 and temp <= 15:
			temp = '0' + hex(temp)[2:]
		else:
			temp = hex(temp)[2:]
		ret = ret + temp
		i = i + 1
	return ret
	
#CRT MODE
cipher_text_str = "69dda8455c7dd4254bf353b773304eec0ec7702330098ce7f7520d1cbbb20fc388d1b0adb5054dbd7370849dbf0b88d393f252e764f1f5f7ad97ef79d59ce29f5f51eeca32eabedd9afa9329"
cipher_key_str = "36f18357be4dbd77f050515c73fcf9f2"

if cipher_text_str != "" and cipher_key_str != "":
	cipher_key = binascii.unhexlify(cipher_key_str)
	cipher_text = binascii.unhexlify(cipher_text_str[32:])	#truncating the iv from the ciphertext

	#parse iv(also called counter) from cipher_text
	iv = binascii.unhexlify(cipher_text_str[:32])
	
	#initialize the cipher
	cipher = AES.new(cipher_key)
	
	#start calculating CRT mode
	ret = ""
	i = 0	#block counter
	num_remaining_bytes = len(cipher_text) % 16
	num_blocks = (len(cipher_text) - num_remaining_bytes) / 16
	
	while i < num_blocks:
		#encrypting counter using key k in EBC mode
		enc = cipher.encrypt(iv)
		ret = ret + strxor(enc, cipher_text[(i*16):(i*16) + 16])
		iv = counter(iv, 15)
		i = i + 1
		
	enc = cipher.encrypt(iv)
	ret = ret + strxor(enc, cipher_text[int(16*num_blocks):])
	
	print(binascii.unhexlify(ret))
else:
	print("Please enter input !!")