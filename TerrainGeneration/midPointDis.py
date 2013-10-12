from Queue import Queue
from random import randint, uniform
from math import log


def translate(dimension, row, col):
	return row * dimension + col


def getIndex(array, dimension, row, col):
	return array[row * dimension + col]


def setIndex(array, dimension, row, col, val):
	array[row *dimension + col] = val


#################### dimension of subgrid ##############################
def getSquare(array, actualDimension, dimension, x, y):
	halfDim = dimension / 2

	a = getIndex(array, actualDimension, x - halfDim, y - halfDim)
	b = getIndex(array, actualDimension, x - halfDim, y + halfDim)
	c = getIndex(array, actualDimension, x + halfDim, y + halfDim)
	d = getIndex(array, actualDimension, x + halfDim, y - halfDim) 

	return [a, b, c, d]


def getDiamond(array, actualDimension, dimension, x, y):
	halfDim = dimension / 2

	a = translate(actualDimension, x - halfDim, y) 
	b = translate(actualDimension, x, y + halfDim)
	c = translate(actualDimension, x + halfDim, y)
	d = translate(actualDimension, x, y - halfDim)	
	return [a, b, c, d]


def getMidPointIndex(x, y, dimension, actualDimension, queue):
	
#	print "Midpoint : (%s, %s, %s)" % (x, y, dimension)
	if dimension <= 2:
		return

	halfDim = dimension / 2 / 2


	a = (x - halfDim, y - halfDim, dimension / 2)
	b = (x - halfDim, y + halfDim, dimension / 2)
	c = (x + halfDim, y + halfDim, dimension / 2)
	d = (x + halfDim ,y - halfDim, dimension / 2)

	if (a[0] < actualDimension) and (a[1] < actualDimension):
		queue.put(a)
#		print "put (%s, %s, %s)" % (a[0], a[1], a[2])
	if (b[0] < actualDimension) and (b[1] < actualDimension):
		queue.put(b)
#		print "put (%s, %s, %s)" % (b[0], b[1], b[2]) 
	if (c[0] < actualDimension) and (c[1] < actualDimension):
		queue.put(c)
#		print "put (%s, %s, %s)" % (c[0], c[1], c[2])
	if (d[0] < actualDimension) and (d[1] < actualDimension):
		queue.put(d)
#		print "put (%s, %s, %s)" % (d[0], d[1], d[2])



#########################################################################



def generate(initVal, size = 1024):
	if int(log(size) % log(2)) != 0:
		raise Exception("Invalid dimension")


	vertexGridDimension = size + 1
	vertexGrid = [None] * (vertexGridDimension * vertexGridDimension)
	
	setIndex(vertexGrid, vertexGridDimension, 0, 0, initVal)
	setIndex(vertexGrid, vertexGridDimension, 0, vertexGridDimension - 1, initVal)
	setIndex(vertexGrid, vertexGridDimension, vertexGridDimension - 1, 0, initVal)
	setIndex(vertexGrid, vertexGridDimension, vertexGridDimension - 1, vertexGridDimension - 1, initVal)

	queue = Queue()
	initPoint = ((vertexGridDimension - 1) / 2, (vertexGridDimension - 1) / 2, vertexGridDimension)
	queue.put(initPoint)

	rangeRand = 255.0

	while not queue.empty():
		midPoint = queue.get()
		getMidPointIndex(midPoint[0], midPoint[1], midPoint[2], vertexGridDimension, queue)	
	
		square = getSquare(vertexGrid, vertexGridDimension, midPoint[2], midPoint[0], midPoint[1])
		setIndex(vertexGrid, vertexGridDimension, midPoint[0], midPoint[1], ((square[0] + square[1] + square[2] + square[3]) / 4) + uniform(rangeRand - 0.5, rangeRand))
		
		diamond = getDiamond(vertexGrid, vertexGridDimension, midPoint[2], midPoint[0], midPoint[1])
		vertexGrid[diamond[0]] = ((square[0] + square[1]) / 2) + uniform(-rangeRand, rangeRand)
		vertexGrid[diamond[1]] = ((square[1] + square[2]) / 2) + uniform(-rangeRand, rangeRand)
		vertexGrid[diamond[2]] = ((square[2] + square[3]) / 2) + uniform(-rangeRand, rangeRand)
		vertexGrid[diamond[3]] = ((square[3] + square[0]) / 2) + uniform(-rangeRand, rangeRand)
		rangeRand = rangeRand * 0.7

	return vertexGrid
