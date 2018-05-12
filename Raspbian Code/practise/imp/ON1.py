import RPi.GPIO as GPIO
import RPi.GPIO as IO #Import GPIO library
import time
import sys #Import time library
#from furl import furl

#import mysql.connector

GPIO.setmode(GPIO.BOARD)                          #Set GPIO pin numbering

#roomID=sys.argv[1]

room = sys.argv[1]

deviceId = sys.argv[2]

pir = 11
        
if(sys.argv[1]=="1" and sys.argv[2]=="1"):
    pir = 11                                        #Associate pin 26 to pir
    
elif(sys.argv[1]=="2" and sys.argv[2]=="1"):
    pir = 13                                        #Associate pin 26 to pir
 
elif(sys.argv[1]=="3" and sys.argv[2]=="1"):
    pir = 15                                        #Associate pin 26 to pir

elif(sys.argv[1]=="4" and sys.argv[2]=="1"):
    pir = 29                                        #Associate pin 26 to pir

elif(sys.argv[1]=="5" and sys.argv[2]=="1"):
    pir = 31                                        #Associate pin 26 to pir

elif(sys.argv[1]=="6" and sys.argv[2]=="1"):
    pir = 33                                        #Associate pin 26 to pir

GPIO.setup(pir, GPIO.OUT)                          #Set pin as GPIO in
GPIO.output(pir,1)

print("on")

   