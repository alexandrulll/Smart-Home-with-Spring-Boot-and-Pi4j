package com.example.scutaru.service;

import java.io.IOException;
import java.util.List;

import com.example.scutaru.domain.TSL;
import com.example.scutaru.dto.TslDTO;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

public interface TSLService {

	TSL saveReading() throws IOException, UnsupportedBusNumberException, InterruptedException;

	List<TSL> findAllReadings() throws IOException;

	TslDTO getLastReading() throws IOException;

	Double findValueForEntry() throws IOException, UnsupportedBusNumberException, InterruptedException;

}
