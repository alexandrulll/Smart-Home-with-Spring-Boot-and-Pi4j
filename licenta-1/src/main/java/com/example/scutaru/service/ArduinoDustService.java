package com.example.scutaru.service;

import java.io.IOException;
import java.util.List;

import com.example.scutaru.dto.DustSensorDTO;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

public interface ArduinoDustService {

	List<DustSensorDTO> getDustReadings() throws UnsupportedBusNumberException, IOException, InterruptedException;
}
