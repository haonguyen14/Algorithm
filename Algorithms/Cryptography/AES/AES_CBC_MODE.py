from Crypto.Cipher import AES
from Crypto import Random
import binascii



cipher_text_str = "69dda8455c7dd4254bf353b773304eec0ec7702330098ce7f7520d1cbbb20fc388d1b0adb5054dbd7370849dbf0b88d393f252e764f1f5f7ad97ef79d59ce29f5f51eeca32eabedd9afa9329"
cipher_key_str = "36f18357be4dbd77f050515c73fcf9f2"

if cipher_text_str != "" and cipher_key_str != "":
	cipher_key = binascii.unhexlify(cipher_key_str)
	cipher_text = binascii.unhexlify(cipher_text_str)

	#parse iv from cipher_text
	iv = binascii.unhexlify(cipher_text_str[:32])

	#decrypting
	cipher = AES.new(cipher_key, AES.MODE_CBC, iv)
	plain_text = cipher.decrypt(cipher_text)[16:]
	
	print(plain_text)
else:
	print("Please enter input !!")