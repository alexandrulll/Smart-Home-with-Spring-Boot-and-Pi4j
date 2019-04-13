package com.example.scutaru.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@RestController
@RequestMapping(value = "/relay")
public class RelayController {

	@PostMapping("/first-switch/on")
	public ResponseEntity<PinState> switchOnFirstRelay()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		final GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput firstRelayPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);
		firstRelayPin.high();

		gpio.shutdown();
		gpio.unprovisionPin(firstRelayPin);
		return new ResponseEntity<PinState>(firstRelayPin.getState(), HttpStatus.CREATED);
	}

	@PostMapping("/first-switch/off")
	public ResponseEntity<PinState> switchOffFirstRelay()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		final GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput firstRelayPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);
		firstRelayPin.low();

		gpio.shutdown();
		gpio.unprovisionPin(firstRelayPin);
		return new ResponseEntity<PinState>(firstRelayPin.getState(), HttpStatus.CREATED);
	}

	@PostMapping("/second-switch/on")
	public ResponseEntity<PinState> switchOnSecondRelay()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		final GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput secondRelayPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27);
		secondRelayPin.high();

		gpio.shutdown();
		gpio.unprovisionPin(secondRelayPin);
		return new ResponseEntity<PinState>(secondRelayPin.getState(), HttpStatus.CREATED);
	}

	@PostMapping("/second-switch/off")
	public ResponseEntity<PinState> switchOffSecondRelay()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		final GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput secondRelayPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27);
		secondRelayPin.low();

		gpio.shutdown();
		gpio.unprovisionPin(secondRelayPin);
		return new ResponseEntity<PinState>(secondRelayPin.getState(), HttpStatus.CREATED);
	}

}