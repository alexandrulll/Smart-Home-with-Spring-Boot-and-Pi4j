package com.example.scutaru.dto;

import java.io.Serializable;

public class AlarmDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private ImportanceDTO importanceDTO;
	private Long alarmId;
	private String alarmLabel;
	private String generatingEntity;
	private String generatingValue;
	private String generatingLabel;

	public AlarmDTO() {
		super();
	}

	public ImportanceDTO getImportanceDTO() {
		return importanceDTO;
	}

	public void setImportanceDTO(ImportanceDTO importanceDTO) {
		this.importanceDTO = importanceDTO;
	}

	public Long getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(Long alarmId) {
		this.alarmId = alarmId;
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

	public String getGeneratingLabel() {
		return generatingLabel;
	}

	public void setGeneratingLabel(String generatingLabel) {
		this.generatingLabel = generatingLabel;
	}

	@Override
	public String toString() {
		return "AlarmDTO [importanceDTO=" + importanceDTO + ", alarmId=" + alarmId + ", alarmLabel=" + alarmLabel
				+ ", generatingEntity=" + generatingEntity + ", generatingValue=" + generatingValue
				+ ", generatingLabel=" + generatingLabel + "]";
	}

}
