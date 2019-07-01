package com.example.scutaru.service;

import com.example.scutaru.domain.Alarm;

public interface AlarmCreationService {

	Alarm createAlarmForTemperature(Double value);

	Alarm createAlarmForHumidity(Double value);

	Alarm createAlarmForLight(Double value);

	Alarm createAlarmForDust(Float value);

}
