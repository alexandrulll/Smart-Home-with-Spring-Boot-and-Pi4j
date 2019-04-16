package com.example.scutaru.service.impl;

import org.springframework.stereotype.Service;

import com.example.scutaru.service.GPIOPinProviderService;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@Service
public class GPIOPinProviderServiceImpl implements GPIOPinProviderService {

	@Override
	public GpioPinDigitalOutput provideDigitalOutputPin(Integer gpioPin) {

		final GpioController gpioController = GpioFactory.getInstance();
		final GpioPinDigitalOutput digitalOutputPin = gpioController
				.provisionDigitalOutputPin(RaspiPin.getPinByAddress(gpioPin), PinState.LOW);

		gpioController.shutdown();
		gpioController.unprovisionPin(digitalOutputPin);

		return digitalOutputPin;
	}

	@Override
	public GpioPinDigitalInput provideDigitalInputPin(Integer gpioPin) {

		final GpioController gpioController = GpioFactory.getInstance();
		final GpioPinDigitalInput digitalInput = gpioController
				.provisionDigitalInputPin(RaspiPin.getPinByAddress(gpioPin), PinPullResistance.PULL_DOWN);

		gpioController.shutdown();
		gpioController.unprovisionPin(digitalInput);

		return digitalInput;
	}
	
	@Override
	public GpioPinDigitalInput provideDigitalInputPin() {

		final GpioController gpioController = GpioFactory.getInstance();
		final GpioPinDigitalInput digitalInput = gpioController .provisionDigitalInputPin((RaspiPin.GPIO_05), PinPullResistance.PULL_DOWN);

		//gpioController.shutdown();
		//gpioController.unprovisionPin(digitalInput);

		return digitalInput;
	}
}
