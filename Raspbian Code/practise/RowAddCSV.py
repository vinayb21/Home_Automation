# importing the csv module
import csv
import datetime
import RPi.GPIO as GPIO
import RPi.GPIO as IO #Import GPIO library
import time
import sys
import Adafruit_DHT
import time

x=0
# temp humid sensor code
while (x<10):

    humidity, temperature = Adafruit_DHT.read_retry(11, 11)
    temperature=format(temperature, '.1f')
    humidity=format(humidity, '.1f')
# pir sensor code
    GPIO.setmode(GPIO.BOARD)                          #Set GPIO pin numbering
    pir = 21
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
        GPIO.output(led,1)
        time.sleep(1)
        GPIO.output(led,0)
      #GPIO.cleanup()
    else:
        print("Not detected")
        time.sleep(1)                              #D1- Delay to avoid multiple detection
    GPIO.cleanup()
   #time.sleep(0.1)                               #While loop delay should be less than detection(hardware) delay
#LDR 
    ldr = 19
    #led = 15                                         #Associate pin 26 to pir
    GPIO.setup(ldr, GPIO.IN)
    #GPIO.setup(led, GPIO.OUT)#Set pin as GPIO in 
    #print ("Waiting for sensor to settle")
    time.sleep(2)                                     #Waiting 2 seconds for the sensor to initiate
    #print ("Detecting motion")
    illuminance = 0
    if GPIO.input(ldr):                            #Check whether pir is HIGH
        print ("Andhera Detected!")
        time.sleep(2)                              #D1- Delay to avoid multiple detection
        illuminance=0
      #GPIO.output(led,1)
      #time.sleep(5)
      #GPIO.output(led,0)
      #GPIO.cleanup()
    else:
    #print("Not detected")
        illuminance=1
        print ("Ujalaa Detected!")
        time.sleep(2)                              #D1- Delay to avoid multiple detection
    
    GPIO.cleanup()
    #time.sleep(0.1)                               #While loop delay should be less than detection(hardware) delay   
    #LightState
    #lightState=select1.py()
#ADD TO CSV
    now = datetime.datetime.now()
    weekday = datetime.datetime.today()
    print(now.year, now.month, now.day, now.hour, now.minute, now.second,weekday.weekday())
    #field names
    #fields = ['Name', 'Branch', 'Year', 'CGPA']
    humanDetect=count
    # data rows of csv file
    rows = [[now.hour,now.minute,now.second,now.day,weekday.weekday(),now.month,illuminance,temperature,humanDetect,fan,lightState]]
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
    x=x+1