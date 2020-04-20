import numpy as np
from PIL import Image

filename = input("filename: ")
img_vals = np.fromfile(filename, dtype='b')
print(len(img_vals))
img_vals = np.array(np.split(img_vals[:90000], 0x96))
print(type(img_vals))
img = Image.fromarray(img_vals)
img.show()