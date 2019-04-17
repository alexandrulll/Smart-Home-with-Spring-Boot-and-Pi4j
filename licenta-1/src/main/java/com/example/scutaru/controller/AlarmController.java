package com.example.scutaru.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scutaru.domain.Alarm;
import com.example.scutaru.repository.AlarmRepository;
import com.example.scutaru.service.TemperatureService;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@RestController
@RequestMapping(value = "/alarms")
public class AlarmController {

	private final TemperatureService temperatureService;
	private final AlarmRepository alarmRepository;

	@Autowired
	public AlarmController(TemperatureService temperatureService, AlarmRepository alarmRepository) {
		this.temperatureService = temperatureService;
		this.alarmRepository = alarmRepository;
	}

	@GetMapping("/create")
	public ResponseEntity<Alarm> getAlarms() throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<>(temperatureService.saveTemperatureAlarms(), HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<List<Alarm>> findAllAlarms() throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<>(alarmRepository.findAll(), HttpStatus.OK);
	}
}
