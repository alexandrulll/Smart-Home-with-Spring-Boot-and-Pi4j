package com.example.scutaru.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.util.CommandArgumentParser;

@RestController
@RequestMapping(value = "/relay")
public class RelayController {
	
	public static void main(String [] args) {
	
    final GpioController gpio = GpioFactory.getInstance();
    
    Pin pin = CommandArgumentParser.getPin(RaspiPin.class, RaspiPin.GPIO_06);             
    GpioPinDigitalOutput output = gpio.provisionDigitalOutputPin(pin, "My Output", PinState.HIGH);
    
    int i = 0;
    
	while(i < 10) {
		
    	output.high();
    	output.blink(1000);
    	output.low();
    	i++;
    	
    	}
	}
}