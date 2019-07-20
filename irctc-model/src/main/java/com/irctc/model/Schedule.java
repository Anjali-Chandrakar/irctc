package com.irctc.model;
import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule implements Serializable{

	private static final long serialVersionUID = -3739060601556572711L;
	private BigInteger id;
	private Station stop;
	private String departTime;
	private String arrivalTime;
	private Train train;
	
	public Schedule() {
	}

	public Schedule(Station stop, String departTime, String arrivalTime, Train train) {
		super();
		this.stop = stop;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
		this.train = train;
	}

	public Schedule(BigInteger id, Station stop, String departTime, String arrivalTime, Train train) {
		super();
		this.id = id;
		this.stop = stop;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
		this.train = train;
	}

	@Id
	@Column(name="schedule_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}

	@Column(name="station")
//	@Enumerated(EnumType.STRING)
	public Station getStop() {
		return stop;
	}
	public void setStop(Station stop) {
		this.stop = stop;
	}

	@Column(name="depart_time")
	public String getDepartTime() {
		return departTime;
	}
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	@Column(name="arrival_time")
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn (name ="train_id")
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}



}
