package com.example.scutaru.service;

import java.util.List;

import com.example.scutaru.domain.Alarm;
import com.example.scutaru.dto.DustAlarmConfig;

public interface AlarmService {

	List<Alarm> findAllAlarms();

	Alarm findAlarmById(Long id);

	Alarm saveAlarm(Alarm alarm);

	Boolean saveDustAlarmConfig(DustAlarmConfig dustAlarmConfig);

	List<DustAlarmConfig> findAllDustConfig();

}
