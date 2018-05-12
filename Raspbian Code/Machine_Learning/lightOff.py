import RPi.GPIO as GPIO
import RPi.GPIO as IO #Import GPIO library
import time
import sys


def turnOffLight():
    GPIO.setmode(GPIO.BOARD)                          #Set GPIO pin numbering
    pir = 11
    GPIO.setup(pir, GPIO.OUT)                          #Set pin as GPIO in
    GPIO.output(pir,0)
    print("off light")
