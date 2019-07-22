package com.irctc.vo;

import java.io.Serializable;
import java.time.LocalTime;

public class ScheduleVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7330828341298964620L;
	private Integer id;
	private Integer stopId;
	private LocalTime departTime;
	private LocalTime arrivalTime;
	private Integer trainId;
	private Boolean ismonday;
	private Boolean istuesday;
	private Boolean iswednesday;
	private Boolean isthursday;
	private Boolean isfriday;
	private Boolean issaturday;
	private Boolean issunday;
	
	
	public ScheduleVo() {
		super();
	}
	
	public ScheduleVo(Integer stopId, LocalTime departTime, LocalTime arrivalTime, Integer trainId, Boolean ismonday,
			Boolean istuesday, Boolean iswednesday, Boolean isthursday, Boolean isfriday, Boolean issaturday,
			Boolean issunday) {
		super();
		this.stopId = stopId;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
		this.trainId = trainId;
		this.ismonday = ismonday;
		this.istuesday = istuesday;
		this.iswednesday = iswednesday;
		this.isthursday = isthursday;
		this.isfriday = isfriday;
		this.issaturday = issaturday;
		this.issunday = issunday;
	}
	
	

	public ScheduleVo(Integer id, Integer stopId, LocalTime departTime, LocalTime arrivalTime, Integer trainId,
			Boolean ismonday, Boolean istuesday, Boolean iswednesday, Boolean isthursday, Boolean isfriday,
			Boolean issaturday, Boolean issunday) {
		super();
		this.id = id;
		this.stopId = stopId;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
		this.trainId = trainId;
		this.ismonday = ismonday;
		this.istuesday = istuesday;
		this.iswednesday = iswednesday;
		this.isthursday = isthursday;
		this.isfriday = isfriday;
		this.issaturday = issaturday;
		this.issunday = issunday;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStopId() {
		return stopId;
	}
	public void setStopId(Integer stopId) {
		this.stopId = stopId;
	}
	public LocalTime getDepartTime() {
		return departTime;
	}
	public void setDepartTime(LocalTime departTime) {
		this.departTime = departTime;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Integer getTrainId() {
		return trainId;
	}
	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public Boolean getIsmonday() {
		return ismonday;
	}

	public void setIsmonday(Boolean ismonday) {
		this.ismonday = ismonday;
	}

	public Boolean getIstuesday() {
		return istuesday;
	}

	public void setIstuesday(Boolean istuesday) {
		this.istuesday = istuesday;
	}

	public Boolean getIswednesday() {
		return iswednesday;
	}

	public void setIswednesday(Boolean iswednesday) {
		this.iswednesday = iswednesday;
	}

	public Boolean getIsthursday() {
		return isthursday;
	}

	public void setIsthursday(Boolean isthursday) {
		this.isthursday = isthursday;
	}

	public Boolean getIsfriday() {
		return isfriday;
	}

	public void setIsfriday(Boolean isfriday) {
		this.isfriday = isfriday;
	}

	public Boolean getIssaturday() {
		return issaturday;
	}

	public void setIssaturday(Boolean issaturday) {
		this.issaturday = issaturday;
	}

	public Boolean getIssunday() {
		return issunday;
	}

	public void setIssunday(Boolean issunday) {
		this.issunday = issunday;
	}

	@Override
	public String toString() {
		return "ScheduleVo [id=" + id + ", stopId=" + stopId + ", departTime=" + departTime + ", arrivalTime="
				+ arrivalTime + ", trainId=" + trainId + ", ismonday=" + ismonday + ", istuesday=" + istuesday
				+ ", iswednesday=" + iswednesday + ", isthursday=" + isthursday + ", isfriday=" + isfriday
				+ ", issaturday=" + issaturday + ", issunday=" + issunday + "]";
	}
	
	
	
}
