import random


def gen():
	rand = random.random()

	if rand < 0.25:
		return "A"
	elif rand < 0.50:
		return "C"
	elif rand < 0.75:
		return "G"
	else:
		return "T"


text = ""
for i in range(0, 100000000):
	text = text + gen()


fd = open("gene.txt", "rw+")
fd.write(text)
fd.close()

