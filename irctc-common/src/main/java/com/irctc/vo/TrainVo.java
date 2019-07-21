package com.irctc.vo;

import java.io.Serializable;
import java.math.BigInteger;

public class TrainVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5591221703485152012L;
	private BigInteger id;
	private String trainName;
	private Integer capacity;
	
	public TrainVo() {
		super();
	}
	
	public TrainVo(String trainName, Integer capacity) {
		super();
		this.trainName = trainName;
		this.capacity = capacity;
	}
	
	public TrainVo(BigInteger id, String trainName, Integer capacity) {
		super();
		this.id = id;
		this.trainName = trainName;
		this.capacity = capacity;
	}
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "TrainVo [id=" + id + ", trainName=" + trainName + ", capacity=" + capacity + "]";
	}
	
	
	
	
}
