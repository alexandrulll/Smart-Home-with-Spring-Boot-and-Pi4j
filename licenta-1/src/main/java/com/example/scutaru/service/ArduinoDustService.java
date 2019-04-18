package com.example.scutaru.service;

import java.io.IOException;
import java.util.List;

import com.example.scutaru.domain.DustSensor;
import com.example.scutaru.dto.DustSensorDTO;

public interface ArduinoDustService {

	DustSensor getDustReadings() throws IOException;

	List<DustSensor> findAllDustReadings() throws IOException;

	DustSensorDTO getLastReading() throws IOException;
	
}
