package com.example.scutaru.service;

import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;

public interface GPIOPinProviderService {

	GpioPinDigitalOutput provideDigitalOutputPin(Integer gpioPin);

	GpioPinDigitalInput provideDigitalInputPin(Integer gpioPin);

	GpioPinDigitalInput provideDigitalInputPin();
}