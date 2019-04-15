package com.example.scutaru.service;

import com.pi4j.io.gpio.PinState;

public interface RelayService {

	PinState switchOnOffRelay(Integer gpioPin, Boolean isOn);
	
}
