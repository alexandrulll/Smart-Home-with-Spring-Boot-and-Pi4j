package com.example.scutaru.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.scutaru.dto.DustSensorDTO;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@Service
public class ArduinoDustService {

	private static String COMMAND = "sudo python serial_py.py";
	private static String LINE;
	private final List<DustSensorDTO> dustValues = new ArrayList<>();
	private String[] data;

	private BufferedReader getInput() throws IOException {

		Process process = Runtime.getRuntime().exec(COMMAND);
		return new BufferedReader(new InputStreamReader(process.getInputStream()));
	}

	public List<DustSensorDTO> getDustReadings()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		if ((LINE = this.getInput().readLine()) != null) {
			data = LINE.split(" ");

			DustSensorDTO dustSensorDTO = new DustSensorDTO();
			dustSensorDTO.setVoltage(Float.parseFloat(data[0]));
			dustSensorDTO.setDustDesnsity(Float.parseFloat(data[1]));
			
			dustValues.add(dustSensorDTO);

			return dustValues;
		}
		return null;
	}

}
