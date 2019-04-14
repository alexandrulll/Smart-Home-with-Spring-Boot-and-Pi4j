package com.example.scutaru.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scutaru.dto.DustSensorDTO;
import com.example.scutaru.service.ArduinoDustService;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@RestController
@RequestMapping(value = "/dust")
public class ArduinoDustController {

	private final ArduinoDustService arduinoDustService;

	@Autowired
	public ArduinoDustController(ArduinoDustService arduinoDustService) {
		this.arduinoDustService = arduinoDustService;
	}

	@GetMapping("")
	public ResponseEntity<List<DustSensorDTO>> getDustReadings()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<>(arduinoDustService.getDustReadings(), HttpStatus.ACCEPTED);
	}
}