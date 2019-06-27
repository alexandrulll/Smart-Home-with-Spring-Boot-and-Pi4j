package com.example.scutaru.dto;

import java.io.Serializable;

public class DustAlarmConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	private double value;
	private String alarmLabel;
	private String generatingEntity;

	public DustAlarmConfig() {
		super();
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
