import RPi.GPIO as GPIO
import time
import sys
GPIO.setmode(GPIO.BOARD)
 
# Setup GPIO Pins
#GPIO.setup(12, GPIO.OUT)
#GPIO.setup(32, GPIO.OUT)

GPIO.setup(33, GPIO.OUT)
#GPIO.setup(35, GPIO.OUT)
 
# Set PWM instance and their frequency
#pwm12 = GPIO.PWM(12, 0.5)
#wm32 = GPIO.PWM(32, 0.75)
pwm33 = GPIO.PWM(33, 10)
#pwm35 = GPIO.PWM(35, 0.87)
 
# Start PWM with 50% Duty Cycle
#pwm12.start(50)
#pwm32.start(50)


#pwm33.start(60)

if(sys.argv[1]=="1" and sys.argv[2]=="2" and sys.argv[3]=="1"):
    pwm33.start(50)
    time.sleep(5) 
    #pwm33.stop()
#pwm35.start(50)
    
elif(sys.argv[1]=="1" and sys.argv[2]=="2" and sys.argv[3]=="2"):
    pwm33.start(60)
    time.sleep(5) 
    #pwm33.stop()
    
    
elif(sys.argv[1]=="1" and sys.argv[2]=="2" and sys.argv[3]=="3"):
    pwm33.start(70)
    time.sleep(5) 
    #pwm33.stop()
    
    
elif(sys.argv[1]=="1" and sys.argv[2]=="2" and sys.argv[3]=="4"):
    pwm33.start(85)
    time.sleep(5) 
    #pwm33.stop()
    
    
elif(sys.argv[1]=="1" and sys.argv[2]=="2" and sys.argv[3]=="5"):
    pwm33.start(100)
    time.sleep(5) 
    #pwm33.stop()
 
#raw_input('Press return to stop:')	#Wait
#time.sleep(5) 
# Stops the PWM
#pwm12.stop()
#pwm32.stop()
#pwm33.stop()
#pwm35.stop()
print("chala")
# Cleans the GPIO
#GPIO.OUTPUT("0")