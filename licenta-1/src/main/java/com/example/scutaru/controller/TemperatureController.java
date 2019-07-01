package com.example.scutaru.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scutaru.domain.Temperature;
import com.example.scutaru.dto.TemperatureDTO;
import com.example.scutaru.service.AlarmCreationService;
import com.example.scutaru.service.AlarmService;
import com.example.scutaru.service.TemperatureService;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@RestController
@RequestMapping(value = "/temperature")
public class TemperatureController {

	private final TemperatureService temperatureService;
	private final AlarmCreationService alarmCreationService;
	private final AlarmService alarmService;

	@Autowired
	public TemperatureController(TemperatureService temperatureService, AlarmCreationService alarmCreationService,
								AlarmService alarmService) {
		this.temperatureService = temperatureService;
		this.alarmCreationService = alarmCreationService;
		this.alarmService = alarmService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Temperature>> findAllReadings()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<>(temperatureService.findAllReadings(), HttpStatus.OK);
	}

	@GetMapping("/dto")
	public ResponseEntity<TemperatureDTO> getLastValue()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<>(temperatureService.findLastReading(), HttpStatus.OK);
	}

	@GetMapping("/save")
	public ResponseEntity<Temperature> saveValue()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		Double value = temperatureService.findValueForEntry();

		if (value > alarmService.getLastTempConfig().getValue()) {
			alarmCreationService.createAlarmForTemperature(value);
		}
		return new ResponseEntity<>(temperatureService.saveValue(), HttpStatus.OK);
	}

}
