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
import com.example.scutaru.dto.TemperatureAlarmConfigDTO;
import com.example.scutaru.service.AlarmService;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@RestController
@RequestMapping(value = "api/alarms")
public class AlarmController {

	private final AlarmService alarmService;

	@Autowired
	public AlarmController(AlarmService alarmService) {
		this.alarmService = alarmService;
	}

	@GetMapping("")
	public ResponseEntity<List<Alarm>> findAllAlarms() throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<>(alarmService.findAllAlarms(), HttpStatus.OK);
	}
	
	@PostMapping("/config")
	public ResponseEntity<TemperatureAlarmConfigDTO> saveTemperatureConfig(TemperatureAlarmConfigDTO temperatureAlarmConfig) {
		alarmService.saveTemperatureAlarmConfig(temperatureAlarmConfig);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/config/dust")
	public ResponseEntity<DustAlarmConfig> saveDustConfig(DustAlarmConfig dustAlarmConfig) {
		alarmService.saveDustAlarmConfig(dustAlarmConfig);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
