package com.example.scutaru.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alarm")
public class Alarm implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "alarm_label")
	private String alarmLabel;
	
	@Column(name = "generating_entity")
	private String generatingEntity;
	
	@Column(name = "generating_value")
	private String generatingValue;

	public Alarm() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getGeneratingValue() {
		return generatingValue;
	}

	public void setGeneratingValue(String generatingValue) {
		this.generatingValue = generatingValue;
	}

	@Override
	public String toString() {
		return "Alarm [id=" + id + ", alarmLabel=" + alarmLabel + ", generatingEntity=" + generatingEntity
				+ ", generatingValue=" + generatingValue + "]";
	}

}
