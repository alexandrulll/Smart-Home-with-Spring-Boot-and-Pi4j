package com.example.scutaru.service.impl;

import org.springframework.stereotype.Service;

import com.example.scutaru.dto.AlarmDTO;
import com.example.scutaru.utlis.AlarmGeneratingEntityConstants;
import com.example.scutaru.utlis.AlarmGeneratingLabelConstants;

@Service
public class AlarmCreationServiceImpl {

	public AlarmDTO createAlarmDTOForTemperature(Double value) {
		AlarmDTO alarmDTO = new AlarmDTO();

		alarmDTO.setGeneratingValue(String.valueOf(value));
		alarmDTO.setGeneratingEntity(AlarmGeneratingEntityConstants.TEMPERATURE);
		alarmDTO.setAlarmLabel(AlarmGeneratingLabelConstants.MINOR);

		return alarmDTO;

	}
}
