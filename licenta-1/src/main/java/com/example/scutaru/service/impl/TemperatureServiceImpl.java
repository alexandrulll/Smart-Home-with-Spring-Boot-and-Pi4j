package com.example.scutaru.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.converter.AlarmDTOTOAlarmConverter;
import com.example.scutaru.converter.TemperatureDTOToTemperatureConverter;
import com.example.scutaru.domain.Alarm;
import com.example.scutaru.domain.Temperature;
import com.example.scutaru.dto.AlarmDTO;
import com.example.scutaru.dto.TemperatureDTO;
import com.example.scutaru.repository.TemperatureRepository;
import com.example.scutaru.service.ConnectionService;
import com.example.scutaru.service.TemperatureService;
import com.example.scutaru.utlis.AlarmThresholdConstants;
import com.example.scutaru.utlis.CommandConstants;
import com.example.scutaru.utlis.MeasureUnitConstatnts;
import com.example.scutaru.utlis.RegexConstants;
import com.example.scutaru.utlis.SensorConstants;

@Service
public class TemperatureServiceImpl implements TemperatureService {

	private String LINE;

	private final ConnectionService connectionService;
	private final AlarmDTOTOAlarmConverter alarmDTOTOAlarmConverter;
	private final AlarmServiceImpl alarmServiceImpl;
	private final AlarmCreationServiceImpl alarmCreationServiceImpl;
	private final TemperatureRepository temperatureRepository;
	private final TemperatureDTOToTemperatureConverter temperatureDTOToTemperatureConverter;

	@Autowired
	public TemperatureServiceImpl(ConnectionService connectionService,
			AlarmDTOTOAlarmConverter alarmDTOTOAlarmConverter, AlarmServiceImpl alarmServiceImpl,
			AlarmCreationServiceImpl alarmCreationServiceImpl, TemperatureRepository temperatureRepository,
			TemperatureDTOToTemperatureConverter temperatureDTOToTemperatureConverter) {
		this.connectionService = connectionService;
		this.alarmDTOTOAlarmConverter = alarmDTOTOAlarmConverter;
		this.alarmServiceImpl = alarmServiceImpl;
		this.alarmCreationServiceImpl = alarmCreationServiceImpl;
		this.temperatureRepository = temperatureRepository;
		this.temperatureDTOToTemperatureConverter = temperatureDTOToTemperatureConverter;
	}

	@Override
	public List<TemperatureDTO> getTemperature() throws IOException {

		if ((LINE = connectionService.getLine(CommandConstants.DHT11_COMMAND)) != null) {

			List<TemperatureDTO> temperatureValues = new ArrayList<>();
			temperatureValues.add(this.setTemperatureValue());
			return temperatureValues;
		}

		return null;
	}

	@Override
	public Alarm saveTemperatureAlarms() {

		if (this.setTemperatureValue().getValue() > AlarmThresholdConstants.MINOR_TEMPERATURE_ALARM_THRESHOLD) {

			AlarmDTO alarmDTO = alarmCreationServiceImpl.createAlarmDTOForTemperature(this.setTemperatureValue().getValue());
			Alarm alarm = alarmServiceImpl.saveAlarm(alarmDTOTOAlarmConverter.convert(alarmDTO));

			return alarm;

		}
		return null;

	}

	private TemperatureDTO setTemperatureValue() {
		String[] data;
		data = LINE.split(RegexConstants.DHT11_COMMAND_REGEX);

		TemperatureDTO temperatureDTO = new TemperatureDTO();
		temperatureDTO.setValue(Double.parseDouble(data[0]));
		temperatureDTO.setSensorName(SensorConstants.TEMPERATURE_SENSOR_DHT11);
		temperatureDTO.setTimeStamp(System.currentTimeMillis());
		temperatureDTO.setMeasureUnit(MeasureUnitConstatnts.TEMPERATURE_MEASURE_UNIT);

		Temperature temperature = temperatureDTOToTemperatureConverter.convert(temperatureDTO);
		temperatureRepository.save(temperature);

		return temperatureDTO;
	}

}
