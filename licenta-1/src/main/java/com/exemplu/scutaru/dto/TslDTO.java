package com.exemplu.scutaru.dto;

import java.io.Serializable;

public class TslDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double fullSpectrum;
	private Double infraredSpectrum;
	private Double visibleSpectrum;

	public TslDTO() {
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

	@Override
	public String toString() {
		return "TslDTO [fullSpectrum=" + fullSpectrum + ", infraredSpectrum=" + infraredSpectrum + ", visibleSpectrum="
				+ visibleSpectrum + "]";
	}

}