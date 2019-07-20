package com.irctc.model;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "train")
public class Train implements java.io.Serializable{

	private static final long serialVersionUID = 2836462165015149465L;
	private BigInteger id;
	private String trainName;
	private Integer capacity;

	public Train() {
		super();
	}
	
	public Train(String trainName, Integer capacity) {
		super();
		this.trainName = trainName;
		this.capacity = capacity;
	}

	public Train(BigInteger id, String trainName, Integer capacity) {
		super();
		this.id = id;
		this.trainName = trainName;
		this.capacity = capacity;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	@Column(name="train_name", nullable = false, length = 20)
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	@Column(name="capacity")
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", trainName=" + trainName + ", capacity=" + capacity + "]";
	}
}
