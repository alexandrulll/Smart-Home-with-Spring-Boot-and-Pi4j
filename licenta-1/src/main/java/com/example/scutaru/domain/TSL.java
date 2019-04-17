package com.example.scutaru.domain;

import java.io.Serializable;

public class TSL implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Double fullSpectrum;
	private Double infraredSpectrum;
	private Double visibleSpectrum;
	private Long timeStamp;
	private String measureUnit;

	public TSL() {
		super();
	}

	public Double getFullSpectrum() {
		return fullSpectrum;
	}

	public void setFullSpectrum(Double fullSpectrum) {
		this.fullSpectrum = fullSpectrum;
	}

	public Double getInfraredSpectrum() {
		return infraredSpectrum;
	}

	public void setInfraredSpectrum(Double infraredSpectrum) {
		this.infraredSpectrum = infraredSpectrum;
	}

	public Double getVisibleSpectrum() {
		return visibleSpectrum;
	}

	public void setVisibleSpectrum(Double visibleSpectrum) {
		this.visibleSpectrum = visibleSpectrum;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TSL [id=" + id + ", fullSpectrum=" + fullSpectrum + ", infraredSpectrum=" + infraredSpectrum
				+ ", visibleSpectrum=" + visibleSpectrum + ", timeStamp=" + timeStamp + ", measureUnit=" + measureUnit
				+ "]";
	}

}
