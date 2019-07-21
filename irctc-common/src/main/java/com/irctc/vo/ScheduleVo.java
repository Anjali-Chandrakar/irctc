package com.irctc.vo;

import java.io.Serializable;
import java.math.BigInteger;

public class ScheduleVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8020716604025378871L;
	private BigInteger id;
	private BigInteger stopId;
	private String departTime;
	private String arrivalTime;
	private BigInteger trainId;
	public ScheduleVo() {
		super();
	}
	public ScheduleVo(BigInteger stopId, String departTime, String arrivalTime, BigInteger trainId) {
		super();
		this.stopId = stopId;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
		this.trainId = trainId;
	}
	public ScheduleVo(BigInteger id, BigInteger stopId, String departTime, String arrivalTime, BigInteger trainId) {
		super();
		this.id = id;
		this.stopId = stopId;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
		this.trainId = trainId;
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public BigInteger getStopId() {
		return stopId;
	}
	public void setStopId(BigInteger stopId) {
		this.stopId = stopId;
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
	public BigInteger getTrainId() {
		return trainId;
	}
	public void setTrainId(BigInteger trainId) {
		this.trainId = trainId;
	}
	@Override
	public String toString() {
		return "ScheduleVo [id=" + id + ", stopId=" + stopId + ", departTime=" + departTime + ", arrivalTime="
				+ arrivalTime + ", trainId=" + trainId + "]";
	}
		
}
