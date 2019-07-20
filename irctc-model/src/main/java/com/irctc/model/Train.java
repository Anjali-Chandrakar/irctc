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
	private Integer capacity;

	public Train() {
		super();
	}
	
	public Train(BigInteger id, Integer capacity) {
		super();
		this.id = id;
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
	
	@Column(name="CAPACITY")
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", capacity=" + capacity + "]";
	}
}
