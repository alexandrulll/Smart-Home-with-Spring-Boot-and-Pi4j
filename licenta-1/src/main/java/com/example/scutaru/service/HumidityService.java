package com.example.scutaru.service;

import java.io.IOException;
import java.util.List;

import com.example.scutaru.dto.HumidityDTO;

public interface HumidityService {

	List<HumidityDTO> getHumidity() throws IOException;

}
