package com.example.scutaru.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.scutaru.domain.DustSensor;
import com.example.scutaru.dto.DustSensorDTO;

@Component
public class DustSensorToDustSensorDTO implements Converter<DustSensor, DustSensorDTO> {

	@Override
	public DustSensorDTO convert(DustSensor dustSensor) {

		if (dustSensor != null) {

			DustSensorDTO dustSensorDTO = new DustSensorDTO();

			dustSensorDTO.setDensityUnit(dustSensor.getDensityUnit());
			dustSensorDTO.setDustDesnsity(dustSensor.getDustDesnsity());
			dustSensorDTO.setId(dustSensor.getId());
			dustSensorDTO.setTimeStamp(dustSensor.getTimeStamp());
			dustSensorDTO.setVoltage(dustSensor.getVoltage());
			dustSensorDTO.setVoltageUnit(dustSensor.getVoltageUnit());

			return dustSensorDTO;
		}
		return null;
	}

}
