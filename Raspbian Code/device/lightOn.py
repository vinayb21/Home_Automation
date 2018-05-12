import RPi.GPIO as GPIO
import RPi.GPIO as IO #Import GPIO library
import time                                       #Import time library
GPIO.setmode(GPIO.BOARD)                          #Set GPIO pin numbering
pir = 11                                        #Associate pin 26 to pir
GPIO.setup(pir, GPIO.OUT)                          #Set pin as GPIO in
GPIO.output(pir,1)
time.sleep(2)

GPIO.output(pir,0)
time.sleep(2)
GPIO.output(pir,1)
time.sleep(2)
GPIO.output(pir,0)
time.sleep(2)
GPIO.output(pir,1)
time.sleep(2)
GPIO.output(pir,0)
time.sleep(2)

print("light on")
GPIO.Cleanup()