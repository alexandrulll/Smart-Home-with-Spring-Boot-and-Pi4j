package com.example.scutaru.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.dto.Dht11DTO;
import com.example.scutaru.dto.HumidityDTO;
import com.example.scutaru.dto.TemperatureDTO;
import com.example.scutaru.service.ConnectionService;
import com.example.scutaru.service.DHT11Service;
import com.example.scutaru.utlis.Constants;

@Service
public class DHT11ServiceImpl implements DHT11Service {

	private String LINE;
	private String[] data;

	private ConnectionService connectionService;

	@Autowired
	public DHT11ServiceImpl(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}

	@Override
	public List<Dht11DTO> getDHT11Readings() throws IOException {

		List<Dht11DTO> dht11Values = new ArrayList<>();

		if ((LINE = connectionService.getParamFromLine(Constants.DHT11_COMMAND)) != null) {

			Dht11DTO dht11dto = new Dht11DTO();
			dht11dto.setHumidityDTO(this.setHumidityValue());
			dht11dto.setTemperatureDTO(this.setTemperatureValue());

			dht11Values.add(dht11dto);

			return dht11Values;
		}
		return null;
	}

	@Override
	public List<TemperatureDTO> getDHT11Temperature() throws IOException {

		if ((LINE = connectionService.getParamFromLine(Constants.DHT11_COMMAND)) != null) {

			List<TemperatureDTO> temperatureValues = new ArrayList<>();
			temperatureValues.add(this.setTemperatureValue());
			return temperatureValues;
		}

		return null;
	}

	@Override
	public List<HumidityDTO> getDHT11Humidity() throws IOException {

		if ((LINE = connectionService.getParamFromLine(Constants.DHT11_COMMAND)) != null) {

			List<HumidityDTO> humidityValues = new ArrayList<>();
			humidityValues.add(this.setHumidityValue());
			return humidityValues;
		}

		return null;
	}

	private TemperatureDTO setTemperatureValue() {
		data = LINE.split("   ");

		TemperatureDTO temperatureDTO = new TemperatureDTO();
		temperatureDTO.setValue(Double.parseDouble(data[0]));
		temperatureDTO.setSensorName(Constants.TEMPERATURE_SENSOR_DHT11);
		temperatureDTO.setTimeStamp(System.currentTimeMillis());
		temperatureDTO.setMeasureUnit(Constants.TEMPERATURE_MEASURE_UNIT);

		return temperatureDTO;
	}

	private HumidityDTO setHumidityValue() {
		data = LINE.split("   ");

		HumidityDTO humidityDTO = new HumidityDTO();
		humidityDTO.setValue(Double.parseDouble(data[1]));
		humidityDTO.setSensorName(Constants.HUMIDITY_SENSOR_DHT11);
		humidityDTO.setTimeStamp(System.currentTimeMillis());
		humidityDTO.setMeasureUnit(Constants.HUMIDITY_MEASURE_UNIT);

		return humidityDTO;
	}

}
