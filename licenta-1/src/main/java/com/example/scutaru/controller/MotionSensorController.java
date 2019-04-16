package com.example.scutaru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scutaru.service.MotionSensorService;

@RestController
@RequestMapping(value = "/pir")
public class MotionSensorController {

	@Autowired
	private MotionSensorService motionSensorService;

	/*@GetMapping("/motion")
	public ResponseEntity<List<Integer>> getPirResponse() {

		return new ResponseEntity<List<Integer>>(motionSensorService.getMotions(), HttpStatus.OK);
	}
*/}