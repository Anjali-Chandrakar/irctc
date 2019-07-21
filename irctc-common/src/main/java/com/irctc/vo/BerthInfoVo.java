package com.irctc.vo;

import java.io.Serializable;
import java.math.BigInteger;

public class BerthInfoVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3127806602455277606L;
	private Long id;
	private BigInteger train;
	private BigInteger ticket;
	private BigInteger passenger;
	private Integer seat;
	private Boolean isCancelled;
	
	public BerthInfoVo() {
		super();
	}


	public BerthInfoVo(BigInteger train, BigInteger ticket, BigInteger passenger, Integer seat, Boolean isCancelled) {
		super();
		this.train = train;
		this.ticket = ticket;
		this.passenger = passenger;
		this.seat = seat;
		this.isCancelled = isCancelled;
	}


	public BerthInfoVo(Long id, BigInteger train, BigInteger ticket, BigInteger passenger, Integer seat,
			Boolean isCancelled) {
		super();
		this.id = id;
		this.train = train;
		this.ticket = ticket;
		this.passenger = passenger;
		this.seat = seat;
		this.isCancelled = isCancelled;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public BigInteger getTrain() {
		return train;
	}


	public void setTrain(BigInteger train) {
		this.train = train;
	}


	public BigInteger getTicket() {
		return ticket;
	}


	public void setTicket(BigInteger ticket) {
		this.ticket = ticket;
	}


	public BigInteger getPassenger() {
		return passenger;
	}


	public void setPassenger(BigInteger passenger) {
		this.passenger = passenger;
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
		return "BerthInfoVo [id=" + id + ", train=" + train + ", ticket=" + ticket + ", passenger=" + passenger
				+ ", seat=" + seat + ", isCancelled=" + isCancelled + "]";
	}
	
}
