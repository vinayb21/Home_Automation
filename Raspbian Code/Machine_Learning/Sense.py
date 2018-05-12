# importing the csv module
import csv
import datetime
import RPi.GPIO as GPIO
import RPi.GPIO as IO #Import GPIO library
import time
import sys
import Adafruit_DHT
import time
import math


def sense():
# tenperaturehumidity sensor
    humidity, temperature = Adafruit_DHT.read_retry(11, 14)
    temperature=format(temperature, '.1f')
    temperature = str(temperature)
    temperature = float(temperature)
    temperature = round(temperature)
    temperature = int(temperature)
    humidity=format(humidity, '.1f')



#pir sensor code
    GPIO.setmode(GPIO.BOARD)                          #Set GPIO pin numbering
    pir = 12
    #led = 13                                          #Associate pin 26 to pir
    GPIO.setup(pir, GPIO.IN)
    #GPIO.setup(led, GPIO.OUT)#Set pin as GPIO in 
    #print ("Waiting for sensor to settle")
    #time.sleep(2)                                     #Waiting 2 seconds for the sensor to initiate
    #print ("Detecting motion")
    p = 0
    count = 0
    if GPIO.input(pir):                            #Check whether pir is HIGH
        print ("Motion Detected!")
    #        time.sleep(2)                              #D1- Delay to avoid multiple detection
        count=1
        #GPIO.output(led,1)
        #time.sleep(1)
        #GPIO.output(led,0)
    #GPIO.cleanup()
    else:
        print("Not detected")
        #time.sleep(1)                              #D1- Delay to avoid multiple detection
    #time.sleep(0.1)                               #While loop delay should be less than detection(hardware) delay




#LDR 
    ldr = 10
    GPIO.setup(ldr, GPIO.IN)
    illuminance = 0
    if GPIO.input(ldr):                            #Check whether pir is HIGH
        print ("Andhera Detected!")
        illuminance=1
        #GPIO.output(led,0)
    else:
        illuminance=0
        print ("Ujalaa Detected!")
        #GPIO.output(led,1)
    
    
    #time.sleep(0.1)                               #While loop delay should be less than detection(hardware) delay   
    #LightState
    #lightState=select1.py()
    #ADD TO CSV
    '''
    illuminance=0
    temperature=35
    humanDetect=0
    
    
    #field names
    #fields = ['Name', 'Branch', 'Year', 'CGPA']
    #humanDetect=count
    # data rows of csv file
    
    rows = [[now.hour,now.minute,now.second,now.day,weekday.weekday(),now.month,illuminance,temperature,humanDetect]]
    #name of csv file
    filename = "newDAY.csv"
    # writing to csv file
    with open(filename, 'a') as csvfile:
        # creating a csv writer object
        csvwriter = csv.writer(csvfile)
        # writing the fields
        #csvwriter.writerow(fields)
        #writing the data rows
        csvwriter.writerows(rows)
    print("inserted")
'''
    humanDetect= 1
    time.sleep(1)
    return temperature,humanDetect,illuminance