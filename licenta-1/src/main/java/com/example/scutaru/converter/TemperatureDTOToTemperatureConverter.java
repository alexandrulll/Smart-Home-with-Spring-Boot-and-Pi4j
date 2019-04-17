package com.example.scutaru.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.scutaru.domain.Temperature;
import com.example.scutaru.dto.TemperatureDTO;

@Component
public class TemperatureDTOToTemperatureConverter implements Converter<TemperatureDTO, Temperature> {

	@Override
	public Temperature convert(TemperatureDTO temperatureDTO) {

		if (temperatureDTO != null) {

			Temperature temperature = new Temperature();

			temperature.setId(temperatureDTO.getId());
			temperature.setMeasureUnit(temperatureDTO.getMeasureUnit());
			temperature.setSensorName(temperatureDTO.getSensorName());
			temperature.setTimeStamp(temperatureDTO.getTimeStamp());
			temperature.setValue(temperatureDTO.getValue());

			return temperature;
		}
		return null;
	}

}
