import sys
import Adafruit_DHT
import time
x=0
while (x<5):
    

    humidity, temperature = Adafruit_DHT.read_retry(11, 11)
    #temperature="{0:0.1f}".format(temperature)
    #humidity="{0:0.1f}".format(humidity)
    #format(temperature, '.1f')
    #format(humidity, '.1f')
    print(temperature)
    print(humidity)

    humidity=1.232323
    temperature=4.3346246
    temperature=format(temperature, '.1f')
    humidity=format(humidity, '.1f')

    #print("Temp: {0:0.1f} C  Humidity: {1:0.1f} %"+format(temperature, humidity))
    
    print(x)
    x=x+1
    print(temperature)
    print(humidity)