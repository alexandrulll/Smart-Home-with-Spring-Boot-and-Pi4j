package com.example.scutaru.service;

import java.util.List;

import com.example.scutaru.domain.Alarm;

public interface AlarmService {

	List<Alarm> findAllAlarms();

	Alarm findAlarmById(Long id);

	Alarm saveAlarm(Alarm alarm);

}
