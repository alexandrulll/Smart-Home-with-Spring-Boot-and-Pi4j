package com.example.scutaru.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.scutaru.domain.Alarm;
import com.example.scutaru.dto.AlarmDTO;

@Component
public class AlarmDTOTOAlarmConverter implements Converter<AlarmDTO, Alarm> {

	@Override
	public Alarm convert(AlarmDTO alarmDTO) {

		if (alarmDTO != null) {
			Alarm alarm = new Alarm();

			alarm.setGeneratingEntity(alarmDTO.getGeneratingEntity());
			alarm.setGeneratingValue(alarmDTO.getGeneratingValue());
			alarm.setId(alarmDTO.getId());
			alarm.setAlarmLabel(alarmDTO.getAlarmLabel());

			return alarm;
		}

		return null;
	}

}
