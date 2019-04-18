package com.example.scutaru.service;

import java.io.IOException;
import java.util.List;

import com.example.scutaru.domain.Temperature;
import com.example.scutaru.dto.TemperatureDTO;

public interface TemperatureService {

	List<Temperature> findAllReadings() throws IOException;

	TemperatureDTO findLastReading() throws IOException;

	Temperature saveValue() throws NumberFormatException, IOException;

	Double findValueForEntry() throws IOException;
}
