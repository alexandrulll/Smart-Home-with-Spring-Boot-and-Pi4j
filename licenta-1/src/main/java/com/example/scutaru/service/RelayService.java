package com.example.scutaru.service;

import com.pi4j.io.gpio.PinState;

public interface RelayService {

	PinState switchOnRelay(Integer gpioPin, Boolean isOn);

	PinState switchOffRelay(Integer gpioPin);
	
}
