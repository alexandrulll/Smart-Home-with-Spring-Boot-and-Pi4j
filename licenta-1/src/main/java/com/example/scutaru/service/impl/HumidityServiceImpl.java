package com.example.scutaru.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.dto.HumidityDTO;
import com.example.scutaru.service.ConnectionService;
import com.example.scutaru.service.HumidityService;
import com.example.scutaru.utlis.Constants;

@Service
public class HumidityServiceImpl implements HumidityService {

	private String LINE;

	private ConnectionService connectionService;

	@Autowired
	public HumidityServiceImpl(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}

	@Override
	public List<HumidityDTO> getHumidity() throws IOException {

		if ((LINE = connectionService.getLine(Constants.DHT11_COMMAND)) != null) {

			List<HumidityDTO> humidityValues = new ArrayList<>();
			humidityValues.add(this.setHumidityValue());
			return humidityValues;
		}

		return null;
	}

	private HumidityDTO setHumidityValue() {
		String[] data;
		data = LINE.split("   ");

		HumidityDTO humidityDTO = new HumidityDTO();
		humidityDTO.setValue(Double.parseDouble(data[1]));
		humidityDTO.setSensorName(Constants.HUMIDITY_SENSOR_DHT11);
		humidityDTO.setTimeStamp(System.currentTimeMillis());
		humidityDTO.setMeasureUnit(Constants.HUMIDITY_MEASURE_UNIT);

		return humidityDTO;
	}

}
