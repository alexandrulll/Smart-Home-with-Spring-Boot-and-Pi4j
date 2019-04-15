package com.example.scutaru.service;

import java.io.IOException;
import java.util.List;

import com.example.scutaru.dto.Dht11DTO;
import com.example.scutaru.dto.HumidityDTO;
import com.example.scutaru.dto.TemperatureDTO;

public interface DHT11Service {

	List<Dht11DTO> getDHT11Readings() throws IOException;

	List<TemperatureDTO> getDHT11Temperature() throws IOException;

	List<HumidityDTO> getDHT11Humidity() throws IOException;
}
