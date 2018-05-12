import mysql.connector
import csv 
import numpy as np
from io import BytesIO
from numpy import array
from sklearn.naive_bayes import MultinomialNB
import pandas as pd
from Sense import sense
from currdate import findDate
from fanOff import turnOffFan
from fanOn import turnOnFan
from lightOff import turnOffLight
from lightOn import turnOnLight


def loadCsv(filename):
	lines = csv.reader(open(filename, "rt"))
	dataset = list(lines)
	for i in range(len(dataset)):
		dataset[i] = [x for x in dataset[i]]
	return dataset
    
def updateDB(lightStatus, fanStatus):

    cnx = mysql.connector.connect(user='root', password='',host='localhost',database='mydb')
    print('connected')

    cursor = cnx.cursor()

    query1 = ("UPDATE room SET status= "+lightStatus+" WHERE roomID=1 AND deviceType=1")
    query2 = ("UPDATE room SET status= "+fanStatus+" WHERE roomID=1 AND deviceType=2")
    cursor.execute(query1)
    cursor.execute(query2)
    cnx.commit()
    cursor.close()
    print('updated')
    cnx.close()

#row_count = sum(1 for row in csv.reader( open('final_csv.csv') ) )
#with open(final_csv,"r") as f:
#    reader = csv.reader(f,delimiter = ",")
#    data = list(reader)
#    row_count = len(data)


filename = 'final_csv.csv'
training_dataset = loadCsv(filename)
row_count1 = len(training_dataset)

last_line = [[]]
last_line[0] = training_dataset[len(training_dataset)-1]
training_dataset = training_dataset[1:len(training_dataset)-1]
training_dataset = np.array(training_dataset)
training_predict_light = training_dataset[:,9:10]
training_predict_fan = training_dataset[:,10:11]
training_dataset = training_dataset[:,0:9]
#print(filename)
#print(training_dataset)
#print(training_dataset)
#print(training_predict_light)


#myfilePath = './final_csv.csv'
#file = object.myfilePath
#fileObject = csv.reader(file)
#row_count = sum(1 for row in fileObject)  # fileObject is your csv.reader

nb = MultinomialNB()
nb1 = MultinomialNB()
x = np.array(training_dataset).astype(int)
y1 = np.array(training_predict_light)
y1 = y1.ravel()
y2 = np.array(training_predict_fan)
y2 = y2.ravel()
#y2 = np.array(training_predict_fan)
#y2 = y2.ravel()6
#y = array(training_predict)
#print(y)
i = 1;
while(i<=100):
    nb.fit(x, y1)
    nb1.fit(x, y2)
    #print(x[12][7])

    #print(row_count)
    #print(row_count1)
    #print(last_line)

    hour,minute,second,date,month,day= findDate()
    temperature,humanDetect,illuminance = sense()
    print(hour,minute,second,date,month,day,temperature,humanDetect,illuminance)

    '''
    IF YOU WANT TO GIVE ENTRIES MANUALY, THEN TEST HERE

    hour=23
    minute=0
    second=0
    date=28
    month=2
    day=3
    tempurature=21
    humanDetect=1
    illuminance=0
    '''

    a=[hour,minute,second,date,month,day,temperature,humanDetect,illuminance]
    np.asarray(a)

    lightState = int(nb.predict([a]).tolist()[0])
    fan = int(nb1.predict([a]).tolist()[0])

    if(humanDetect==0):
        lightState=0
        fan=0

    if(illuminance==0):
        lightState=0
    rows = [[hour,minute,second,date,month,day,temperature,humanDetect,illuminance,lightState,fan]]
    #name of csv file
    filename = "newDAY.csv"
    # writing to csv file

    stringLightState = str(lightState)
    stringFan = str(fan)

    print(stringLightState+" "+stringFan);

    updateDB(stringLightState, stringFan);

    if(lightState==0):
        turnOffLight()
    if(lightState==1):
        turnOnLight()
    if(fan==0):
        turnOffFan()
    if(fan==1):
        turnOnFan(1,2,fan)

    with open(filename, 'a') as csvfile:
        # creating a csv writer object
        csvwriter = csv.writer(csvfile)
        # writing the fields
        #csvwriter.writerow(fields)
        #writing the data rows
        csvwriter.writerows(rows)
    i = i+1
