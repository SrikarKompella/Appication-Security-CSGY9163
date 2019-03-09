import sys
from PIL import Image

#get image from image file path in initial command line argument
img = Image.open(sys.argv[1])

#get width and height of image
w = img.size[0]
h = img.size[1]

#always choose smaller dimension of the width / length as the side length for square
if (w < h):
    squaredImage = img.resize((w,w))
else:
    squaredImage = img.resize((h,h))

#save resized square image
squaredImage.save("resized-img", "PNG", optimize=True)

