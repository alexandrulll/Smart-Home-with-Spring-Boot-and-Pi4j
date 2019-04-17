package com.example.scutaru.domain;

import java.io.Serializable;

public class DustSensor implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Float dustDesnsity;
	private String densityUnit;
	private Float voltage;
	private String voltageUnit;
	private Long timeStamp;

	public DustSensor() {
		super();
	}

	public Float getDustDesnsity() {
		return dustDesnsity;
	}

	public void setDustDesnsity(Float dustDesnsity) {
		this.dustDesnsity = dustDesnsity;
	}

	public Float getVoltage() {
		return voltage;
	}

	public void setVoltage(Float voltage) {
		this.voltage = voltage;
	}

	public String getDensityUnit() {
		return densityUnit;
	}

	public void setDensityUnit(String densityUnit) {
		this.densityUnit = densityUnit;
	}

	public String getVoltageUnit() {
		return voltageUnit;
	}

	public void setVoltageUnit(String voltageUnit) {
		this.voltageUnit = voltageUnit;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DustSensor [id=" + id + ", dustDesnsity=" + dustDesnsity + ", densityUnit=" + densityUnit + ", voltage="
				+ voltage + ", voltageUnit=" + voltageUnit + ", timeStamp=" + timeStamp + "]";
	}

}
