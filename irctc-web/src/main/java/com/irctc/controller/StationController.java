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

import com.irctc.service.StationService;
import com.irctc.utils.Constants;
import com.irctc.vo.StationVo;

@RestController
@RequestMapping(value = Constants.IRCTC_STATION)
public class StationController {

	@Autowired
	private StationService stationService;

	@PostMapping(value = Constants.OPERATION_CREATE)
	public Map<String, Object> create(@RequestBody StationVo stationVo, Locale locale , Model model) {

		Map<String, Object> responseMap = stationService.createStation(stationVo);
		return responseMap;
	}
	
	@GetMapping(value = Constants.OPERATION_READ)
	public Map<String, Object> read(@RequestBody  Map<String, Object> requestMap) {

		Integer id = new Integer(requestMap.get("id").toString());
		
		Map<String, Object> responseMap = stationService.readStation(id);
		return responseMap;
	}
	
	@PutMapping(value = Constants.OPERATION_UPDATE)
	public Map<String, Object> update(@RequestBody StationVo stationVo, Locale locale , Model model) {

		Map<String, Object> responseMap = stationService.updateStation(stationVo);
		return responseMap;
	}
	
	@DeleteMapping(value = Constants.OPERATION_DELETE)
	public Map<String, Object> delete(@RequestBody  Map<String, Object> requestMap, Locale locale , Model model) {

		Integer id = new Integer(requestMap.get("id").toString());

		Map<String, Object> responseMap = stationService.deleteStation(id);
		return responseMap;
	}
	
	@GetMapping(value = Constants.OPERATION_LIST)
	public List<StationVo> listStation() {

		List<StationVo> stationList = stationService.listStation();
		return stationList;
	}

}
