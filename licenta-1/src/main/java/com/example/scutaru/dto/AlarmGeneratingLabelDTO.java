package com.example.scutaru.dto;

import java.io.Serializable;

public class AlarmGeneratingLabelDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long Id;
	private String entity;
	
	public AlarmGeneratingLabelDTO() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}
}
