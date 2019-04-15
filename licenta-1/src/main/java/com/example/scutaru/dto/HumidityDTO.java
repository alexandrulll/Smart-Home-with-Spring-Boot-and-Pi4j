package com.example.scutaru.dto;

import java.io.Serializable;

public class HumidityDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double value;
	private Long timeStamp;
	private String sensorName;
	private String measureUnit;

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

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	@Override
	public String toString() {
		return "HumidityDTO [value=" + value + ", timeStamp=" + timeStamp + ", sensorName=" + sensorName
				+ ", measureUnit=" + measureUnit + "]";
	}

}
