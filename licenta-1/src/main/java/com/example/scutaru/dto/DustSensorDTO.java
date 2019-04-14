package com.example.scutaru.dto;

import java.io.Serializable;

public class DustSensorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Float dustDesnsity;
	private Float voltage;

	public DustSensorDTO() {
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

	@Override
	public String toString() {
		return "DustSensorDTO [dustDesnsity=" + dustDesnsity + ", voltage=" + voltage + "]";
	}

}
