package com.irctc.service.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.irctc.dao.StationDao;
import com.irctc.dao.TicketDao;
import com.irctc.dao.TrainDao;
import com.irctc.dao.UserDao;
import com.irctc.model.Ticket;
import com.irctc.model.Station;
import com.irctc.model.Train;
import com.irctc.model.User;
import com.irctc.service.TicketService;
import com.irctc.utils.Constants;
import com.irctc.vo.TicketVo;

@Component
public class TicketServiceImpl implements TicketService{
	@Autowired
	private TicketDao ticketDao;
	
	@Autowired 
	private StationDao stationDao;
	
	@Autowired
	private TrainDao trainDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public Map<String, Object> createTicket(TicketVo ticketVo) {
		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
		
		if (ticketVo == null){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Input required");
			return responseMap;
		}
		
		Integer capacity=ticketVo.getCapacity();
		if (capacity == null || capacity <= 0 ){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "capacity can not be empty ,zero or less than zero");
			return responseMap;
		}
		
		Integer price=ticketVo.getPrice();
		if (price == null || price <= 0 ){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "price can not be empty ,zero or less than zero");
			return responseMap;
		}
		
		Integer trainId = ticketVo.getTrainId();
	    if (trainId== null || trainId <= 0){
				responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
				responseMap.put(Constants.MESSAGE, "train id can not be empty ,zero or less than zero");
				return responseMap;
		}
		Optional<Train> trainOptional = trainDao.findById(trainId);
			if(!trainOptional.isPresent()) {
					responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
					responseMap.put(Constants.MESSAGE, "no train record found");
					return responseMap;
			}
			
		Integer userId = ticketVo.getUserId();
		if (userId== null || userId <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "user id can not be empty ,zero or less than zero");
			return responseMap;
		}
		Optional<User> userOptional = userDao.findById(userId);
			if(!userOptional.isPresent()) {
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no user record found");
			return responseMap;
			}
		
		
		LocalTime arrivalTime = ticketVo.getArrivalTime();
	    LocalTime departTime = ticketVo.getDepartureTime();
		if(arrivalTime == null)
		{
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "arrivalTime can not be empty");
			return responseMap;	
		}
		if(departTime == null)
		{
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "departTime can not be empty");
			return responseMap;	
		}
		if(arrivalTime.isAfter(departTime))
	    {
	    	responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "arrival time can not be after departure time");
			return responseMap;
	    } 
	    
		LocalDateTime journeyDate=ticketVo.getJourneyDate();
		if(journeyDate == null)
		{
	    	responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "journeyDate cannot be empty");
			return responseMap;
		}
		LocalDateTime cancellationDate=ticketVo.getCancellationDate();
	
		LocalDateTime bookingDate=ticketVo.getBookingDate();
		if(bookingDate == null)
		{
	    	responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "bookingDate cannot be empty");
			return responseMap;
		}
		if(cancellationDate != null) {
		if(cancellationDate.isBefore(bookingDate))
		{
	    	responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "cancellationDate should be after bookingDate");
			return responseMap;
		}
		}
		if(journeyDate.isBefore(bookingDate)){
	    	responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "journeyDate should be after bookingDate");
			return responseMap;
		}
		Integer arrivalStationId = ticketVo.getArrivalStationId();
		if (arrivalStationId== null || arrivalStationId <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Arrival Station id can not be empty ,zero or less than zero");
			return responseMap;
		}
		Optional<Station> arrivalstationOptional = stationDao.findById(arrivalStationId);
			if(!arrivalstationOptional.isPresent()) {
				responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
				responseMap.put(Constants.MESSAGE, "no Arrival station record found");
				return responseMap;
			}
	
		
		Integer departureStationId = ticketVo.getDepartureStationId();
		if (departureStationId== null || departureStationId <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Departure id can not be empty ,zero or less than zero");
			return responseMap;
		}
		
		Optional<Station> departureStationOptional = stationDao.findById(departureStationId);
			if(!departureStationOptional.isPresent()) {
				responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
				responseMap.put(Constants.MESSAGE, "no Departure station record found");
				return responseMap;
			}
	
		
		Boolean isCancelled= ticketVo.getIsCancelled();
		if(isCancelled == null)
		{
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "isCancelled should not be empty");
			return responseMap;
		}
		
		Ticket ticket = new Ticket(ticketVo.getCapacity(), ticketVo.getPrice(), userOptional.get(), trainOptional.get(), ticketVo.getBookingDate(),
				ticketVo.getJourneyDate(),ticketVo.getDepartureTime(), ticketVo.getArrivalTime(),departureStationOptional.get(),
				arrivalstationOptional.get(), ticketVo.getIsCancelled(), ticketVo.getCancellationDate());
		Ticket savedTicket = ticketDao.save(ticket);

			if (savedTicket != null) {
				responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
				responseMap.put(Constants.MESSAGE, "ticket record created successfully");
				responseMap.put("id",savedTicket.getId());
			}
			else {
				responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
				responseMap.put(Constants.MESSAGE, "Something went wrong, ticket cannot be created");
			}
		return responseMap;
	}

	@Override
	public Map<String, Object> readTicket(Integer id) {
		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();

		if (id == null || id <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "id can not be empty ,zero or less than zero");
			return responseMap;
		}

		Optional<Ticket> ticketOptional = ticketDao.findById(id);

		if(ticketOptional.isPresent()){
			Ticket ticket = ticketOptional.get();
			TicketVo ticketVo = new TicketVo(ticket.getCapacity(), ticket.getPrice() , ticket.getUser().getId(), ticket.getTrain().getId(),ticket.getBookingDate(),
					ticket.getJourneyDate(),ticket.getDepartureTime(), ticket.getArrivalTime(), ticket.getDepartureStation().getId(), ticket.getArrivalStation().getId(),
		    		ticket.getIsCancelled(), ticket.getCancellationDate());
			responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
			responseMap.put(Constants.MESSAGE, "ticket record found");
			responseMap.put("ticket record: ", ticketVo);
		}else {
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no ticket record found");
		}
		return responseMap;
	}

	@Override
	public Map<String, Object> updateTicket(TicketVo ticketVo) {
		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
		if (ticketVo == null){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Input required");
			return responseMap;
		}
		
		Integer id = ticketVo.getId();
		if (id == null || id <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "id can not be empty ,zero or less than zero");
			return responseMap;
		}
		Optional<Ticket> ticketOptional = ticketDao.findById(id);
		if(!ticketOptional.isPresent()){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no ticket record found");
			return responseMap;
		}
		LocalTime arrivalTime;
		LocalTime departTime;
		Ticket ticket = ticketOptional.get();
		
		if(ticketVo.getArrivalTime() != null)
		{
			if(ticketVo.getDepartureTime() != null)
			{
					arrivalTime = ticketVo.getArrivalTime();
					departTime = ticketVo.getDepartureTime();
			}
			else {
					arrivalTime = ticketVo.getArrivalTime();
					departTime = ticket.getDepartureTime();
			}	
		}
		else {
			if(ticketVo.getDepartureTime() != null)
			{
				arrivalTime = ticket.getArrivalTime();
				departTime = ticketVo.getDepartureTime();
			}
			else {
				arrivalTime = ticket.getArrivalTime();
				departTime = ticket.getDepartureTime();
			}
		}
	
		if(arrivalTime.isAfter(departTime))
		{
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "arrival time can not be after departure time");
			return responseMap;	
		}
		else {
			ticket.setArrivalTime(arrivalTime);
			ticket.setDepartureTime(departTime);
		}
		
		Integer departureStationId = ticketVo.getDepartureStationId();
		if(departureStationId != null) {
		if (departureStationId <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Departure id can not be zero or less than zero");
			return responseMap;
		}
		Optional<Station> departureStationOptional = stationDao.findById(departureStationId);
			if(!departureStationOptional.isPresent()) {
				responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
				responseMap.put(Constants.MESSAGE, "no Departure station record found");
				return responseMap;
			}
		ticket.setDepartureStation(departureStationOptional.get());
		}
		else {
		ticket.setDepartureStation(ticket.getDepartureStation());
		}
		Integer arrivalStationId = ticketVo.getArrivalStationId();
		if(arrivalStationId!= null)
		{
		if (arrivalStationId <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Arrival Station id zero or less than zero");
			return responseMap;
			}
		Optional<Station> arrivalstationOptional = stationDao.findById(arrivalStationId);
		if(!arrivalstationOptional.isPresent()) {
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no Arrival station record found");
			return responseMap;
			}
		ticket.setArrivalStation(arrivalstationOptional.get());
		}
		else {
		ticket.setArrivalStation(ticket.getArrivalStation());
		}
		LocalDateTime journeyDate=ticketVo.getJourneyDate();
		if(journeyDate == null)
		{
			journeyDate = ticket.getJourneyDate();
		}
	
		LocalDateTime bookingDate=ticketVo.getBookingDate();
		if(bookingDate == null)
		{
			bookingDate = ticket.getBookingDate();
		}
		
		LocalDateTime cancellationDate=ticketVo.getCancellationDate();
		if(cancellationDate == null) {
			cancellationDate=ticket.getCancellationDate();
		}
		
		if(cancellationDate != null) {
		if(cancellationDate.isBefore(bookingDate))
		{
	    	responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "cancellationDate should be after bookingDate");
			return responseMap;
		}
		}
		ticket.setIsCancelled(ticketVo.getIsCancelled() ==null ? ticket.getIsCancelled():ticketVo.getIsCancelled());
		
		Ticket savedTicket = ticketDao.save(ticket);

		if (savedTicket != null) {
			responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
			responseMap.put(Constants.MESSAGE, "ticket record created successfully");
			responseMap.put("id",savedTicket.getId());
		}
		else {
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Something went wrong, ticket cannot be updated");
		}
		return responseMap;
	}

	@Override
	public Map<String, Object> deleteTicket(Integer id) {
		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();

		if (id == null || id <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "id can not be empty ,zero or less than zero");
			return responseMap;
		}

		Optional<Ticket> ticketOptional = ticketDao.findById(id);
		if(!ticketOptional.isPresent()){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no ticket record found");
			return responseMap;
		}

		Ticket ticket = ticketOptional.get();
		ticketDao.delete(ticket);
		
		responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
		responseMap.put(Constants.MESSAGE, "ticket record deleted successfully");
		return responseMap;
	}

	@Override
	public List<TicketVo> listTicket() {
		Iterable<Ticket> ticketList = ticketDao.findAll();
		
		List<TicketVo> ticketVoList = new ArrayList<>();
		
		ticketList.forEach(ticket -> {
			TicketVo ticketVo = new TicketVo(
					ticket.getId(), 
					ticket.getCapacity(),
					ticket.getPrice(),
					ticket.getUser().getId(),
					ticket.getTrain().getId(),
					ticket.getBookingDate(),
					ticket.getJourneyDate(),
					ticket.getDepartureTime(),
					ticket.getArrivalTime(),
					ticket.getDepartureStation().getId(),
					ticket.getArrivalStation().getId(),
					ticket.getIsCancelled(),
					ticket.getCancellationDate());
			ticketVoList.add(ticketVo);
		});
		
		return ticketVoList;
	}
	
	

}
