import Adafruit_DHT
import time

sensor = Adafruit_DHT.DHT11

pin = 23
humidity, temperature = Adafruit_DHT.read_retry(sensor, pin)

while True:
	humidity, temperature = Adafruit_DHT.read_retry(sensor, pin)
	if humidity is not None and temperature is not None:	
		print temperature, humidity
	else:
		print('Failed to get reading. Try again!')
	time.sleep(.500)
