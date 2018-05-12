import RPi.GPIO as GPIO
import time
import sys

def turnOffFan():
    GPIO.setmode(GPIO.BOARD)
    # Setup GPIO Pins
    GPIO.setup(33, GPIO.OUT)
    # Set PWM instance and their frequency
    pwm33 = GPIO.PWM(33, 10)
    pwm33.stop()
    print("ruk gya fan")
    # Cleans the GPIO
    #GPIO.OUTPUT("0")
    
