package com.irctc.service;

import java.util.List;
import java.util.Map;

import com.irctc.vo.ScheduleVo;

public interface ScheduleService {
	Map<String, Object> createSchedule(ScheduleVo scheduleVo);
	Map<String, Object> readSchedule(Integer id);
	Map<String, Object> updateSchedule(ScheduleVo scheduleVo);
	Map<String, Object> deleteSchedule(Integer id);
	List<ScheduleVo> listSchedule();

}
