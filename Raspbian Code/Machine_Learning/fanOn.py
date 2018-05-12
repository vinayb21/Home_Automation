import RPi.GPIO as GPIO
import time
import sys

def turnOnFan(roomId,deviceType,status):
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
    
    
    if(roomId=="1" and deviceType=="2" and status=="1"):
        pwm33.start(50)
        time.sleep(10) 
        pwm33.stop()
    #pwm35.start(50)
    elif(roomId=="1" and deviceType=="2" and status=="2"):
        pwm33.start(60)
        time.sleep(10) 
        pwm33.stop()
    elif(roomId=="1" and deviceType=="2" and status=="3"):
        pwm33.start(70)
        time.sleep(10) 
        pwm33.stop()
    elif(roomId=="1" and deviceType=="2" and status=="4"):
        pwm33.start(85)
        time.sleep(10) 
        pwm33.stop()
    elif(roomId=="1" and deviceType=="2" and status=="5"):
        pwm33.start(100)
        time.sleep(10) 
        pwm33.stop()
    else:
        pwm33.start(40)
        return
        
    #pwm35.stop()
    print("chala fan")
    # Cleans the GPIO
    #GPIO.OUTPUT("0")
    