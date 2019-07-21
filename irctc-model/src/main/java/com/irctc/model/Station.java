package com.irctc.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="station")
public class Station implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3330538684490466797L;
	private BigInteger id;
	private String station_name;
	
	public Station()
	{
		super();
	}
	
	public Station(String station_name) {
		super();
		this.station_name = station_name;
	}
	
	public Station(BigInteger id, String station_name) {
		super();
		this.id = id;
		this.station_name = station_name;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	@Column(name="name", nullable = false)
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", station_name=" + station_name + "]";
	}
	
	

}
