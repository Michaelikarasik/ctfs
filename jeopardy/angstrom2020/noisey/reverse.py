import numpy as np
import random

for j in range(20):
	data = np.array([random.gauss(0,2) for i in range(20)])

	average = np.average(data)

	print(average)
