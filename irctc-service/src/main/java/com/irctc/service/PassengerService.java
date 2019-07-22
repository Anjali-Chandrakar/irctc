package com.irctc.service;

import java.util.List;
import java.util.Map;

import com.irctc.vo.PassengerVo;

public interface PassengerService {
	Map<String, Object> createPassenger(PassengerVo passengerVo);
	Map<String, Object> readPassenger(Integer id);
	Map<String, Object> updatePassenger(PassengerVo passengerVo);
	Map<String, Object> deletePassenger(Integer id);
	List<PassengerVo> listPassenger();
}
