import sys
import Adafruit_DHT
import time

while True:

    humidity, temperature = Adafruit_DHT.read_retry(11, 14)
    temperature=format(temperature, '.1f')
    humidity=format(humidity, '.1f')
    
    print("temp = "+temperature)
    print("humidity = "+humidity+" %")

    #print("Temp: {0:0.1f} C  Humidity: {1:0.1f} %".format(temperature, humidity))
    time.sleep(1)