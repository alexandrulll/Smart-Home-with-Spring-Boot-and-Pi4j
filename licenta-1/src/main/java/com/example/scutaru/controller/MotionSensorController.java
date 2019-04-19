package com.example.scutaru.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scutaru.domain.MotionSensor;
import com.example.scutaru.service.MotionSensorService;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@RestController
@RequestMapping(value = "/motion")
public class MotionSensorController {

	private final MotionSensorService motionSensorService;

	@Autowired
	public MotionSensorController(MotionSensorService motionSensorService) {
		this.motionSensorService = motionSensorService;
	}

	@PostMapping("/start")
	public void startMotionSensor() throws UnsupportedBusNumberException, IOException, InterruptedException {

		motionSensorService.detectMotionAndGlowLED();
		return;
	}

	@GetMapping("/all")
	public List<MotionSensor> getLastDHT11Values()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return motionSensorService.findAll();

	}
}
