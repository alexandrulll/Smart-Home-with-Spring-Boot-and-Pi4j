package com.example.scutaru.service;

import java.util.List;

import com.example.scutaru.domain.MotionSensor;

public interface MotionSensorService {

	void detectMotionAndGlowLED();

	List<MotionSensor> findAll();

	MotionSensor findLatest();

}
