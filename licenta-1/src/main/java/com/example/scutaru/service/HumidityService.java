package com.example.scutaru.service;

import java.io.IOException;
import java.util.List;

import com.example.scutaru.domain.Humidity;
import com.example.scutaru.dto.HumidityDTO;

public interface HumidityService {

	Humidity saveValue() throws NumberFormatException, IOException;

	HumidityDTO getLastReading() throws IOException;

	List<Humidity> findAllReadings() throws IOException;

	Double findValueForEntry() throws IOException;

}
