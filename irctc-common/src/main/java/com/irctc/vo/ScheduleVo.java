package com.irctc.vo;

import java.io.Serializable;
import java.math.BigInteger;

public class ScheduleVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6373390425502679734L;
	private BigInteger id;
	private BigInteger stop;
	private String departTime;
	private String arrivalTime;
	private BigInteger train;
	
	public ScheduleVo() {
		super();
	}

	public ScheduleVo(BigInteger stop, String departTime, String arrivalTime, BigInteger train) {
		super();
		this.stop = stop;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
		this.train = train;
	}

	public ScheduleVo(BigInteger id, BigInteger stop, String departTime, String arrivalTime, BigInteger train) {
		super();
		this.id = id;
		this.stop = stop;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
		this.train = train;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getStop() {
		return stop;
	}

	public void setStop(BigInteger stop) {
		this.stop = stop;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public BigInteger getTrain() {
		return train;
	}

	public void setTrain(BigInteger train) {
		this.train = train;
	}

	@Override
	public String toString() {
		return "ScheduleVo [id=" + id + ", stop=" + stop + ", departTime=" + departTime + ", arrivalTime=" + arrivalTime
				+ ", train=" + train + "]";
	}
	
	
	
}
