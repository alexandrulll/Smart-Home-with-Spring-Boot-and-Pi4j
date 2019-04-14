package com.agilerrules.pi4j.sensors;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.wiringpi.GpioUtil;

public class PirMotionDetection {
	
	public void detectMotionAndGlowLED(){
		System.out.println("Starting Pi4J Motion Sensor Example"); 
		System.out.println("PIR Motion Sensor is ready and looking for any movement..");

		GpioUtil.enableNonPrivilegedAccess();
	     
		final GpioController gpioPIRMotionSensor = GpioFactory.getInstance(); 
		final GpioPinDigitalInput pirMotionsensor = gpioPIRMotionSensor.provisionDigitalInputPin(RaspiPin.GPIO_05, PinPullResistance.PULL_DOWN);          
	               
		final GpioController gpioLED = GpioFactory.getInstance();           
		final GpioPinDigitalOutput led = gpioLED.provisionDigitalOutputPin(RaspiPin.GPIO_01,"LED",PinState.LOW);
		led.low();         
	           
		pirMotionsensor.addListener(new GpioPinListenerDigital() {
			
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {

				if(event.getState().isHigh()){  
		            System.out.println("Intruder Detected!"); 
		            led.high();
		        }   

		        if(event.getState().isLow()){   
		            System.out.println("All is quiet...");
		            led.low();
		        	
				} 
			}
		});
	
		try {           

		    for (;;) {      

		    }       
		}           
		catch (final Exception e) {         
		    System.out.println(e.getMessage());     
		}

	}
	
	public static void main(String args[]){
		PirMotionDetection pirMotionDetection = new PirMotionDetection();
		pirMotionDetection.detectMotionAndGlowLED();
		
	}

}
