package com.example.scutaru.service;

import java.io.IOException;
import java.util.List;

import com.example.scutaru.dto.TslDTO;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

public interface TSLService {

	List<TslDTO> getLigthReadings() throws UnsupportedBusNumberException, IOException, InterruptedException;

}
