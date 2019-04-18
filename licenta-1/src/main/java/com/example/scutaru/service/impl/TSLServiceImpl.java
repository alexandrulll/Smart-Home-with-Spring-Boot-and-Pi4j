package com.example.scutaru.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scutaru.converter.TslToTSLDTOConverter;
import com.example.scutaru.domain.TSL;
import com.example.scutaru.dto.TslDTO;
import com.example.scutaru.repository.TslRepository;
import com.example.scutaru.service.ConnectionService;
import com.example.scutaru.service.TSLService;
import com.example.scutaru.utlis.MeasureUnitConstatnts;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

@Service
public class TSLServiceImpl implements TSLService {

	private final ConnectionService connectionService;
	private final TslRepository repository;
	private final TslToTSLDTOConverter converter;

	@Autowired
	public TSLServiceImpl(TslRepository repository, ConnectionService connectionService,
			TslToTSLDTOConverter converter) {
		this.connectionService = connectionService;
		this.repository = repository;
		this.converter = converter;
	}
	
	@Override
	public Double findValueForEntry() throws IOException, UnsupportedBusNumberException, InterruptedException {

		return this.getEntry().getFullSpectrum();
	}

	@Override
	public List<TSL> findAllReadings() throws IOException {

		return repository.findAll();
	}

	@Override
	public TslDTO getLastReading() throws IOException {

		TSL tsl = repository.findFirstByOrderByIdDesc();
		return converter.convert(tsl);

	}

	@Override
	public TSL saveReading() throws IOException, UnsupportedBusNumberException, InterruptedException {

		return repository.save(this.getEntry());

	}

	private TSL getEntry() throws IOException, UnsupportedBusNumberException, InterruptedException {

		TSL tsl = new TSL();

		tsl.setFullSpectrum(this.getInputData().get(0));
		tsl.setInfraredSpectrum(this.getInputData().get(1));
		tsl.setVisibleSpectrum(this.getInputData().get(2));
		tsl.setTimeStamp(System.currentTimeMillis());
		tsl.setMeasureUnit(MeasureUnitConstatnts.LIGHT_MEASURE_UNIT);

		return tsl;

	}

	private List<Double> getInputData() throws IOException, UnsupportedBusNumberException, InterruptedException {

		List<Double> inputValues = new ArrayList<>();

		connectionService.getDevice(1).write(0x00 | 0x80, (byte) 0x03);
		connectionService.getDevice(1).write(0x01 | 0x80, (byte) 0x02);

		Thread.sleep(500);

		byte[] data = new byte[4];
		connectionService.getDevice(1).read(0x0C | 0x80, data, 0, 4);

		double ch0 = ((data[1] & 0xFF) * 256 + (data[0] & 0xFF));
		double ch1 = ((data[3] & 0xFF) * 256 + (data[2] & 0xFF));
		double ch2 = ch0 - ch1;

		inputValues.add(ch0);
		inputValues.add(ch1);
		inputValues.add(ch2);

		return inputValues;
	}
}
