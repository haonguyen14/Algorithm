from LPS import LPS


def KMP(string, pat):
	
	# Construct LPS for pattern string
	lps = LPS(pat)
	print lps


	# Pattern Matching
	currStrIndex = 0
	currPatIndex = 0

	while currStrIndex < (len(string) - len(pat) + 1):
		while currPatIndex < len(pat):
			if string[currStrIndex + currPatIndex] != pat[currPatIndex]:
				break
			currPatIndex = currPatIndex + 1
		
		if currPatIndex == len(pat):
			print "[+] Found a match at %s" % (currStrIndex)
		else:
			pass

		# Sliding
		if currPatIndex > 0:
			currStrIndex = currStrIndex + (currPatIndex - lps[currPatIndex - 1])
			currPatIndex = lps[currPatIndex - 1]
		else:
			currStrIndex = currStrIndex + 1


import sys

fd = open(sys.argv[2], "r+")
text = fd.read()

KMP(text, sys.argv[1])



	

		
