package com.example.scutaru.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.domain.Alarm;
import com.example.scutaru.repository.AlarmRepository;
import com.example.scutaru.service.AlarmCreationService;
import com.example.scutaru.utlis.AlarmGeneratingEntityConstants;
import com.example.scutaru.utlis.AlarmGeneratingLabelConstants;

@Service
public class AlarmCreationServiceImpl implements AlarmCreationService {

	private final AlarmRepository alarmRepository;

	@Autowired
	public AlarmCreationServiceImpl(AlarmRepository alarmRepository) {
		this.alarmRepository = alarmRepository;
	}

	@Override
	public Alarm createAlarmForTemperature(Double value) {
		Alarm alarm = new Alarm();

		alarm.setGeneratingValue(String.valueOf(value));
		alarm.setGeneratingEntity(AlarmGeneratingEntityConstants.TEMPERATURE);
		alarm.setAlarmLabel(AlarmGeneratingLabelConstants.MINOR);

		return alarmRepository.save(alarm);

	}

	@Override
	public Alarm createAlarmForHumidity(Double value) {
		Alarm alarm = new Alarm();

		alarm.setGeneratingValue(String.valueOf(value));
		alarm.setGeneratingEntity(AlarmGeneratingEntityConstants.HUMIDITY);
		alarm.setAlarmLabel(AlarmGeneratingLabelConstants.CRITICAL);

		return alarmRepository.save(alarm);

	}

	@Override
	public Alarm createAlarmForLight(Double value) {
		Alarm alarm = new Alarm();

		alarm.setGeneratingValue(String.valueOf(value));
		alarm.setGeneratingEntity(AlarmGeneratingEntityConstants.LIGHT);
		alarm.setAlarmLabel(AlarmGeneratingLabelConstants.MAJOR);

		return alarmRepository.save(alarm);

	}
}
