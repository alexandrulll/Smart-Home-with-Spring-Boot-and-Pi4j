package com.example.scutaru.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.domain.MotionSensor;
import com.example.scutaru.repository.MotionRepository;
import com.example.scutaru.service.MotionSensorService;
import com.example.scutaru.utlis.SensorConstants;
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

@Service
public class MotionSensorImpl implements MotionSensorService {

	private final MotionRepository motionRepository;

	@Autowired
	public MotionSensorImpl(MotionRepository motionRepository) {
		this.motionRepository = motionRepository;

	}

	@Override
	public List<MotionSensor> findAll() {
		return motionRepository.findAll();
	}

	@Override
	public void detectMotionAndGlowLED() {

		GpioUtil.enableNonPrivilegedAccess();

		final GpioController gpioPIRMotionSensor = GpioFactory.getInstance();
		final GpioPinDigitalInput pirMotionsensor = gpioPIRMotionSensor.provisionDigitalInputPin(RaspiPin.GPIO_05,
				PinPullResistance.PULL_DOWN);

		final GpioController gpioLED = GpioFactory.getInstance();
		final GpioPinDigitalOutput led = gpioLED.provisionDigitalOutputPin(RaspiPin.GPIO_01, "LED", PinState.LOW);
		led.low();

		pirMotionsensor.addListener(new GpioPinListenerDigital() {

			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {

				if (event.getState().isHigh()) {

					MotionSensor motionSensor = new MotionSensor();
					motionSensor.setTimeStamp(System.currentTimeMillis());
					motionSensor.setAlertText(SensorConstants.PIR_SENSOR);
					motionRepository.save(motionSensor);

					led.high();
				}

				if (event.getState().isLow()) {
					led.low();

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

}
