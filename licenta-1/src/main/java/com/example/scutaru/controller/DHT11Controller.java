package com.example.scutaru.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scutaru.dto.Dht11DTO;
import com.example.scutaru.dto.HumidityDTO;
import com.example.scutaru.dto.TemperatureDTO;
import com.example.scutaru.service.DHT11Service;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@RestController
@RequestMapping(value = "/dht11")
public class DHT11Controller {

	private final DHT11Service dht11Service;

	@Autowired
	public DHT11Controller(DHT11Service dht11Service) {
		this.dht11Service = dht11Service;
	}

	@GetMapping("/temperature-humidity")
	public ResponseEntity<List<Dht11DTO>> getDHT11Readings()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<>(dht11Service.getDHT11Readings(), HttpStatus.OK);
	}

	@GetMapping("/temperature")
	public ResponseEntity<List<TemperatureDTO>> getDHT11Temperature()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<>(dht11Service.getDHT11Temperature(), HttpStatus.OK);
	}

	@GetMapping("/humidity")
	public ResponseEntity<List<HumidityDTO>> getDHT11Humidity()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		return new ResponseEntity<>(dht11Service.getDHT11Humidity(), HttpStatus.OK);
	}
}
