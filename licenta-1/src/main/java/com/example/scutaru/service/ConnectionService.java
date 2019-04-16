package com.example.scutaru.service;

import java.io.BufferedReader;
import java.io.IOException;

import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

public interface ConnectionService {

	BufferedReader getDataFromScript(String command) throws IOException;
	
	String getLineForSerial(String command) throws IOException;

	String getLine(String command) throws IOException;
	
	I2CDevice getDevice(Integer integer) throws UnsupportedBusNumberException, IOException;
}
