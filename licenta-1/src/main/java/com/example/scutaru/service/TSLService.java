package com.example.scutaru.service;

import java.io.IOException;
import java.util.List;

import com.example.scutaru.domain.TSL;
import com.example.scutaru.dto.TslDTO;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

public interface TSLService {

	TSL saveLigthReading() throws IOException, UnsupportedBusNumberException, InterruptedException;

	List<TSL> findAllLightReadings() throws IOException;

	TslDTO getLastReading() throws IOException;

}
