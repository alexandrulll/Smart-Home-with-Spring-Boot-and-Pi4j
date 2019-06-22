package com.example.scutaru.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.scutaru.service.ConnectionService;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@Service
public class ConnectionServiceImpl implements ConnectionService {

	@Override
	public String getLine(String command) throws IOException {

		return this.getDataFromScript(command).readLine();
	}
	
	@Override
	public BufferedReader getDataFromScript(String command) throws IOException {

		Process process = Runtime.getRuntime().exec(command);
		return new BufferedReader(new InputStreamReader(process.getInputStream()));
	}

	@Override
	public String getLineForSerial(String command) throws IOException {

		return this.getDataFromScript(command)
				   .lines()
				   .collect(Collectors.toList())
				   .get(2);

	}

	@Override
	public I2CDevice getDevice(Integer integer) throws UnsupportedBusNumberException, IOException {

		I2CBus bus = I2CFactory.getInstance(integer);
		I2CDevice device = bus.getDevice(0x39);

		return device;

	}
}