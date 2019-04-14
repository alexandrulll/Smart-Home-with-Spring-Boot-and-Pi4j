package com.example.scutaru.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.scutaru.constant.SensorNames;
import com.example.scutaru.dto.Dht11DTO;
import com.example.scutaru.dto.HumidityDTO;
import com.example.scutaru.dto.TemperatureDTO;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@Service
public class DHT11Service {

	private static String COMMAND = "sudo python dht11.py";
	private static String LINE;
	private final List<Dht11DTO> dht11Values = new ArrayList<>();
	private final List<TemperatureDTO> temperatureValues = new ArrayList<>();
	private final List<HumidityDTO> humidityValues = new ArrayList<>();
	private String[] data;

	private BufferedReader getInput() throws IOException {

		Process process = Runtime.getRuntime().exec(COMMAND);
		return new BufferedReader(new InputStreamReader(process.getInputStream()));
	}

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

	public List<TemperatureDTO> getDHT11Temperature()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		if ((LINE = this.getInput().readLine()) != null) {

			temperatureValues.add(this.setTemperatureValue());
			return temperatureValues;
		}

		return null;
	}

	public List<HumidityDTO> getDHT11Humidity()
			throws UnsupportedBusNumberException, IOException, InterruptedException {

		if ((LINE = this.getInput().readLine()) != null) {

			humidityValues.add(this.setHumidityValue());
			return humidityValues;
		}

		return null;
	}

	private TemperatureDTO setTemperatureValue() {
		data = LINE.split("   ");

		TemperatureDTO temperatureDTO = new TemperatureDTO();
		temperatureDTO.setValue(Double.parseDouble(data[0]));
		temperatureDTO.setSensorNames(SensorNames.TEMPERATURE_SENSOR_DHT11);
		temperatureDTO.setTimeStamp(System.currentTimeMillis());

		return temperatureDTO;
	}

	private HumidityDTO setHumidityValue() {
		data = LINE.split("   ");

		HumidityDTO humidityDTO = new HumidityDTO();
		humidityDTO.setValue(Double.parseDouble(data[1]));
		humidityDTO.setSensorNames(SensorNames.HUMIDITY_SENSOR_DHT11);
		humidityDTO.setTimeStamp(System.currentTimeMillis());

		return humidityDTO;
	}

}
