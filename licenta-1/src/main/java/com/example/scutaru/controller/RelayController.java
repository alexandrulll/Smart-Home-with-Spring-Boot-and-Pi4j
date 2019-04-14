package com.example.scutaru.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scutaru.service.RelayService;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@RestController
@RequestMapping(value = "/relay")
public class RelayController {

	private RelayService relayService;

	@Autowired
	public RelayController(RelayService relayService) {
		this.relayService = relayService;
	}

	@PostMapping("/first-switch/on")
	public ResponseEntity<PinState> switchOnFirstRelay()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<PinState>(relayService.switchOnFirstRelay(), HttpStatus.CREATED);
	}

	@PostMapping("/first-switch/off")
	public ResponseEntity<PinState> switchOffFirstRelay()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<PinState>(relayService.switchOffFirstRelay(), HttpStatus.CREATED);
	}

	@PostMapping("/second-switch/on")
	public ResponseEntity<PinState> switchOnSecondRelay()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<PinState>(relayService.switchOnSecondRelay(), HttpStatus.CREATED);
	}

	@PostMapping("/second-switch/off")
	public ResponseEntity<PinState> switchOffSecondRelay()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<PinState>(relayService.switchOffSecondRelay(), HttpStatus.CREATED);
	}
}