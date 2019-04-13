package com.example.scutaru.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exemplu.scutaru.dto.Dht11DTO;
import com.exemplu.scutaru.dto.HumidityDTO;
import com.exemplu.scutaru.dto.TemperatureDTO;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@Service
public class DHT11Service {

	private static String COMMAND = "sudo python dht11.py";
	private static String LINE;
	private final List<Dht11DTO> dht11Values = new ArrayList<>();
	private String[] data;

	public List<Dht11DTO> getDHT11Readings() throws UnsupportedBusNumberException, IOException, InterruptedException {

		Dht11DTO dht11dto = new Dht11DTO();

		if ((LINE = this.getInput().readLine()) != null) {

			dht11dto.setHumidityDTO(this.setHumidityValue());
			dht11dto.setTemperatureDTO(this.setTemperatureValue());

			dht11Values.add(dht11dto);

			return dht11Values;
		}
		return null;
	}

	private BufferedReader getInput() throws IOException {

		Process process = Runtime.getRuntime().exec(COMMAND);
		return new BufferedReader(new InputStreamReader(process.getInputStream()));
	}

	private TemperatureDTO setTemperatureValue() {
		data = LINE.split("   ");

		TemperatureDTO temperatureDTO = new TemperatureDTO();
		temperatureDTO.setValue(Double.parseDouble(data[0]));
		temperatureDTO.setSensorName("Sensor_1");
		temperatureDTO.setTimeStamp(System.currentTimeMillis());

		return temperatureDTO;
	}

	private HumidityDTO setHumidityValue() {
		data = LINE.split("   ");

		HumidityDTO humidityDTO = new HumidityDTO();
		humidityDTO.setValue(Double.parseDouble(data[1]));
		humidityDTO.setSensorName("Sensor_1");
		humidityDTO.setTimeStamp(System.currentTimeMillis());

		return humidityDTO;
	}

}
