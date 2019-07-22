package com.irctc.model;

import java.io.Serializable;

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
	private static final long serialVersionUID = -6630380101825208119L;
	private Integer id;
	private String station_name;
	
	public Station()
	{
		super();
	}
	
	public Station(String station_name) {
		super();
		this.station_name = station_name;
	}
	
	public Station(Integer id, String station_name) {
		super();
		this.id = id;
		this.station_name = station_name;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
