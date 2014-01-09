import sys

# Find the longest prefix suffix of a string
# Dynamic Programming
		 

def LPS(string):
	lps = [0] * len(string)
	
	prevLen = lps[0]
	i = 1
	
	while i < len(lps):
		if string[prevLen] == string[i]:
			prevLen = prevLen + 1
			lps[i] = prevLen

			i = i + 1
		else:
			if prevLen == 0:
				lps[i] = 0
				i = i + 1
			else:
				prevLen = lps[prevLen - 1]
			

	return lps




