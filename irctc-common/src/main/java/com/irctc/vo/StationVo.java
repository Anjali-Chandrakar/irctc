package com.irctc.vo;

import java.io.Serializable;
import java.math.BigInteger;

public class StationVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5007263025247497965L;
	private BigInteger id;
	private String station_name;
	
	
	public StationVo() {
		super();
	}

	public StationVo(String station_name) {
		super();
		this.station_name = station_name;
	}

	public StationVo(BigInteger id, String station_name) {
		super();
		this.id = id;
		this.station_name = station_name;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	@Override
	public String toString() {
		return "StationVo [id=" + id + ", station_name=" + station_name + "]";
	}
	
	
	
	
}
