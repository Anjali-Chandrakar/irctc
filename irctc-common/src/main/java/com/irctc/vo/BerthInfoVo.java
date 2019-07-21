package com.irctc.vo;

import java.io.Serializable;
import java.math.BigInteger;

public class BerthInfoVo implements Serializable{

	private static final long serialVersionUID = 3256817098683187897L;
	private Long id;
	private BigInteger trainId;
	private BigInteger ticketId;
	private BigInteger passengerId;
	private Integer seat;
	private Boolean isCancelled;
	
	public BerthInfoVo() {
		super();
	}
	
	public BerthInfoVo(BigInteger trainId, BigInteger ticketId, BigInteger passengerId, Integer seat,
			Boolean isCancelled) {
		super();
		this.trainId = trainId;
		this.ticketId = ticketId;
		this.passengerId = passengerId;
		this.seat = seat;
		this.isCancelled = isCancelled;
	}

	public BerthInfoVo(Long id, BigInteger trainId, BigInteger ticketId, BigInteger passengerId, Integer seat,
			Boolean isCancelled) {
		super();
		this.id = id;
		this.trainId = trainId;
		this.ticketId = ticketId;
		this.passengerId = passengerId;
		this.seat = seat;
		this.isCancelled = isCancelled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigInteger getTrainId() {
		return trainId;
	}

	public void setTrainId(BigInteger trainId) {
		this.trainId = trainId;
	}

	public BigInteger getTicketId() {
		return ticketId;
	}

	public void setTicketId(BigInteger ticketId) {
		this.ticketId = ticketId;
	}

	public BigInteger getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(BigInteger passengerId) {
		this.passengerId = passengerId;
	}

	public Integer getSeat() {
		return seat;
	}

	public void setSeat(Integer seat) {
		this.seat = seat;
	}

	public Boolean getIsCancelled() {
		return isCancelled;
	}

	public void setIsCancelled(Boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	@Override
	public String toString() {
		return "BerthInfoVo [id=" + id + ", trainId=" + trainId + ", ticketId=" + ticketId + ", passengerId="
				+ passengerId + ", seat=" + seat + ", isCancelled=" + isCancelled + "]";
	}
	

	
}
