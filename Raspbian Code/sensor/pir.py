import RPi.GPIO as GPIO
import RPi.GPIO as IO #Import GPIO library
import time                                       #Import time library
GPIO.setmode(GPIO.BOARD)                          #Set GPIO pin numbering
pir = 37
led = 13                                          #Associate pin 26 to pir
GPIO.setup(pir, GPIO.IN)
GPIO.setup(led, GPIO.OUT)#Set pin as GPIO in 
#print ("Waiting for sensor to settle")
time.sleep(2)                                     #Waiting 2 seconds for the sensor to initiate
#print ("Detecting motion")
count = 0
while (count<1):
   if GPIO.input(pir):                            #Check whether pir is HIGH
      print ("Motion Detected!")
      time.sleep(2)                              #D1- Delay to avoid multiple detection
      count=1
      GPIO.output(led,1)
      time.sleep(5)
      GPIO.output(led,0)
      #GPIO.cleanup()
   else:
   #   print("Not detected")
      time.sleep(2)                              #D1- Delay to avoid multiple detection
GPIO.cleanup()
   #time.sleep(0.1)                               #While loop delay should be less than detection(hardware) delay
   