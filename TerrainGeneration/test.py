from DiamondSquare import generate
import midPointDis1 as d
import numpy
from PIL import Image
import sys



a = generate(float(sys.argv[1]), float(sys.argv[2]), float(sys.argv[3]), float(sys.argv[4]), float(sys.argv[5]), float(sys.argv[6]), 512)
print "Starting = %s, RandomRange = %s, Diminish = %s, Size = %s" % (sys.argv[1], sys.argv[2], sys.argv[3], 512)

ar = numpy.array(a)
ar = numpy.reshape(ar, (513, 513))

i = Image.fromarray(ar)
i.show()


a = d.generate(float(sys.argv[1]), float(sys.argv[2]), float(sys.argv[3]), float(sys.argv[4]), float(sys.argv[5]), float(sys.argv[6]), 512)
print "Starting = %s, RandomRange = %s, Diminish = %s, Size = %s" % (sys.argv[1], sys.argv[2], sys.argv[3], 512)

ar = numpy.array(a)
ar = numpy.reshape(ar, (513, 513))

i = Image.fromarray(ar)
i.show()
