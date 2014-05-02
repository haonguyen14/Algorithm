from Crypto.Hash import SHA256


block_ptr = -1			#block pointer used for the function getBlock, count from right to left
fileContent = b''		#file content is saved here

def getBlock(lHash=b''):
	#lHash is a bytes object
	
	global block_ptr
	block_ptr = block_ptr + 1
	
	num_blocks = (int)(len(fileContent) / 1024)
	
	if block_ptr == 0:	#don't need to append the hash into the first block
		return fileContent[(int)(num_blocks * 1024):]
	else:
		start_point = (int)((num_blocks - block_ptr) * 1024)
		if start_point < 0:
			return b''
			
		return fileContent[start_point:start_point + 1024] + lHash
		

file = open('video.mp4', 'rb')
fileContent = file.read()

block = getBlock()
while block != b'':
	hashObj = SHA256.new(block)
	print(hashObj.hexdigest())
	block = getBlock(hashObj.digest())


