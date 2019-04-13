package com.exemplu.scutaru.dto;

import java.io.Serializable;

public class Dht11DTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private TemperatureDTO temperatureDTO;
	private HumidityDTO humidityDTO;

	public Dht11DTO() {
		super();
	}

	public TemperatureDTO getTemperatureDTO() {
		return temperatureDTO;
	}

	public void setTemperatureDTO(TemperatureDTO temperatureDTO) {
		this.temperatureDTO = temperatureDTO;
	}

	public HumidityDTO getHumidityDTO() {
		return humidityDTO;
	}

	public void setHumidityDTO(HumidityDTO humidityDTO) {
		this.humidityDTO = humidityDTO;
	}

	@Override
	public String toString() {
		return "Dht11DTO [temperatureDTO=" + temperatureDTO + ", humidityDTO=" + humidityDTO + "]";
	}

}
