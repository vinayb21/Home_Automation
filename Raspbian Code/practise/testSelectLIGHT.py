# importing the csv module
import csv
import datetime
import RPi.GPIO as GPIO
import RPi.GPIO as IO #Import GPIO library
import time
import sys
import Adafruit_DHT
import time
import select1

x=0
# temp humid sensor code
while (x<10):
    #LightState
    lightState=select1.light()
    print(lightState)
# ADD TO CSV
    now = datetime.datetime.now()
    weekday = datetime.datetime.today()
    print(now.year, now.month, now.day, now.hour, now.minute, now.second,weekday.weekday())
    x=x+1
