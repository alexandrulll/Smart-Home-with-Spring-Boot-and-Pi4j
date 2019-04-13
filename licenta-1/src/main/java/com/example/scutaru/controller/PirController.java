package com.example.scutaru.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;
import com.pi4j.wiringpi.GpioUtil;

@RestController
@RequestMapping(value = "/pir")
public class PirController {

	@GetMapping("/motion")
	public void getPirResponse() throws UnsupportedBusNumberException, IOException, InterruptedException {

		try {

			for (;;) {

				GpioUtil.enableNonPrivilegedAccess();

				final GpioController gpioPIRMotionSensor = GpioFactory.getInstance();
				final GpioPinDigitalInput pirMotionsensor = gpioPIRMotionSensor
						.provisionDigitalInputPin(RaspiPin.GPIO_10, PinPullResistance.PULL_DOWN);
				gpioPIRMotionSensor.unprovisionPin(pirMotionsensor);
				
				final GpioController gpioLED = GpioFactory.getInstance();
				final GpioPinDigitalOutput led = gpioLED.provisionDigitalOutputPin(RaspiPin.GPIO_01, "LED",
						PinState.LOW);
				led.low();
				gpioLED.unprovisionPin(led);

				pirMotionsensor.addListener(new GpioPinListenerDigital() {

					public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
						if (event.getState().isHigh()) {
							System.out.println("Intruder Detected! LED is ON");
							led.high();

						}
						if (event.getState().isLow()) {
							System.out.println("All is quiet, LED is OFF");
							led.low();

						}
					}
				});
			}

		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}

	}
}