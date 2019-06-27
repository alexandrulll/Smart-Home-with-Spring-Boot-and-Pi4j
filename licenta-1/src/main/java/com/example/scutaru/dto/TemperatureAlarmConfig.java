package com.example.scutaru.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TemperatureAlarmConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double value;
	private String alarmLabel;
	private String generatingEntity;

	public TemperatureAlarmConfig() {
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
