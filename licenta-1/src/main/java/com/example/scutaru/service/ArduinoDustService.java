package com.example.scutaru.service;

import java.io.IOException;
import java.util.List;

import com.example.scutaru.dto.DustSensorDTO;

public interface ArduinoDustService {

	List<DustSensorDTO> getDustReadings() throws IOException;
	
}
