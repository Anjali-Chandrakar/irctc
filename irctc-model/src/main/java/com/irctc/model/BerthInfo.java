package com.irctc.model;

import java.io.Serializable;

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
@Table(name = "berth_info")
public class BerthInfo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4349639900259040246L;
	private Integer id;
	private Train train;
	private Ticket ticket;
	private Passenger passenger;
	private Integer seat;
	private Boolean isCancelled;

	public BerthInfo() {
		super();
	}
	
	public BerthInfo(Train train, Ticket ticket, Passenger passenger, Integer seat, Boolean isCancelled) {
		super();
		this.train = train;
		this.ticket = ticket;
		this.passenger = passenger;
		this.seat = seat;
		this.isCancelled = isCancelled;
	}

	public BerthInfo(Integer id, Train train, Ticket ticket, Passenger passenger, Integer seat, Boolean isCancelled) {
		super();
		this.id = id;
		this.train = train;
		this.ticket = ticket;
		this.passenger = passenger;
		this.seat = seat;
		this.isCancelled = isCancelled;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="train_id", nullable=false)
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}


	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ticket_id", nullable=false)
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}


	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="passenger_id", nullable=false)
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	@Column(name="seat_number", nullable=false)
	public Integer getSeat() {
		return seat;
	}
	public void setSeat(Integer seat) {
		this.seat = seat;
	}

	@Column(name="is_cancelled", nullable=false)
	public Boolean getIsCancelled() {
		return isCancelled;
	}
	public void setIsCancelled(Boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	@Override
	public String toString() {
		return "BerthInfo [id=" + id + ", train=" + train + ", ticket=" + ticket + ", passenger=" + passenger
				+ ", seat=" + seat + ", isCancelled=" + isCancelled + "]";
	}
}
