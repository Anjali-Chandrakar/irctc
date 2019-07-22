package com.irctc.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.service.PassengerService;
import com.irctc.utils.Constants;
import com.irctc.vo.PassengerVo;

@RestController
@RequestMapping(value = Constants.IRCTC_PASSENGER)
public class PassengerController {

	@Autowired
	private PassengerService passengerService;

	@PostMapping(value = Constants.OPERATION_CREATE)
	public Map<String, Object> create(@RequestBody PassengerVo passengerVo, Locale locale , Model model) {

		Map<String, Object> responseMap = passengerService.createPassenger(passengerVo);
		return responseMap;
	}
	
	@GetMapping(value = Constants.OPERATION_READ)
	public Map<String, Object> read(@RequestBody  Map<String, Object> requestMap) {

		Integer id = new Integer(requestMap.get("id").toString());
		
		Map<String, Object> responseMap = passengerService.readPassenger(id);
		return responseMap;
	}
	
	@PutMapping(value = Constants.OPERATION_UPDATE)
	public Map<String, Object> update(@RequestBody PassengerVo passengerVo, Locale locale , Model model) {

		Map<String, Object> responseMap = passengerService.updatePassenger(passengerVo);
		return responseMap;
	}
	
	@DeleteMapping(value = Constants.OPERATION_DELETE)
	public Map<String, Object> delete(@RequestBody  Map<String, Object> requestMap, Locale locale , Model model) {

		Integer id = new Integer(requestMap.get("id").toString());

		Map<String, Object> responseMap = passengerService.deletePassenger(id);
		return responseMap;
	}
	
	@GetMapping(value = Constants.OPERATION_LIST)
	public List<PassengerVo> listPassenger() {

		List<PassengerVo> passengerList = passengerService.listPassenger();
		return passengerList;
	}

}
