package com.irctc.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TicketVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2129604990352013288L;
	private Integer id;
	private Integer capacity;
	private Integer price;
	private Integer userId;
	private Integer trainId;
	private LocalDateTime bookingDate;
	private LocalDateTime journeyDate;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	private Integer departureStationId;
	private Integer arrivalStationId;
	private Boolean isCancelled;
	private LocalDateTime cancellationDate;
	public TicketVo() {
		super();
	}
	public TicketVo(Integer capacity, Integer price, Integer userId, Integer trainId, LocalDateTime bookingDate,
			LocalDateTime journeyDate, LocalTime departureTime, LocalTime arrivalTime, Integer departureStationId,
			Integer arrivalStationId, Boolean isCancelled, LocalDateTime cancellationDate) {
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
	public TicketVo(Integer id, Integer capacity, Integer price, Integer userId, Integer trainId,
			LocalDateTime bookingDate, LocalDateTime journeyDate, LocalTime departureTime, LocalTime arrivalTime,
			Integer departureStationId, Integer arrivalStationId, Boolean isCancelled, LocalDateTime cancellationDate) {
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTrainId() {
		return trainId;
	}
	public void setTrainId(Integer trainId) {
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
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Integer getDepartureStationId() {
		return departureStationId;
	}
	public void setDepartureStationId(Integer departureStationId) {
		this.departureStationId = departureStationId;
	}
	public Integer getArrivalStationId() {
		return arrivalStationId;
	}
	public void setArrivalStationId(Integer arrivalStationId) {
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
