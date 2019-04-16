package com.example.scutaru.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.dto.TemperatureDTO;
import com.example.scutaru.service.ConnectionService;
import com.example.scutaru.service.TemperatureService;
import com.example.scutaru.utlis.Constants;

@Service
public class TemperatureServiceImpl implements TemperatureService {

	private String LINE;

	private ConnectionService connectionService;

	@Autowired
	public TemperatureServiceImpl(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}

	@Override
	public List<TemperatureDTO> getTemperature() throws IOException {

		if ((LINE = connectionService.getLine(Constants.DHT11_COMMAND)) != null) {

			List<TemperatureDTO> temperatureValues = new ArrayList<>();
			temperatureValues.add(this.setTemperatureValue());
			return temperatureValues;
		}

		return null;
	}

	private TemperatureDTO setTemperatureValue() {
		String[] data;
		data = LINE.split("   ");

		TemperatureDTO temperatureDTO = new TemperatureDTO();
		temperatureDTO.setValue(Double.parseDouble(data[0]));
		temperatureDTO.setSensorName(Constants.TEMPERATURE_SENSOR_DHT11);
		temperatureDTO.setTimeStamp(System.currentTimeMillis());
		temperatureDTO.setMeasureUnit(Constants.TEMPERATURE_MEASURE_UNIT);

		return temperatureDTO;
	}

}
