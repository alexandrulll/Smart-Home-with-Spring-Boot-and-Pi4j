package com.example.scutaru.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.scutaru.domain.TSL;
import com.example.scutaru.dto.TslDTO;

@Component
public class TslToTSLDTOConverter implements Converter<TSL, TslDTO> {

	@Override
	public TslDTO convert(TSL source) {

		if (source != null) {

			TslDTO dto = new TslDTO();

			dto.setFullSpectrum(source.getFullSpectrum());
			dto.setId(source.getId());
			dto.setInfraredSpectrum(source.getInfraredSpectrum());
			dto.setMeasureUnit(source.getMeasureUnit());
			dto.setTimeStamp(source.getTimeStamp());
			dto.setVisibleSpectrum(source.getVisibleSpectrum());

			return dto;

		}
		return null;
	}

}
