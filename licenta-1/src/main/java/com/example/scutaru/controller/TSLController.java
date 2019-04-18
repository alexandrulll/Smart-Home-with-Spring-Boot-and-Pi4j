package com.example.scutaru.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scutaru.domain.TSL;
import com.example.scutaru.dto.TslDTO;
import com.example.scutaru.service.TSLService;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@RestController
@RequestMapping(value = "/tsl")
public class TSLController {

	private final TSLService tslService;

	@Autowired
	public TSLController(TSLService tslService) {
		this.tslService = tslService;
	}

	@GetMapping("/light/all")
	public ResponseEntity<List<TSL>> findAllReadings()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<List<TSL>>(tslService.findAllLightReadings(), HttpStatus.OK);

	}

	@GetMapping("/light/save")
	public ResponseEntity<TSL> getLightReading()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<TSL>(tslService.saveLigthReading(), HttpStatus.OK);

	}

	@GetMapping("/light/dto")
	public ResponseEntity<TslDTO> getLastLightReading()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<TslDTO>(tslService.getLastReading(), HttpStatus.OK);

	}
}
