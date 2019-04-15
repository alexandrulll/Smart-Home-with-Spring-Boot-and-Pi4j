package com.example.scutaru.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@Service
public class RelayService {

	public PinState switchOnFirstRelay() throws UnsupportedBusNumberException, IOException, InterruptedException {

		final GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput firstRelayPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);
		firstRelayPin.high();

		gpio.shutdown();
		gpio.unprovisionPin(firstRelayPin);

		return firstRelayPin.getState();
	}

	public PinState switchOnSecondRelay() throws UnsupportedBusNumberException, IOException, InterruptedException {

		final GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput secondRelayPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27);
		secondRelayPin.high();

		gpio.shutdown();
		gpio.unprovisionPin(secondRelayPin);
		return secondRelayPin.getState();
	}

	public PinState switchOffFirstRelay() throws UnsupportedBusNumberException, IOException, InterruptedException {

		final GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput firstRelayPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);
		firstRelayPin.low();

		gpio.shutdown();
		gpio.unprovisionPin(firstRelayPin);
		return firstRelayPin.getState();
	}

	public PinState switchOffSecondRelay() throws UnsupportedBusNumberException, IOException, InterruptedException {

		final GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput secondRelayPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27);
		secondRelayPin.low();

		gpio.shutdown();
		gpio.unprovisionPin(secondRelayPin);
		return secondRelayPin.getState();
	}
}
