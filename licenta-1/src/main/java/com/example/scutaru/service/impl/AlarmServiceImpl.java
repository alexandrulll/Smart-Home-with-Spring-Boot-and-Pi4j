package com.example.scutaru.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.domain.Alarm;
import com.example.scutaru.dto.DustAlarmConfig;
import com.example.scutaru.dto.TemperatureAlarmConfigDTO;
import com.example.scutaru.repository.AlarmRepository;
import com.example.scutaru.service.AlarmService;

@Service
public class AlarmServiceImpl implements AlarmService{

	private final AlarmRepository alarmRepository;

	private final List<DustAlarmConfig> dustAlarmConfigList = new ArrayList<>();
	private final List<TemperatureAlarmConfigDTO> configDTOs = new ArrayList<>();
	
	@Autowired
	public AlarmServiceImpl(AlarmRepository alarmRepository) {
		this.alarmRepository = alarmRepository;
	}

	@Override
	public Boolean saveTemperatureAlarmConfig(TemperatureAlarmConfigDTO temperatureAlarmConfigDTO) {
		if(configDTOs != null) {
			return this.configDTOs.add(temperatureAlarmConfigDTO);
		}
		return null;
	}
	
	@Override
	public TemperatureAlarmConfigDTO getLastTempConfig() {
		if(configDTOs != null) {
			return this.configDTOs.stream().findFirst().get();
		}
		return null;
	}
	
	@Override
	public Boolean saveDustAlarmConfig(DustAlarmConfig dustAlarmConfig) {
		if(dustAlarmConfig != null) {
			return this.dustAlarmConfigList.add(dustAlarmConfig);
		}
		return null;
	}
	
	@Override
	public DustAlarmConfig getLastDustConfig() {
		if(dustAlarmConfigList != null) {
			return this.dustAlarmConfigList.stream().findFirst().get();
		}
		return null;
	}
	
	@Override
	public List<Alarm> findAllAlarms() {
		return alarmRepository.findAll();
	}

	@Override
	public Alarm findAlarmById(Long id) {
		return alarmRepository.findOne(id);
	}

	@Override
	public Alarm saveAlarm(Alarm alarm) {
		return alarmRepository.save(alarm);
	}

}
