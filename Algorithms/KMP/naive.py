import sys


# Naive implementation - O(nm)
def patternMatching(string, pattern):
	currStrIndex = 0

	while currStrIndex < (len(string) - len(pattern) + 1):
		i = 0

		while i < len(pattern):
			if string[currStrIndex + i] != pattern[i]:
				break

			i = i + 1

		if i == len(pattern):
			print "[+] Found a match at %s" % currStrIndex

		currStrIndex = currStrIndex + 1



fd = open(sys.argv[2], "r+")
text = fd.read()


patternMatching(text, sys.argv[1])


