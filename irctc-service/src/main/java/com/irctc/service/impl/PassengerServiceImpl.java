package com.irctc.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.irctc.dao.PassengerDao;
import com.irctc.model.Passenger;
import com.irctc.service.PassengerService;
import com.irctc.utils.Constants;
import com.irctc.vo.PassengerVo;

@Component
public class PassengerServiceImpl implements PassengerService{
	@Autowired
	private PassengerDao passengerDao;

	@Override
	public Map<String, Object> createPassenger(PassengerVo passengerVo) {

		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();

		if (passengerVo == null){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Input required");
			return responseMap;
		}

		String name = passengerVo.getName();
		if (name == null || name.trim().isEmpty()){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "name can not be empty");
			return responseMap;
		}
		
		Integer age = passengerVo.getAge();
		if (age == null || age <=0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "age can not be empty ,zero or less than zero");
			return responseMap;
		}

		String gender = passengerVo.getGender();
		if (gender == null){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "gender should not be empty");
			return responseMap;
		}
		
		Passenger passenger = new Passenger(name, gender, age);
		Passenger savedPassenger = passengerDao.save(passenger);

		if (savedPassenger != null) {
			responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
			responseMap.put(Constants.MESSAGE, "passenger record created successfully");
			responseMap.put("id",savedPassenger.getId());
		}
		else {
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Something went wrong, passenger cannot be create");
		}
		return responseMap;
}

	@Override
	public Map<String, Object> readPassenger(Integer id) {
		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();

		if (id == null || id <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "id can not be empty ,zero or less than zero");
			return responseMap;
		}

		Optional<Passenger> passengerOptional = passengerDao.findById(id);

		if(passengerOptional.isPresent()){
			Passenger passenger = passengerOptional.get();
			PassengerVo passengerVo = new PassengerVo(passenger.getId(), 
					passenger.getName(),
					passenger.getGender(),
					passenger.getAge());
			responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
			responseMap.put(Constants.MESSAGE, "passenger record found");
			responseMap.put("passenger record: ", passengerVo);
		}else {
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no passenger record found");
		}
		return responseMap;
	}

	@Override
	public Map<String, Object> updatePassenger(PassengerVo passengerVo) {
		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();

		if (passengerVo == null){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Input required");
			return responseMap;
		}

		Integer id = passengerVo.getId();
		if (id == null || id <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "id can not be empty ,zero or less than zero");
			return responseMap;
		}

		Optional<Passenger> passengerOptional = passengerDao.findById(id);
		if(!passengerOptional.isPresent()){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no passenger record found");
			return responseMap;
		}

		Passenger passenger = passengerOptional.get();

		passenger.setName(passengerVo.getName() != null ? passengerVo.getName() : passenger.getName());
		passenger.setAge(passengerVo.getAge() != null ? passengerVo.getAge() : passenger.getAge());
		passenger.setGender(passengerVo.getGender() != null ? passengerVo.getGender() : passenger.getGender());

		Passenger savedPassenger = passengerDao.save(passenger);
		if (savedPassenger != null) {
			responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
			responseMap.put(Constants.MESSAGE, "passenger record updated successfully");
			responseMap.put("updated records: ",savedPassenger);
		}
		else {
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Something went wrong, passenger cannot be create");
		}
		return responseMap;
	}

	@Override
	public Map<String, Object> deletePassenger(Integer id) {
		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();

		if (id == null || id <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "id can not be empty ,zero or less than zero");
			return responseMap;
		}

		Optional<Passenger> passengerOptional = passengerDao.findById(id);
		if(!passengerOptional.isPresent()){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no passenger record found");
			return responseMap;
		}

		Passenger passenger = passengerOptional.get();
		passengerDao.delete(passenger);
		
		responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
		responseMap.put(Constants.MESSAGE, "passenger record deleted successfully");
		return responseMap;
	}

	@Override
	public List<PassengerVo> listPassenger() {

		Iterable<Passenger> passengerList = passengerDao.findAll();
		
		List<PassengerVo> passengerVoList = new ArrayList<>();
		
		passengerList.forEach(passenger -> {
			PassengerVo passengerVo = new PassengerVo(
					passenger.getId(),
					passenger.getName(),
					passenger.getGender(),
					passenger.getAge());
			passengerVoList.add(passengerVo);
		});
		
		return passengerVoList;
	}
}
