package com.irctc.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class TicketVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5457133369667714927L;
	private BigInteger id;
	private Integer capacity;
	private BigDecimal price;
	private BigInteger userId;
	private BigInteger trainId;
	private LocalDateTime bookingDate;
	private LocalDateTime journeyDate;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private BigInteger departureStationId;
	private BigInteger arrivalStationId;
	private Boolean isCancelled;
	private LocalDateTime cancellationDate;
	public TicketVo() {
		super();
	}
	public TicketVo(Integer capacity, BigDecimal price, BigInteger userId, BigInteger trainId,
			LocalDateTime bookingDate, LocalDateTime journeyDate, LocalDateTime departureTime,
			LocalDateTime arrivalTime, BigInteger departureStationId, BigInteger arrivalStationId, Boolean isCancelled,
			LocalDateTime cancellationDate) {
		super();
		this.capacity = capacity;
		this.price = price;
		this.userId = userId;
		this.trainId = trainId;
		this.bookingDate = bookingDate;
		this.journeyDate = journeyDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.departureStationId = departureStationId;
		this.arrivalStationId = arrivalStationId;
		this.isCancelled = isCancelled;
		this.cancellationDate = cancellationDate;
	}
	public TicketVo(BigInteger id, Integer capacity, BigDecimal price, BigInteger userId, BigInteger trainId,
			LocalDateTime bookingDate, LocalDateTime journeyDate, LocalDateTime departureTime,
			LocalDateTime arrivalTime, BigInteger departureStationId, BigInteger arrivalStationId, Boolean isCancelled,
			LocalDateTime cancellationDate) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.price = price;
		this.userId = userId;
		this.trainId = trainId;
		this.bookingDate = bookingDate;
		this.journeyDate = journeyDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.departureStationId = departureStationId;
		this.arrivalStationId = arrivalStationId;
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
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public BigInteger getTrainId() {
		return trainId;
	}
	public void setTrainId(BigInteger trainId) {
		this.trainId = trainId;
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
	public BigInteger getDepartureStationId() {
		return departureStationId;
	}
	public void setDepartureStationId(BigInteger departureStationId) {
		this.departureStationId = departureStationId;
	}
	public BigInteger getArrivalStationId() {
		return arrivalStationId;
	}
	public void setArrivalStationId(BigInteger arrivalStationId) {
		this.arrivalStationId = arrivalStationId;
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
		return "TicketVo [id=" + id + ", capacity=" + capacity + ", price=" + price + ", userId=" + userId
				+ ", trainId=" + trainId + ", bookingDate=" + bookingDate + ", journeyDate=" + journeyDate
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", departureStationId="
				+ departureStationId + ", arrivalStationId=" + arrivalStationId + ", isCancelled=" + isCancelled
				+ ", cancellationDate=" + cancellationDate + "]";
	}
	
	
}
