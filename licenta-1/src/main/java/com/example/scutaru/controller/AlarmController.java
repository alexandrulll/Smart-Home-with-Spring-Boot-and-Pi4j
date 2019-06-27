package com.example.scutaru.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scutaru.domain.Alarm;
import com.example.scutaru.dto.DustAlarmConfig;
import com.example.scutaru.dto.TemperatureAlarmConfig;
import com.example.scutaru.repository.TemperatureAlarmConfigRepository;
import com.example.scutaru.service.AlarmService;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@RestController
@RequestMapping(value = "api/alarms")
public class AlarmController {

	private final AlarmService alarmService;
	private final TemperatureAlarmConfigRepository temperatureAlarmConfigRepository;

	@Autowired
	public AlarmController(AlarmService alarmService, 
					TemperatureAlarmConfigRepository temperatureAlarmConfigRepository) {
		this.alarmService = alarmService;
		this.temperatureAlarmConfigRepository = temperatureAlarmConfigRepository;
	}

	@GetMapping("")
	public ResponseEntity<List<Alarm>> findAllAlarms() throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<>(alarmService.findAllAlarms(), HttpStatus.OK);
	}
	
	@PostMapping("/config")
	public ResponseEntity<TemperatureAlarmConfig> saveTemperatureConfig(TemperatureAlarmConfig temperatureAlarmConfig) {

		return new ResponseEntity<>(temperatureAlarmConfigRepository.save(temperatureAlarmConfig), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/config/dust/all")
	public ResponseEntity<List<DustAlarmConfig>> findAllDustConfig(DustAlarmConfig dustAlarmConfig) {
		
		return new ResponseEntity<>(alarmService.findAllDustConfig(), HttpStatus.OK);
	}
	
	@PostMapping("/config/dust")
	public ResponseEntity<DustAlarmConfig> saveDustConfig(DustAlarmConfig dustAlarmConfig) {
		alarmService.saveDustAlarmConfig(dustAlarmConfig);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/config/all")
	public ResponseEntity<List<TemperatureAlarmConfig>> getAll() {

		return new ResponseEntity<>(temperatureAlarmConfigRepository.findAll(), HttpStatus.OK);
	}
}
