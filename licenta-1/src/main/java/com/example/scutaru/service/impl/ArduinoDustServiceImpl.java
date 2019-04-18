package com.example.scutaru.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.converter.DustSensorToDustSensorDTO;
import com.example.scutaru.domain.DustSensor;
import com.example.scutaru.dto.DustSensorDTO;
import com.example.scutaru.repository.ArduinoDustRepository;
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
	private final ArduinoDustRepository arduinoDustRepository;
	private final DustSensorToDustSensorDTO dustSensorToDustSensorDTO;

	@Autowired
	public ArduinoDustServiceImpl(ConnectionService connectionService, ArduinoDustRepository arduinoDustRepository,
			DustSensorToDustSensorDTO dustSensorToDustSensorDTO) {
		this.connectionService = connectionService;
		this.arduinoDustRepository = arduinoDustRepository;
		this.dustSensorToDustSensorDTO = dustSensorToDustSensorDTO;
	}

	@Override
	public List<DustSensor> findAllDustReadings() throws IOException {
		
		return arduinoDustRepository.findAll();
	}

	@Override
	public DustSensorDTO getLastReading() throws IOException {

		DustSensor dustSensor = arduinoDustRepository.findAll().get(0);
		return dustSensorToDustSensorDTO.convert(dustSensor);

	}

	@Override
	public DustSensor getDustReadings() throws IOException {

		if ((LINE = connectionService.getLineForSerial(CommandConstants.DUST_COMMAND)) != null) {
			data = LINE.split(RegexConstants.DUST_COMMAND_REGEX);

			DustSensor dustSensor = new DustSensor();
			
			dustSensor.setVoltage(Float.parseFloat(data[0]));
			dustSensor.setDustDesnsity(Float.parseFloat(data[1]));
			dustSensor.setDensityUnit(MeasureUnitConstatnts.DENSITY_MEASURE_UNIT);
			dustSensor.setVoltageUnit(MeasureUnitConstatnts.VOLTAGE_MEASURE_UNIT);
			dustSensor.setTimeStamp(System.currentTimeMillis());

			return arduinoDustRepository.save(dustSensor);

		}

		return null;
	}

}
