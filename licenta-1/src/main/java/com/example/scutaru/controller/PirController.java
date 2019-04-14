package com.example.scutaru.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@RestController
@RequestMapping(value = "/pir")
public class PirController {

	@GetMapping("/motion")
	public ResponseEntity<String> getPirResponse()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		final GpioController gpioPIRMotionSensor = GpioFactory.getInstance();
		final GpioPinDigitalInput pirMotionsensor = gpioPIRMotionSensor.provisionDigitalInputPin(RaspiPin.GPIO_10,
				PinPullResistance.PULL_DOWN);
		gpioPIRMotionSensor.unprovisionPin(pirMotionsensor);

		pirMotionsensor.addListener(new GpioPinListenerDigital() {

			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if (event.getState().isHigh()) {
					System.out.println("Intruder Detected! LED is ON");

				}
				if (event.getState().isLow()) {
					System.out.println("All is quiet, LED is OFF");

				}
			}
		});
		return new ResponseEntity<String>("No readings available", HttpStatus.BAD_REQUEST);

	}
}