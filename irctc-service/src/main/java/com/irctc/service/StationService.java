package com.irctc.service;

import java.util.List;
import java.util.Map;

import com.irctc.vo.StationVo;

public interface StationService {
	Map<String, Object> createStation(StationVo stationVo);
	Map<String, Object> readStation(Integer id);
	Map<String, Object> updateStation(StationVo stationVo);
	Map<String, Object> deleteStation(Integer id);
	List<StationVo> listStation();
}
