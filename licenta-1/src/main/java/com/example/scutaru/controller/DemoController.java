package com.example.scutaru.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

@RestController
@RequestMapping(value = "/demo")
class DemoRestController {

	@PostMapping("/open")
	public ResponseEntity<String> openRaspi() {

		final GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput greenLedPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
		greenLedPin.high();

		gpio.shutdown();
		gpio.unprovisionPin(greenLedPin);

		return new ResponseEntity<String>("Raspi is ON", HttpStatus.CREATED);

	}

	@PostMapping("/close")
	public ResponseEntity<String> closeRaspi() {

		final GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput greenLedPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
		greenLedPin.low();

		gpio.shutdown();
		gpio.unprovisionPin(greenLedPin);

		return new ResponseEntity<String>("Raspi is OFF", HttpStatus.CREATED);

	}
}
