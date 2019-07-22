package com.irctc.model;
import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4889917024581605833L;
	private Integer id;
	private Station stop;
	private LocalTime departTime;
	private LocalTime arrivalTime;
	private Train train;
	private Boolean ismonday;
	private Boolean istuesday;
	private Boolean iswednesday;
	private Boolean isthursday;
	private Boolean isfriday;
	private Boolean issaturday;
	private Boolean issunday;
	


	public Schedule() {
		super();
	}
	
	
	public Schedule(Station stop, LocalTime departTime, LocalTime arrivalTime, Train train, Boolean ismonday,
			Boolean istuesday, Boolean iswednesday, Boolean isthursday, Boolean isfriday, Boolean issaturday,
			Boolean issunday) {
		super();
		this.stop = stop;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
		this.train = train;
		this.ismonday = ismonday;
		this.istuesday = istuesday;
		this.iswednesday = iswednesday;
		this.isthursday = isthursday;
		this.isfriday = isfriday;
		this.issaturday = issaturday;
		this.issunday = issunday;
	}


	public Schedule(Integer id, Station stop, LocalTime departTime, LocalTime arrivalTime, Train train,
			Boolean ismonday, Boolean istuesday, Boolean iswednesday, Boolean isthursday, Boolean isfriday,
			Boolean issaturday, Boolean issunday) {
		super();
		this.id = id;
		this.stop = stop;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
		this.train = train;
		this.ismonday = ismonday;
		this.istuesday = istuesday;
		this.iswednesday = iswednesday;
		this.isthursday = isthursday;
		this.isfriday = isfriday;
		this.issaturday = issaturday;
		this.issunday = issunday;
	}


	@Id
	@Column(name="schedule_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public LocalTime getDepartTime() {
		return departTime;
	}
	public void setDepartTime(LocalTime departTime) {
		this.departTime = departTime;
	}

	@Column(name="arrival_time")
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
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

	@Column(name="is_monday", nullable=false)
	public Boolean getIsmonday() {
		return ismonday;
	}


	public void setIsmonday(Boolean ismonday) {
		this.ismonday = ismonday;
	}

	@Column(name="is_tuesday", nullable=false)
	public Boolean getIstuesday() {
		return istuesday;
	}


	public void setIstuesday(Boolean istuesday) {
		this.istuesday = istuesday;
	}

	@Column(name="is_wednesday", nullable=false)
	public Boolean getIswednesday() {
		return iswednesday;
	}


	public void setIswednesday(Boolean iswednesday) {
		this.iswednesday = iswednesday;
	}

	@Column(name="is_thursday", nullable=false)
	public Boolean getIsthursday() {
		return isthursday;
	}


	public void setIsthursday(Boolean isthursday) {
		this.isthursday = isthursday;
	}

	@Column(name="is_friday", nullable=false)
	public Boolean getIsfriday() {
		return isfriday;
	}


	public void setIsfriday(Boolean isfriday) {
		this.isfriday = isfriday;
	}

	@Column(name="is_saturday", nullable=false)
	public Boolean getIssaturday() {
		return issaturday;
	}


	public void setIssaturday(Boolean issaturday) {
		this.issaturday = issaturday;
	}

	@Column(name="is_sunday", nullable=false)
	public Boolean getIssunday() {
		return issunday;
	}


	public void setIssunday(Boolean issunday) {
		this.issunday = issunday;
	}


	@Override
	public String toString() {
		return "Schedule [id=" + id + ", stop=" + stop + ", departTime=" + departTime + ", arrivalTime=" + arrivalTime
				+ ", train=" + train + ", ismonday=" + ismonday + ", istuesday=" + istuesday + ", iswednesday="
				+ iswednesday + ", isthursday=" + isthursday + ", isfriday=" + isfriday + ", issaturday=" + issaturday
				+ ", issunday=" + issunday + "]";
	}

	


}
