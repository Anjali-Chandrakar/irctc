package com.irctc.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
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
@Table(name = "ticket")
public class Ticket implements Serializable {
	private static final long serialVersionUID = -191454783136156144L;
	private Integer id;
	private Integer capacity;
	private Integer price;
	private User user;
	private Train train;
	private LocalDateTime bookingDate;
	private LocalDateTime journeyDate;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	private Station departureStation;
	private Station arrivalStation;
	private Boolean isCancelled;
	private LocalDateTime cancellationDate;

	public Ticket() {
	}

	public Ticket(Integer capacity, Integer price, User user, Train train, LocalDateTime bookingDate,
			LocalDateTime journeyDate, LocalTime departureTime, LocalTime arrivalTime, Station departureStation,
			Station arrivalStation, Boolean isCancelled, LocalDateTime cancellationDate) {
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

	public Ticket(Integer id, Integer capacity, Integer price, User user, Train train, LocalDateTime bookingDate,
			LocalDateTime journeyDate, LocalTime departureTime, LocalTime arrivalTime, Station departureStation,
			Station arrivalStation, Boolean isCancelled, LocalDateTime cancellationDate) {
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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
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
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	@Column(name="arrival_time", nullable=false)
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn (name ="station_id")
	public Station getDepartureStation() {
		return departureStation;
	}
	public void setDepartureStation(Station departureStation) {
		this.departureStation = departureStation;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn (name ="arrival_station_id")
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
