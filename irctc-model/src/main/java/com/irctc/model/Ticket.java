package com.irctc.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "train")
public class Ticket {

	private BigInteger id;
	private Integer capacity;
	private BigDecimal price;
	private User user;
	private Train train;
	private LocalDateTime bookingDate;
	private LocalDateTime journeyDate;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private Station departureStation;
	private Station arrivalStation;
	private Boolean isCancelled;
	private LocalDateTime cancellationDate;

	public Ticket() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}

	@Column(name="capacity", nullable=false)
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Column (name="PRICE", nullable=false)
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id", nullable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="train_id", nullable=false)
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}

	@Column(name="booking_date", nullable=false)
	public LocalDateTime getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	@Column(name="journey_date", nullable=false)
	public LocalDateTime getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(LocalDateTime journeyDate) {
		this.journeyDate = journeyDate;
	}

	@Column(name="departure_time", nullable=false)
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	@Column(name="arrival_time", nullable=false)
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Column(name="departure_station", nullable=false)
	public Station getDepartureStation() {
		return departureStation;
	}
	public void setDepartureStation(Station departureStation) {
		this.departureStation = departureStation;
	}

	@Column(name="arrival_station", nullable=false)
	public Station getArrivalStation() {
		return arrivalStation;
	}
	public void setArrivalStation(Station arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	@Column(name="is_cancelled", nullable=false)
	public Boolean getIsCancelled() {
		return isCancelled;
	}
	public void setIsCancelled(Boolean isCancelled) {
		this.isCancelled = isCancelled;
	}
	
	@Column(name="cancellation_date", nullable=true)
	public LocalDateTime getCancellationDate() {
		return cancellationDate;
	}
	public void setCancellationDate(LocalDateTime cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", isCancelled=" + isCancelled + ", capacity=" + capacity + ", price=" + price
				+ ", user=" + user + ", train=" + train + ", bookingDate=" + bookingDate + ", journeyDate="
				+ journeyDate + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", departureStation=" + departureStation + ", arrivalStation=" + arrivalStation
				+ ", cancellationDate=" + cancellationDate + "]";
	}
}
