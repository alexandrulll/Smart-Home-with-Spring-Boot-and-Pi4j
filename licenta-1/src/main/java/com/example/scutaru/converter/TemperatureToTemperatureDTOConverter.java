package com.example.scutaru.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.scutaru.domain.Temperature;
import com.example.scutaru.dto.TemperatureDTO;

@Component
public class TemperatureToTemperatureDTOConverter implements Converter<Temperature, TemperatureDTO> {

	@Override
	public TemperatureDTO convert(Temperature source) {

		if (source != null) {

			TemperatureDTO dto = new TemperatureDTO();

			dto.setId(source.getId());
			dto.setMeasureUnit(source.getMeasureUnit());
			dto.setSensorName(source.getSensorName());
			dto.setTimeStamp(source.getTimeStamp());
			dto.setValue(source.getValue());

			return dto;
		}
		return null;
	}

}
