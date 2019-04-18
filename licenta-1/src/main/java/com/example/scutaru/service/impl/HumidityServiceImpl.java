package com.example.scutaru.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.converter.HumidityToHumidityDTOConverter;
import com.example.scutaru.domain.Humidity;
import com.example.scutaru.dto.HumidityDTO;
import com.example.scutaru.repository.HumidityRepository;
import com.example.scutaru.service.ConnectionService;
import com.example.scutaru.service.HumidityService;
import com.example.scutaru.utlis.CommandConstants;
import com.example.scutaru.utlis.MeasureUnitConstatnts;
import com.example.scutaru.utlis.RegexConstants;
import com.example.scutaru.utlis.SensorConstants;

@Service
public class HumidityServiceImpl implements HumidityService {

	private static String LINE;
	private String[] data;

	private final HumidityRepository humidityRepository;
	private final HumidityToHumidityDTOConverter humidityToHumidityDTOConverter;
	private final ConnectionService connectionService;

	@Autowired
	public HumidityServiceImpl(HumidityRepository humidityRepository,
			HumidityToHumidityDTOConverter humidityToHumidityDTOConverter, ConnectionService connectionService) {

		this.humidityRepository = humidityRepository;
		this.humidityToHumidityDTOConverter = humidityToHumidityDTOConverter;
		this.connectionService = connectionService;
	}
	
	@Override
	public Double findValueForEntry() throws IOException {

		return this.getEntry().getValue();
	}

	@Override
	public List<Humidity> findAllReadings() throws IOException {

		return humidityRepository.findAll();
	}

	@Override
	public HumidityDTO getLastReading() throws IOException {

		Humidity humidity = humidityRepository.findFirstByOrderByIdDesc();
		return humidityToHumidityDTOConverter.convert(humidity);
	}
	
	@Override
	public Humidity saveValue() throws NumberFormatException, IOException {

		return humidityRepository.save(this.getEntry());
	}

	private Humidity getEntry() throws NumberFormatException, IOException {

		if ((LINE = connectionService.getLine(CommandConstants.DHT11_COMMAND)) != null) {
			data = LINE.split(RegexConstants.DHT11_COMMAND_REGEX);

			Humidity humidity = new Humidity();
			humidity.setValue(Double.parseDouble(data[1]));
			humidity.setSensorName(SensorConstants.HUMIDITY_SENSOR_DHT11);
			humidity.setTimeStamp(System.currentTimeMillis());
			humidity.setMeasureUnit(MeasureUnitConstatnts.HUMIDITY_MEASURE_UNIT);
			
			return humidity;

		}
		return null;
	}

}
