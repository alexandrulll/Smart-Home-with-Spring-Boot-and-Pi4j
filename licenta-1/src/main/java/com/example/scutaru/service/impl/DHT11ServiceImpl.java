package com.example.scutaru.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.dto.Dht11DTO;
import com.example.scutaru.dto.HumidityDTO;
import com.example.scutaru.dto.TemperatureDTO;
import com.example.scutaru.service.DHT11Service;
import com.example.scutaru.service.HumidityService;
import com.example.scutaru.service.TemperatureService;

@Service
public class DHT11ServiceImpl implements DHT11Service {

	private final List<Dht11DTO> dht11Values = new ArrayList<>();

	private final TemperatureService temperatureService;
	private final HumidityService humidityService;

	@Autowired
	public DHT11ServiceImpl(TemperatureService temperatureService, HumidityService humidityService) {
		this.humidityService = humidityService;
		this.temperatureService = temperatureService;
	}

	@Override
	public List<Dht11DTO> getDHT11Readings() throws IOException {

		Dht11DTO dht11dto = new Dht11DTO();
		HumidityDTO humidityDTO = humidityService.getLastReading();
		TemperatureDTO temperatureDTO = temperatureService.findLastReading();

		if (humidityDTO != null && temperatureDTO != null) {

			dht11dto.setHumidityDTO(humidityDTO);
			dht11dto.setTemperatureDTO(temperatureDTO);

			dht11Values.add(dht11dto);

			return dht11Values;
		}

		return null;
	}

}
