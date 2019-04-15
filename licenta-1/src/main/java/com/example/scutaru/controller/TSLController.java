package com.example.scutaru.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scutaru.dto.TslDTO;
import com.example.scutaru.service.impl.TSLService;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@RestController
@RequestMapping(value = "/tsl")
public class TSLController {

	private final TSLService tslService;

	@Autowired
	public TSLController(TSLService tslService) {
		this.tslService = tslService;
	}

	@GetMapping("/light")
	public List<TslDTO> getLightReadings() throws UnsupportedBusNumberException, IOException, InterruptedException {

		return tslService.getLigthReadings();

	}
}
