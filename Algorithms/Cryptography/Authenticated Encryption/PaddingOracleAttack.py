import urllib.request
import urllib.error
import binascii

def toHex(num):
	hNum = hex(num)
	if num >= 0 and num <= 15:
		return '0' + hNum[2:]
	else:
		return hNum[2:]

sUrl = 'http://crypto-class.appspot.com/po?er='
sCt = 'f20bdba6ff29eed7b046d1df9fb7000058b1ffb4210a580f748b4ac714c001bd4a61044426fb515dad3f21f18aa577c0bdf302936266926ff37dbf7035d5eeb4'
bCt = binascii.unhexlify(sCt)

'''
Controlling Variables
'''

iNo_Blocks = (len(bCt)/16) - 1	#1 of the block is the IV
pBlock = iNo_Blocks
pBlock_p = pBlock - 1

iPos = 15		#positing within one block
iG = 0
iPadding = 1
sPt = ''		#hex string

'''
Start descrypting
'''
while pBlock != 0:
	next = False
	bBlock = bCt[int(pBlock_p * 16):int((pBlock_p * 16) + 16)]
	
	while next == False:
		bTemp_p = bBlock
		bTemp2_p = bTemp_p[:iPos] + binascii.unhexlify(toHex((bTemp_p[iPos] ^ iG ^ iPadding))) + bTemp_p[iPos + 1:]
		sTemp_p = binascii.hexlify(bTemp2_p)
		
		try:
			resp = urllib.request.urlopen(sUrl + sCt[:int(pBlock_p * 32)] + sTemp_p.decode("utf-8") + sCt[int((pBlock_p * 32) + 32):])
			if iPadding == 9 and iG == 9:
				print("---------------------------------------------------------------")
				sTemp3_p = ''
				iPadding = iPadding + 1
				
				'''
				updating the previous block
				'''
				i = iPos
				while i < len(bBlock):
					if i == iPos:
						sTemp3_p = sTemp3_p + (toHex(bBlock[i] ^ iG ^ iPadding))
					else:
						sTemp3_p = sTemp3_p + (toHex(bBlock[i] ^ iPadding ^ (iPadding - 1)))
					#print(sTemp3_p)
					i = i + 1
				bBlock = bBlock[:iPos] + binascii.unhexlify(sTemp3_p)
				#print(binascii.hexlify(bBlock))
				
				sPt = sPt + toHex(iG)		#save the result in a reversed order
				print("*** Block: ", pBlock, " Pos: ", iPos, " Char: ", chr(iG), "iG", iG, " iPadding", iPadding, " Gotcha !!! ***")
				
				iG = 0
				iPos = iPos - 1
				if iPos < 0:
					next = True	  #move to the next block
			else:
				iG = iG + 1
			
		except urllib.error.HTTPError as e:
			if e.code == 403:	   #iG is not the correct value
				#print("---------------------------------------------------------------")
				#print("Block: ", pBlock, " Pos: ", iPos, " iG: ", iG, " iPadding", iPadding, " Failed !!!")
				
				iG = iG + 1
			elif e.code == 404: #iG is correct
				print("---------------------------------------------------------------")
				sTemp3_p = ''
				iPadding = iPadding + 1
				
				'''
				updating the previous block
				'''
				i = iPos
				while i < len(bBlock):
					if i == iPos:
						sTemp3_p = sTemp3_p + (toHex(bBlock[i] ^ iG ^ iPadding))
					else:
						sTemp3_p = sTemp3_p + (toHex(bBlock[i] ^ iPadding ^ (iPadding - 1)))
					#print(sTemp3_p)
					i = i + 1
				bBlock = bBlock[:iPos] + binascii.unhexlify(sTemp3_p)
				#print(binascii.hexlify(bBlock))
				
				sPt = sPt + toHex(iG)		#save the result in a reversed order
				print("*** Block: ", pBlock, " Pos: ", iPos, " Char: ", chr(iG), "iG", iG, " iPadding", iPadding, " Gotcha !!! ***")
				
				iG = 0
				iPos = iPos - 1
				if iPos < 0:
					next = True	  #move to the next block
			else:
				print("Something is weird !!")
					
	#truncating the last block
	sCt = sCt[:int(pBlock * 32)]
	print(sCt)
	
	#move the pointer to the previous block
	pBlock = pBlock - 1
	pBlock_p = pBlock - 1
	
	iPos = 15
	iG = 0
	iPadding = 1
	
print(sPt)
print("Successfully")
					
	
	

	