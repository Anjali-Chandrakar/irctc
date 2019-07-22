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

import com.irctc.service.ScheduleService;
import com.irctc.utils.Constants;
import com.irctc.vo.ScheduleVo;

@RestController
@RequestMapping(value = Constants.IRCTC_SCHEDULE)
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;

	@PostMapping(value = Constants.OPERATION_CREATE)
	public Map<String, Object> create(@RequestBody ScheduleVo scheduleVo, Locale locale , Model model) {

		Map<String, Object> responseMap = scheduleService.createSchedule(scheduleVo);
		return responseMap;
	}
	
	@GetMapping(value = Constants.OPERATION_READ)
	public Map<String, Object> read(@RequestBody  Map<String, Object> requestMap) {

		Integer id = new Integer(requestMap.get("id").toString());
		
		Map<String, Object> responseMap = scheduleService.readSchedule(id);
		return responseMap;
	}
	
	@PutMapping(value = Constants.OPERATION_UPDATE)
	public Map<String, Object> update(@RequestBody ScheduleVo scheduleVo, Locale locale , Model model) {

		Map<String, Object> responseMap = scheduleService.updateSchedule(scheduleVo);
		return responseMap;
	}
	
	@DeleteMapping(value = Constants.OPERATION_DELETE)
	public Map<String, Object> delete(@RequestBody  Map<String, Object> requestMap, Locale locale , Model model) {

		Integer id = new Integer(requestMap.get("id").toString());

		Map<String, Object> responseMap = scheduleService.deleteSchedule(id);
		return responseMap;
	}
	
	@GetMapping(value = Constants.OPERATION_LIST)
	public List<ScheduleVo> listSchedule() {

		List<ScheduleVo> scheduleList = scheduleService.listSchedule();
		return scheduleList;
	}
}
