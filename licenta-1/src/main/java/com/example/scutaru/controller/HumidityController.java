package com.example.scutaru.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scutaru.domain.Humidity;
import com.example.scutaru.dto.HumidityDTO;
import com.example.scutaru.service.AlarmCreationService;
import com.example.scutaru.service.HumidityService;
import com.example.scutaru.utlis.AlarmThresholdConstants;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@RestController
@RequestMapping(value = "/humidity")
public class HumidityController {

	private final HumidityService humidityService;
	private final AlarmCreationService alarmCreationService;

	@Autowired
	public HumidityController(HumidityService humidityService, AlarmCreationService alarmCreationService) {
		this.humidityService = humidityService;
		this.alarmCreationService = alarmCreationService;
	}

	@GetMapping("/save")
	public ResponseEntity<Humidity> saveValue()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		Double value = humidityService.findValueForEntry();

		if (value > AlarmThresholdConstants.CRITICAL_HUMIDITY_ALARM_THRESHOLD) {
			alarmCreationService.createAlarmForHumidity(value);
		}

		return new ResponseEntity<>(humidityService.saveValue(), HttpStatus.OK);
	}

	@GetMapping("/dto")
	public ResponseEntity<HumidityDTO> getLastReading()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<>(humidityService.getLastReading(), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Humidity>> findAllReadings()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<>(humidityService.findAllReadings(), HttpStatus.OK);
	}

}
