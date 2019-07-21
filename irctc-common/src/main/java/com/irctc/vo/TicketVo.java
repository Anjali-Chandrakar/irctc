package com.irctc.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class TicketVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1566914460003088547L;
	private BigInteger id;
	private Integer capacity;
	private BigDecimal price;
	private BigInteger user;
	private BigInteger train;
	private LocalDateTime bookingDate;
	private LocalDateTime journeyDate;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private BigInteger departureStation;
	private BigInteger arrivalStation;
	private Boolean isCancelled;
	private LocalDateTime cancellationDate;
	
	public TicketVo() {
		super();
	}

	public TicketVo(Integer capacity, BigDecimal price, BigInteger user, BigInteger train, LocalDateTime bookingDate,
			LocalDateTime journeyDate, LocalDateTime departureTime, LocalDateTime arrivalTime,
			BigInteger departureStation, BigInteger arrivalStation, Boolean isCancelled,
			LocalDateTime cancellationDate) {
		super();
		this.capacity = capacity;
		this.price = price;
		this.user = user;
		this.train = train;
		this.bookingDate = bookingDate;
		this.journeyDate = journeyDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.isCancelled = isCancelled;
		this.cancellationDate = cancellationDate;
	}

	public TicketVo(BigInteger id, Integer capacity, BigDecimal price, BigInteger user, BigInteger train,
			LocalDateTime bookingDate, LocalDateTime journeyDate, LocalDateTime departureTime,
			LocalDateTime arrivalTime, BigInteger departureStation, BigInteger arrivalStation, Boolean isCancelled,
			LocalDateTime cancellationDate) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.price = price;
		this.user = user;
		this.train = train;
		this.bookingDate = bookingDate;
		this.journeyDate = journeyDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.isCancelled = isCancelled;
		this.cancellationDate = cancellationDate;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigInteger getUser() {
		return user;
	}

	public void setUser(BigInteger user) {
		this.user = user;
	}

	public BigInteger getTrain() {
		return train;
	}

	public void setTrain(BigInteger train) {
		this.train = train;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDateTime getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDateTime journeyDate) {
		this.journeyDate = journeyDate;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public BigInteger getDepartureStation() {
		return departureStation;
	}

	public void setDepartureStation(BigInteger departureStation) {
		this.departureStation = departureStation;
	}

	public BigInteger getArrivalStation() {
		return arrivalStation;
	}

	public void setArrivalStation(BigInteger arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	public Boolean getIsCancelled() {
		return isCancelled;
	}

	public void setIsCancelled(Boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	public LocalDateTime getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(LocalDateTime cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	@Override
	public String toString() {
		return "TicketVo [id=" + id + ", capacity=" + capacity + ", price=" + price + ", user=" + user + ", train="
				+ train + ", bookingDate=" + bookingDate + ", journeyDate=" + journeyDate + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", departureStation=" + departureStation
				+ ", arrivalStation=" + arrivalStation + ", isCancelled=" + isCancelled + ", cancellationDate="
				+ cancellationDate + "]";
	}
	
	
	
}
