package com.example.scutaru.dto;

import java.io.Serializable;

public class ImportanceDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long importanceId;
	private String importanceLabel;
	private String appereanceColour;

	public ImportanceDTO() {
		super();
	}

	public Long getImportanceId() {
		return importanceId;
	}

	public void setImportanceId(Long importanceId) {
		this.importanceId = importanceId;
	}

	public String getImportanceLabel() {
		return importanceLabel;
	}

	public void setImportanceLabel(String importanceLabel) {
		this.importanceLabel = importanceLabel;
	}

	public String getAppereanceColour() {
		return appereanceColour;
	}

	public void setAppereanceColour(String appereanceColour) {
		this.appereanceColour = appereanceColour;
	}

	@Override
	public String toString() {
		return "ImportanceDTO [importanceId=" + importanceId + ", importanceLabel=" + importanceLabel
				+ ", appereanceColour=" + appereanceColour + "]";
	}

}
