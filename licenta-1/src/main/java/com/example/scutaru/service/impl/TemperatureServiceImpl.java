package com.example.scutaru.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.converter.TemperatureToTemperatureDTOConverter;
import com.example.scutaru.domain.Temperature;
import com.example.scutaru.dto.TemperatureDTO;
import com.example.scutaru.repository.TemperatureRepository;
import com.example.scutaru.service.ConnectionService;
import com.example.scutaru.service.TemperatureService;
import com.example.scutaru.utlis.CommandConstants;
import com.example.scutaru.utlis.MeasureUnitConstatnts;
import com.example.scutaru.utlis.RegexConstants;
import com.example.scutaru.utlis.SensorConstants;

@Service
public class TemperatureServiceImpl implements TemperatureService {

	private static String LINE;
	private String[] data;

	private final ConnectionService connectionService;
	private final TemperatureRepository temperatureRepository;
	private final TemperatureToTemperatureDTOConverter temperatureToTemperatureDTOConverter;

	@Autowired
	public TemperatureServiceImpl(ConnectionService connectionService, TemperatureRepository temperatureRepository,
			TemperatureToTemperatureDTOConverter temperatureToTemperatureDTOConverter) {
		this.connectionService = connectionService;
		this.temperatureRepository = temperatureRepository;
		this.temperatureToTemperatureDTOConverter = temperatureToTemperatureDTOConverter;
	}

	@Override
	public Double findValueForEntry() throws IOException {

		return this.getEntry().getValue();
	}

	@Override
	public List<Temperature> findAllReadings() throws IOException {

		return temperatureRepository.findAll();
	}

	@Override
	public TemperatureDTO findLastReading() throws IOException {

		Temperature temperature = temperatureRepository.findFirstByOrderByIdDesc();
		return temperatureToTemperatureDTOConverter.convert(temperature);
	}

	@Override
	public Temperature saveValue() throws NumberFormatException, IOException {

		return temperatureRepository.save(this.getEntry());
	}

	private Temperature getEntry() throws NumberFormatException, IOException {

		if ((LINE = connectionService.getLine(CommandConstants.DHT11_COMMAND)) != null) {
			data = LINE.split(RegexConstants.DHT11_COMMAND_REGEX);

			Temperature temperature = new Temperature();

			temperature.setValue(Double.parseDouble(data[0]));
			temperature.setSensorName(SensorConstants.TEMPERATURE_SENSOR_DHT11);
			temperature.setTimeStamp(System.currentTimeMillis());
			temperature.setMeasureUnit(MeasureUnitConstatnts.TEMPERATURE_MEASURE_UNIT);

			return temperature;
		}
		return null;
	}

}
