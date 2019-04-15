package com.example.scutaru.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.dto.DustSensorDTO;
import com.example.scutaru.service.ArduinoDustService;
import com.example.scutaru.service.ConnectionService;
import com.example.scutaru.utlis.Constants;

@Service
public class ArduinoDustServiceImpl implements ArduinoDustService {

	private static String LINE;
	private String[] data;

	private ConnectionService connectionService;

	@Autowired
	public ArduinoDustServiceImpl(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}

	@Override
	public List<DustSensorDTO> getDustReadings() throws IOException {

		List<DustSensorDTO> dustValues = new ArrayList<>();

		if ((LINE = connectionService.getParamFromLine(Constants.DUST_COMMAND)) != null) {
			data = LINE.split(" ");

			DustSensorDTO dustSensorDTO = new DustSensorDTO();
			dustSensorDTO.setVoltage(Float.parseFloat(data[0]));
			dustSensorDTO.setDustDesnsity(Float.parseFloat(data[1]));
			dustSensorDTO.setDensityUnit(Constants.DENSITY_MEASURE_UNIT);
			dustSensorDTO.setVoltageUnit(Constants.VOLTAGE_MEASURE_UNIT);
			dustSensorDTO.setTimeStamp(System.currentTimeMillis());

			dustValues.add(dustSensorDTO);

			return dustValues;
		}
		return null;
	}

}
