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

filename = 'data.csv'
training_dataset = loadCsv(filename)
training_dataset = training_dataset[1:745]
training_dataset = np.array(training_dataset)
training_predict_light = training_dataset[:,9:10]
training_predict_fan = training_dataset[:,10:11]
training_dataset = training_dataset[:,0:9]
#print(filename)
#print(training_dataset)
#print(training_dataset)
#print(training_predict_light)

nb = MultinomialNB()
nb1 = MultinomialNB()
x = np.array(training_dataset).astype(int)
y1 = np.array(training_predict_light)
y1 = y1.ravel()
y2 = np.array(training_predict_fan)
y2 = y2.ravel()
#y2 = np.array(training_predict_fan)
#y2 = y2.ravel()
#y = array(training_predict)
#print(y)
nb.fit(x, y1)
nb1.fit(x, y2)
print(x[0])
print(nb.predict([x[0]]))
print(nb.predict([x[0]]))
