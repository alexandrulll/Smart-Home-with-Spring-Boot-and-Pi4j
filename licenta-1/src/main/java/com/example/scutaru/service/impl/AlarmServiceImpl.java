package com.example.scutaru.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.domain.Alarm;
import com.example.scutaru.repository.AlarmRepository;

@Service
public class AlarmServiceImpl {

	private final AlarmRepository alarmRepository;

	@Autowired
	public AlarmServiceImpl(AlarmRepository alarmRepository) {
		this.alarmRepository = alarmRepository;
	}

	public List<Alarm> findAllAlarms() {
		return alarmRepository.findAll();
	}

	public Alarm findAlarmById(Long id) {
		return alarmRepository.findOne(id);
	}

	public Alarm saveAlarm(Alarm alarm) {
		return alarmRepository.save(alarm);
	}

}
