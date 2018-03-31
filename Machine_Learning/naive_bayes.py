import csv 
import numpy as np
from numpy import array
from sklearn.naive_bayes import MultinomialNB

def loadCsv(filename):
	lines = csv.reader(open(filename, "rt"))
	dataset = list(lines)
	for i in range(len(dataset)):
		dataset[i] = [x for x in dataset[i]]
	return dataset

filename = 'sampleData.csv'
training_dataset = loadCsv(filename)
training_dataset = training_dataset[1:]
training_dataset = np.array(training_dataset)
training_predict = training_dataset[:,6:7]
training_dataset = training_dataset[:,0:6]
#print(filename)
#print(training_dataset)
#print(training_dataset)
#print(training_predict)

nb = MultinomialNB()
x = np.array(training_dataset).astype(int)
y = np.array([0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1])
y = array(y)
#print(y)
nb.fit(x, y)
print(nb.predict([x[0]]))
