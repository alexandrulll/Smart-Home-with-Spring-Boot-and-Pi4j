package com.example.scutaru.service.impl;

import org.springframework.stereotype.Service;

import com.example.scutaru.service.RelayService;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@Service
public class RelayServiceImpl implements RelayService {

	public PinState switchOnRelay(Integer gpioPin, Boolean isOn) {

		final GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput firstRelayPin = gpio.provisionDigitalOutputPin(RaspiPin.getPinByAddress(gpioPin));

		if (isOn.equals(true)) {
			firstRelayPin.high();
		} else {
			firstRelayPin.low();
		}
		
		gpio.shutdown();
		gpio.unprovisionPin(firstRelayPin);

		return firstRelayPin.getState();
	}

	public PinState switchOffRelay(Integer gpioPin) {

		final GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput secondRelayPin = gpio.provisionDigitalOutputPin(RaspiPin.getPinByAddress(gpioPin));
		secondRelayPin.low();

		gpio.shutdown();
		gpio.unprovisionPin(secondRelayPin);
		return secondRelayPin.getState();
	}
}
