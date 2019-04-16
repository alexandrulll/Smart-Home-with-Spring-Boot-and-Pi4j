package com.example.scutaru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.scutaru.domain.User;
import com.example.scutaru.repository.UserRepository;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

@RestController
@RequestMapping(value = "/demo")
class DemoRestController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/open")
	public ResponseEntity<String> openRaspi() {

		final GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput greenLedPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
		greenLedPin.high();

		gpio.shutdown();
		gpio.unprovisionPin(greenLedPin);

		return new ResponseEntity<String>("Raspi is ON", HttpStatus.CREATED);

	}

	@GetMapping(path = "/add")
	public @ResponseBody List<User> getAllUsers() {

		return userRepository.findAll();
	}
	
	@PostMapping(path = "/add")
	public @ResponseBody User addNewUser() {

		User user = new User();
		user.setEmail("email_1");
		user.setName("name_1");
		user.setId(2);
		
		return userRepository.save(user);
	}


	@PostMapping("/close")
	public ResponseEntity<String> closeRaspi() {

		final GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput greenLedPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
		greenLedPin.low();

		gpio.shutdown();
		gpio.unprovisionPin(greenLedPin);

		return new ResponseEntity<String>("Raspi is OFF", HttpStatus.CREATED);

	}
}
