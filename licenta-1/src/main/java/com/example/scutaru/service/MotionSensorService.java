package com.example.scutaru.service;

public interface MotionSensorService {

	void detectMotionAndGlowLED(Integer pirPin, Integer ledPin);

	//List<Integer> getMotions();
}
