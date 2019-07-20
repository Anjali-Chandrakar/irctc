package com.irctc.model;
import java.io.Serializable;

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

@Entity
public class Schedule implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3739060601556572711L;

	@Id
	@Column(name="SCHEDULE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long scheduleId;
	
	@Column(name="STATION")
	@Enumerated(EnumType.STRING)
	private Station stop;
	
	@Column(name="DEPART_TIME_AT_STATION")
	private String departTime;
	
	@Column(name="ARRIVAL_TIME_AT_STATION")
	private String arrivalTime;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn (name ="TRAIN_ID")
	private Train train;
	
	public Schedule()
	{
		super();
	}

	public Schedule(long scheduleId, Station stop, String departTime, String arrivalTime, Train train) {
		super();
		this.scheduleId = scheduleId;
		this.stop = stop;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
		this.train = train;
	}

	public long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Station getStop() {
		return stop;
	}

	public void setStop(Station stop) {
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

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", stop=" + stop + ", departTime=" + departTime + ", arrivalTime="
				+ arrivalTime + ", train=" + train + "]";
	}


}
