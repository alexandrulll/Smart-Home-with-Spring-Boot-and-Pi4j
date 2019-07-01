package com.example.scutaru.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dust")
public class DustSensor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "dust_density")
	private Float dustDesnsity;
	
	@Column(name = "density_unit")
	private String densityUnit;
	
	@Column(name = "voltage")
	private Float voltage;
	
	@Column(name = "voltage_unit")
	private String voltageUnit;
	
	@Column(name = "timeStamp")
	private Long timeStamp;

	public DustSensor() {
		super();
	}

	public Float getDustDesnsity() {
		return dustDesnsity;
	}

	public void setDustDesnsity(Float dustDesnsity) {
		this.dustDesnsity = dustDesnsity;
	}

	public Float getVoltage() {
		return voltage;
	}

	public void setVoltage(Float voltage) {
		this.voltage = voltage;
	}

	public String getDensityUnit() {
		return densityUnit;
	}

	public void setDensityUnit(String densityUnit) {
		this.densityUnit = densityUnit;
	}

	public String getVoltageUnit() {
		return voltageUnit;
	}

	public void setVoltageUnit(String voltageUnit) {
		this.voltageUnit = voltageUnit;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DustSensor [id=" + id + ", dustDesnsity=" + dustDesnsity + ", densityUnit=" + densityUnit + ", voltage="
				+ voltage + ", voltageUnit=" + voltageUnit + ", timeStamp=" + timeStamp + "]";
	}

}
