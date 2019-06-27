package com.example.scutaru.dto;

import java.io.Serializable;

public class AlarmThresholdDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long Id;
	private Double value;

	public AlarmThresholdDTO() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
