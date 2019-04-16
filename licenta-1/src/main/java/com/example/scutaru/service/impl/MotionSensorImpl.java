package com.example.scutaru.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.service.GPIOPinProviderService;
import com.example.scutaru.service.MotionSensorService;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.trigger.GpioCallbackTrigger;
import com.pi4j.wiringpi.GpioUtil;

@Service
public class MotionSensorImpl implements MotionSensorService {

	private final GPIOPinProviderService gpioPinProviderService;
	//private final List<Integer> list = new ArrayList<>();

	@Autowired
	public MotionSensorImpl(GPIOPinProviderService gpioPinProviderService) {
		this.gpioPinProviderService = gpioPinProviderService;
	}

	/*@PostConstruct
	public void init() {
		
		gpioPinProviderService.provideDigitalInputPin().addTrigger(
				new GpioCallbackTrigger(PinState.HIGH, this::motionStarted),
				new GpioCallbackTrigger(PinState.LOW, this::motionEnded));

	}*/

	public void detectMotionAndGlowLED(Integer pirPin, Integer ledPin) {

		GpioUtil.enableNonPrivilegedAccess();

		gpioPinProviderService.provideDigitalOutputPin(ledPin).low();
		gpioPinProviderService.provideDigitalInputPin(pirPin).addListener(new GpioPinListenerDigital() {

			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {

				if (event.getState().isHigh()) {
					gpioPinProviderService.provideDigitalOutputPin(ledPin).high();
				}

				if (event.getState().isLow()) {
					gpioPinProviderService.provideDigitalOutputPin(ledPin).low();

				}
			}
		});

		try {

			for (;;) {

			}
		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/*private Void motionStarted() {
		this.list.stream()
				 .collect(Collectors.toList())
				 .add(1);
		
		return null;
	}

	private Void motionEnded() {
		return null;
	}
	
	@Override
	public List<Integer> getMotions(){
		return this.list.stream()
				.collect(Collectors.toList());
	}*/
}
