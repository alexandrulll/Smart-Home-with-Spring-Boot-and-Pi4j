package com.example.scutaru.dto;

import java.io.Serializable;

public class TemperatureAlarmConfigDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private double value;
	private String alarmLabel;
	private String generatingEntity;

	public TemperatureAlarmConfigDTO() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getAlarmLabel() {
		return alarmLabel;
	}

	public void setAlarmLabel(String alarmLabel) {
		this.alarmLabel = alarmLabel;
	}

	public String getGeneratingEntity() {
		return generatingEntity;
	}

	public void setGeneratingEntity(String generatingEntity) {
		this.generatingEntity = generatingEntity;
	}
}
