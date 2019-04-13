package com.exemplu.scutaru.dto;

import java.io.Serializable;

public class HumidityDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double value;
	private Long timeStamp;
	private String sensorName;

	public HumidityDTO() {
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

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	@Override
	public String toString() {
		return "TemperatureDTO [value=" + value + ", timeStamp=" + timeStamp + ", sensorName=" + sensorName + "]";
	}
}
