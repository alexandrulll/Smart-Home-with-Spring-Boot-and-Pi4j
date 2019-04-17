package com.example.scutaru.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.dto.DustSensorDTO;
import com.example.scutaru.service.ArduinoDustService;
import com.example.scutaru.service.ConnectionService;
import com.example.scutaru.utlis.CommandConstants;
import com.example.scutaru.utlis.MeasureUnitConstatnts;
import com.example.scutaru.utlis.RegexConstants;

@Service
public class ArduinoDustServiceImpl implements ArduinoDustService {

	private static String LINE;
	private String[] data;

	private final ConnectionService connectionService;

	@Autowired
	public ArduinoDustServiceImpl(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}
	
	@Override
	public List<DustSensorDTO> getDustReadings() throws IOException {

		List<DustSensorDTO> dustValues = new ArrayList<>();

		if ((LINE = connectionService.getLineForSerial(CommandConstants.DUST_COMMAND)) != null) {
			data = LINE.split(RegexConstants.DUST_COMMAND_REGEX);

			DustSensorDTO dustSensorDTO = new DustSensorDTO();
			dustSensorDTO.setVoltage(Float.parseFloat(data[0]));
			dustSensorDTO.setDustDesnsity(Float.parseFloat(data[1]));
			dustSensorDTO.setDensityUnit(MeasureUnitConstatnts.DENSITY_MEASURE_UNIT);
			dustSensorDTO.setVoltageUnit(MeasureUnitConstatnts.VOLTAGE_MEASURE_UNIT);
			dustSensorDTO.setTimeStamp(System.currentTimeMillis());

			dustValues.add(dustSensorDTO);

			return dustValues;
		}
		return null;
	}

}
