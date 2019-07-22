package com.irctc.service.impl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.irctc.dao.ScheduleDao;
import com.irctc.dao.StationDao;
import com.irctc.dao.TrainDao;
import com.irctc.model.Schedule;
import com.irctc.model.Station;
import com.irctc.model.Train;
import com.irctc.service.ScheduleService;
import com.irctc.utils.Constants;
import com.irctc.vo.ScheduleVo;

public class ScheduleServiceImpl implements ScheduleService{
	@Autowired
	private ScheduleDao scheduleDao;
	
	@Autowired 
	private StationDao stationDao;
	
	@Autowired
	private TrainDao trainDao;

	@Override
	public Map<String, Object> createSchedule(ScheduleVo scheduleVo) {
		
		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
		
		if (scheduleVo == null){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Input required");
			return responseMap;
		}
		
		Integer stopId = scheduleVo.getStopId();
		if (stopId== null || stopId <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "stop id can not be empty ,zero or less than zero");
			return responseMap;
		}
		else {
			Optional<Station> stationOptional = stationDao.findById(stopId);
			if(!stationOptional.isPresent()) {
				responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
				responseMap.put(Constants.MESSAGE, "no station record found");
				return responseMap;
			}
		}
			
		Integer trainId = scheduleVo.getTrainId();
	    if (trainId== null || trainId <= 0){
				responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
				responseMap.put(Constants.MESSAGE, "train id can not be empty ,zero or less than zero");
				return responseMap;
		}
		else {
				Optional<Train> trainOptional = trainDao.findById(trainId);
				if(!trainOptional.isPresent()) {
					responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
					responseMap.put(Constants.MESSAGE, "no train record found");
					return responseMap;
			}
			
		}
	    
	    LocalTime arrivalTime = scheduleVo.getArrivalTime();
	    LocalTime departTime = scheduleVo.getDepartTime();
		
