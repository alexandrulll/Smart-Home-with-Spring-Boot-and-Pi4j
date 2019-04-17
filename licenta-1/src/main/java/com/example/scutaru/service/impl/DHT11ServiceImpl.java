package com.example.scutaru.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.dto.Dht11DTO;
import com.example.scutaru.service.ConnectionService;
import com.example.scutaru.service.DHT11Service;
import com.example.scutaru.service.HumidityService;
import com.example.scutaru.service.TemperatureService;
import com.example.scutaru.utlis.CommandConstants;

@Service
public class DHT11ServiceImpl implements DHT11Service {

	private final ConnectionService connectionService;
	private final TemperatureService temperatureService;
	private final HumidityService humidityService;

	@Autowired
	public DHT11ServiceImpl(ConnectionService connectionService, TemperatureService temperatureService,
			HumidityService humidityService) {
		this.connectionService = connectionService;
		this.humidityService = humidityService;
		this.temperatureService = temperatureService;
	}

	@Override
	public List<Dht11DTO> getDHT11Readings() throws IOException {

		List<Dht11DTO> dht11Values = new ArrayList<>();

		if ((connectionService.getLine(CommandConstants.DHT11_COMMAND)) != null) {

			Dht11DTO dht11dto = new Dht11DTO();
			
			dht11dto.setHumidityDTO(humidityService.getHumidity().stream().findFirst().get());
			dht11dto.setTemperatureDTO(temperatureService.getTemperature().stream().findFirst().get());

			dht11Values.add(dht11dto);

			return dht11Values;
		}
		return null;
	}


}
