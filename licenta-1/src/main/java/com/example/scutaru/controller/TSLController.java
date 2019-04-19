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

import com.example.scutaru.domain.TSL;
import com.example.scutaru.dto.TslDTO;
import com.example.scutaru.service.AlarmCreationService;
import com.example.scutaru.service.TSLService;
import com.example.scutaru.utlis.AlarmThresholdConstants;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@RestController
@RequestMapping(value = "/tsl")
public class TSLController {

	private final TSLService tslService;
	private final AlarmCreationService alarmCreationService;

	@Autowired
	public TSLController(TSLService tslService, AlarmCreationService alarmCreationService) {
		this.tslService = tslService;
		this.alarmCreationService = alarmCreationService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<TSL>> findAllReadings()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<List<TSL>>(tslService.findAllReadings(), HttpStatus.OK);

	}

	@PostMapping("/save")
	public ResponseEntity<TSL> saveValue() throws UnsupportedBusNumberException, IOException, InterruptedException {

		Double value = tslService.findValueForEntry();

		if (value > AlarmThresholdConstants.MAJOR_LIGHT_ALARM_THRESHOLD) {
			alarmCreationService.createAlarmForLight(value);
		}

		return new ResponseEntity<TSL>(tslService.saveReading(), HttpStatus.OK);

	}

	@GetMapping("/dto")
	public ResponseEntity<TslDTO> getLastReading()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<TslDTO>(tslService.getLastReading(), HttpStatus.OK);

	}
}
