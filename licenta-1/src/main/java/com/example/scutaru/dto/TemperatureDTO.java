package com.example.scutaru.dto;

import java.io.Serializable;

import com.example.scutaru.constant.SensorNames;

public class TemperatureDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double value;
	private Long timeStamp;
	private SensorNames sensorNames;

	public TemperatureDTO() {
		super();
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public SensorNames getSensorNames() {
		return sensorNames;
	}

	public void setSensorNames(SensorNames sensorNames) {
		this.sensorNames = sensorNames;
	}

	@Override
	public String toString() {
		return "TemperatureDTO [value=" + value + ", timeStamp=" + timeStamp + ", sensorNames=" + sensorNames + "]";
	}

}
