from Queue import Queue
from random import randint, uniform
from math import log


def translate(dimension, row, col):
	return row * dimension + col


def getIndex(array, dimension, row, col):
	return array[row * dimension + col]


def setIndex(array, dimension, row, col, val):
	array[row *dimension + col] = val


def getRandom(maxVal):
	rand = uniform(0.0, 1.0)

	return maxVal * (rand - 0.5)


#################### dimension of subgrid ##############################
def getSquare(array, actualDimension, dimension, x, y):
	a = getIndex(array, actualDimension, x - dimension, y - dimension)
	b = getIndex(array, actualDimension, x - dimension, y + dimension)
	c = getIndex(array, actualDimension, x + dimension, y + dimension)
	d = getIndex(array, actualDimension, x + dimension, y - dimension) 

	return [a, b, c, d]


def getDiamond(array, actualDimension, dimension, x, y):
	halfDim = dimension / 2

	a = translate(actualDimension, x - halfDim, y) 
	b = translate(actualDimension, x, y + halfDim)
	c = translate(actualDimension, x + halfDim, y)
	d = translate(actualDimension, x, y - halfDim)	
	return [a, b, c, d]




def generate(initValA, initValB, initValC, initValD, rangeRand = 255.0, diminish = 0.7, size = 1024):
	if int(log(size) % log(2)) != 0:
		raise Exception("Invalid Dimension")


	arraySize = size + 1
	array = [None] * (arraySize * arraySize)


	# Initialize 4 corners
	setIndex(array, arraySize, 0, 0, initValA + getRandom(2.0))
	setIndex(array, arraySize, 0, arraySize - 1, initValB + getRandom(2.0))
	setIndex(array, arraySize, arraySize - 1, 0, initValC + getRandom(2.0))
	setIndex(array, arraySize, arraySize - 1, arraySize - 1, initValD + getRandom(2.0))


	# Populate
	currentStep = arraySize / 2

	while currentStep > 0:
		rowOn = False

		for row in range(0, arraySize, currentStep):
			colOn = False
			
			for col in range(0, arraySize, currentStep):
				if rowOn or colOn:
					if rowOn and colOn:
						square = getSquare(array, arraySize, currentStep, row, col)
						setIndex(array, arraySize, row, col, (square[0] + square[1] + square[2] + square[3]) / 4.0 + getRandom(rangeRand))

					elif rowOn:
						top  = getIndex(array, arraySize, row - currentStep, col) 
						down = getIndex(array, arraySize, row + currentStep, col)

						setIndex(array, arraySize, row, col, (top + down) / 2.0 + getRandom(rangeRand))
				
					else:
						left  = getIndex(array, arraySize, row, col - currentStep) 
						right = getIndex(array, arraySize, row, col + currentStep)

						setIndex(array, arraySize, row, col, (left + right) / 2.0 + getRandom(rangeRand))
				colOn = not colOn
			rowOn = not rowOn

		currentStep = currentStep / 2
		rangeRand = rangeRand * diminish

	return array



