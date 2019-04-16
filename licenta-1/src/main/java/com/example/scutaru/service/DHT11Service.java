package com.example.scutaru.service;

import java.io.IOException;
import java.util.List;

import com.example.scutaru.dto.Dht11DTO;

public interface DHT11Service {

	List<Dht11DTO> getDHT11Readings() throws IOException;
}
