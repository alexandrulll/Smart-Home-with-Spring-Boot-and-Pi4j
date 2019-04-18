package com.example.scutaru.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.scutaru.domain.Humidity;
import com.example.scutaru.dto.HumidityDTO;

@Component
public class HumidityToHumidityDTOConverter implements Converter<Humidity, HumidityDTO> {

	@Override
	public HumidityDTO convert(Humidity source) {

		if (source != null) {

			HumidityDTO dto = new HumidityDTO();

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
