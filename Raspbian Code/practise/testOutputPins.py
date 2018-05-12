import RPi.GPIO as GPIO
import RPi.GPIO as IO #Import GPIO library
GPIO.setmode(GPIO.BCM)
pin=2
for i in range(0,26):
    GPIO.setup(pin,GPIO.OUT)
#GPIO.setup(,GPIO.IN)
    state=GPIO.input(pin)
    pin= pin+1
    print(state)
