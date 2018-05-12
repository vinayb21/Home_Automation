import RPi.GPIO as GPIO            # calling header file for GPGPIO’s of PI
import time
import sys
# Takes first name and last name via command 
# line arguments and then display them
#print("Output from Python")# calling for time to provide delays in program

GPIO.setmode (GPIO.BOARD)       # programming the GPGPIO by BOARD pin numbers, GPGPIO21 is called as PIN40
GPIO.setup(35,GPIO.OUT)             # initialize digital pin40 as an output.
GPIO.output(35,0)                      # turn the LED on (making the voltage level HIGH)
"""time.sleep(1)                         # sleep for a second
GPIO.output(11,0)                         # turn the LED off (making all the output pins LOW)
time.sleep(1)                        #sleep for a second    

#loop is executed second time        
#GPIO.setmode (GPIO.BOARD)
GPIO.setup(11,GPIO.OUT)
GPIO.output(11,1)
time.sleep(1)
GPIO.output(11,0)
time.sleep(1)

#loop is executed third time
#GPIO.setmode (GPIO.BOARD)
GPIO.setup(11,GPIO.OUT)
GPIO.output(11,1)
time.sleep(1)
GPIO.output(11,0)
time.sleep(1)
print("ab aaya maza")
"""