import RPi.GPIO as IO            # calling header file for GPIO’s of PI
import time
import sys
# Takes first name and last name via command 
# line arguments and then display them
print("Output from Python")# calling for time to provide delays in program

IO.setmode (IO.BOARD)       # programming the GPIO by BOARD pin numbers, GPIO21 is called as PIN40
IO.setup(11,IO.OUT)             # initialize digital pin40 as an output.
IO.output(11,1)                      # turn the LED on (making the voltage level HIGH)
time.sleep(1)                         # sleep for a second
IO.cleanup()                         # turn the LED off (making all the output pins LOW)
time.sleep(1)                        #sleep for a second    

#loop is executed second time        
IO.setmode (IO.BOARD)
IO.setup(11,IO.OUT)
IO.output(11,1)
time.sleep(1)
IO.cleanup()
time.sleep(1)

#loop is executed third time
IO.setmode (IO.BOARD)
IO.setup(11,IO.OUT)
IO.output(11,1)
time.sleep(1)
IO.cleanup()
time.sleep(1)