	    if(arrivalTime.isAfter(departTime))
	    {
	    	responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "arrival time can not be after departure time");
			return responseMap;
	    } 
	    
	    if(scheduleVo.getIsmonday()== null || scheduleVo.getIstuesday()== null || scheduleVo.getIswednesday() == null || scheduleVo.getIsthursday()== null || scheduleVo.getIsfriday()== null || scheduleVo.getIssaturday() == null ||
	    		scheduleVo.getIssunday()== null) {
	    	responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "For which Day train is running or not running should be entered");
			return responseMap;
	    }
	    /*Check here*/
	    Schedule schedule = new Schedule(stationDao.findById(stopId).get(), departTime, arrivalTime, trainDao.findById(trainId).get(),scheduleVo.getIsmonday(),
	    		scheduleVo.getIstuesday(),scheduleVo.getIswednesday(), scheduleVo.getIsthursday(), scheduleVo.getIsfriday(), scheduleVo.getIssaturday(),
	    		scheduleVo.getIssunday());
		Schedule savedSchedule = scheduleDao.save(schedule);

		if (savedSchedule != null) {
			responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
			responseMap.put(Constants.MESSAGE, "schedule record created successfully");
			responseMap.put("id",savedSchedule.getId());
		}
		else {
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Something went wrong, schedule cannot be created");
		}
	    return responseMap;
	}


	@Override
	public Map<String, Object> readSchedule(Integer id) {
		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();

		if (id == null || id <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "id can not be empty ,zero or less than zero");
			return responseMap;
		}

		Optional<Schedule> scheduleOptional = scheduleDao.findById(id);

		if(scheduleOptional.isPresent()){
			Schedule schedule = scheduleOptional.get();
			ScheduleVo scheduleVo = new ScheduleVo(schedule.getStop().getId(), schedule.getDepartTime() , schedule.getArrivalTime(), schedule.getTrain().getId(),schedule.getIsmonday(),
					schedule.getIstuesday(),schedule.getIswednesday(), schedule.getIsthursday(), schedule.getIsfriday(), schedule.getIssaturday(),
		    		schedule.getIssunday());
			responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
			responseMap.put(Constants.MESSAGE, "schedule record found");
			responseMap.put("schedule record: ", scheduleVo);
		}else {
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no schedule record found");
		}
		return responseMap;
	}

	@Override
	public Map<String, Object> updateSchedule(ScheduleVo scheduleVo) {
		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
		if (scheduleVo == null){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Input required");
			return responseMap;
		}
		
		Integer id = scheduleVo.getId();
		if (id == null || id <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "id can not be empty ,zero or less than zero");
			return responseMap;
		}
		

		Optional<Schedule> scheduleOptional = scheduleDao.findById(id);
		if(!scheduleOptional.isPresent()){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no schedule record found");
			return responseMap;
		}
		LocalTime arrivalTime;
		LocalTime departTime;
		Schedule schedule = scheduleOptional.get();
		
		if(scheduleVo.getArrivalTime() != null)
		{
			if(scheduleVo.getDepartTime() != null)
			{
					arrivalTime = scheduleVo.getArrivalTime();
					departTime = scheduleVo.getDepartTime();
			}
			else {
					arrivalTime = scheduleVo.getArrivalTime();
					departTime = schedule.getDepartTime();
			}	
		}
		else {
			if(scheduleVo.getDepartTime() != null)
			{
				arrivalTime = schedule.getArrivalTime();
				departTime = scheduleVo.getDepartTime();
			}
			else {
				arrivalTime = schedule.getArrivalTime();
				departTime = schedule.getDepartTime();
			}
		}
		
		if(arrivalTime.isAfter(departTime))
		{
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "arrival time can not be after departure time");
			return responseMap;	
		}
		else {
			schedule.setArrivalTime(arrivalTime);
			schedule.setDepartTime(departTime);
		}

		if(scheduleVo.getStopId() != null) {
			if(scheduleVo.getStopId()>0) {
			Optional<Station> stationOptional = stationDao.findById(scheduleVo.getStopId());
				if(!stationOptional.isPresent()) {
					responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
					responseMap.put(Constants.MESSAGE, "no station record found");
					return responseMap;
				}
				else {
					schedule.setStop(stationOptional.get());
				}
			}
			else {
				responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
				responseMap.put(Constants.MESSAGE, "stop id can not be zero or less than zero");
				return responseMap;
			}
		}
		else {
			schedule.setStop(schedule.getStop());
		}
		

		if(scheduleVo.getTrainId() != null) {
			if(scheduleVo.getTrainId()>0) {
			Optional<Train> TrainOptional = trainDao.findById(scheduleVo.getTrainId());
				if(!TrainOptional.isPresent()) {
					responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
					responseMap.put(Constants.MESSAGE, "no train record found");
					return responseMap;
				}
				else {
					schedule.setTrain(TrainOptional.get());
				}
			}
			else {
				responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
				responseMap.put(Constants.MESSAGE, "train id can not be zero or less than zero");
				return responseMap;
			}
		}
		else {
			schedule.setTrain(schedule.getTrain());
		}
		schedule.setIsmonday(scheduleVo.getIsmonday()!=null ? scheduleVo.getIsmonday() : schedule.getIsmonday());
		schedule.setIstuesday(scheduleVo.getIstuesday()!=null ? scheduleVo.getIstuesday() : schedule.getIstuesday());
		schedule.setIswednesday(scheduleVo.getIswednesday()!=null ? scheduleVo.getIswednesday() : schedule.getIswednesday());
		schedule.setIsthursday(scheduleVo.getIsthursday()!=null ? scheduleVo.getIsthursday() : schedule.getIsthursday());
		schedule.setIsfriday(scheduleVo.getIsfriday()!=null ? scheduleVo.getIsfriday() : schedule.getIsfriday());
		schedule.setIssaturday(scheduleVo.getIssaturday()!=null ? scheduleVo.getIssaturday() : schedule.getIssaturday());
		schedule.setIssunday(scheduleVo.getIssunday()!=null ? scheduleVo.getIssunday() : schedule.getIssunday());
	
		Schedule savedSchedule = scheduleDao.save(schedule);

		if (savedSchedule != null) {
			responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
			responseMap.put(Constants.MESSAGE, "schedule record created successfully");
			responseMap.put("id",savedSchedule.getId());
		}
		else {
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Something went wrong, schedule cannot be updated");
		}
		return responseMap;
	}

	@Override
	public Map<String, Object> deleteSchedule(Integer id) {
		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();

		if (id == null || id <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "id can not be empty ,zero or less than zero");
			return responseMap;
		}

		Optional<Schedule> scheduleOptional = scheduleDao.findById(id);
		if(!scheduleOptional.isPresent()){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no schedule record found");
			return responseMap;
		}

		Schedule schedule = scheduleOptional.get();
		scheduleDao.delete(schedule);
		
		responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
		responseMap.put(Constants.MESSAGE, "schedule record deleted successfully");
		return responseMap;
	}

	@Override
	public List<ScheduleVo> listSchedule() {
Iterable<Schedule> scheduleList = scheduleDao.findAll();
		
		List<ScheduleVo> scheduleVoList = new ArrayList<>();
		
		scheduleList.forEach(schedule -> {
			ScheduleVo scheduleVo = new ScheduleVo(
					schedule.getId(), 
					schedule.getStop().getId(),
					schedule.getDepartTime(),
					schedule.getArrivalTime(),
					schedule.getTrain().getId(),
					schedule.getIsmonday(),
					schedule.getIstuesday(),
					schedule.getIswednesday(),
					schedule.getIsthursday(),
					schedule.getIsfriday(),
					schedule.getIssaturday(),
					schedule.getIssunday());
			scheduleVoList.add(scheduleVo);
		});
		
		return scheduleVoList;
	}

}
