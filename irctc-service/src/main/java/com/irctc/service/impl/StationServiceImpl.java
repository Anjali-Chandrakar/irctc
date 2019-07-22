package com.irctc.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.irctc.dao.StationDao;
import com.irctc.model.Station;
import com.irctc.service.StationService;
import com.irctc.utils.Constants;
import com.irctc.vo.StationVo;

public class StationServiceImpl implements StationService {

	@Autowired
	private StationDao stationDao;
	
	@Override
	public Map<String, Object> createStation(StationVo stationVo) {
Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
		
		if(stationDao == null){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Input required");
			return responseMap;
		}
		
		String name=stationVo.getStation_name();
		if (name == null || name.trim().isEmpty()){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "name can not be empty");
			return responseMap;
		}
		
		Station station=new Station(name);
		Station savedStation=stationDao.save(station);
		
		if (savedStation != null) {
			responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
			responseMap.put(Constants.MESSAGE, "Station record created successfully");
			responseMap.put("id",savedStation.getId());
		}
		else {
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Something went wrong, Station cannot be create");
		}
		return responseMap;
	}

	@Override
	public Map<String, Object> readStation(Integer id) {
		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
		if (id == null || id.intValue() <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "id can not be empty ,zero or less than zero");
			return responseMap;
		}

		Optional<Station> stationOptional = stationDao.findById(id);

		if(stationOptional.isPresent()){
			Station station = stationOptional.get();
			StationVo stationVo = new StationVo(station.getId(),
					station.getStation_name());
			responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
			responseMap.put(Constants.MESSAGE, "station record found");
			responseMap.put("station record: ", stationVo);
		}else {
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no station record found");
		}
		return responseMap;
	}

	@Override
	public Map<String, Object> updateStation(StationVo stationVo) {
		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
		if(stationVo == null){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Input required");
			return responseMap;
		}
		
		Integer id = stationVo.getId();
		if (id == null || id.intValue() <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "id can not be empty ,zero or less than zero");
			return responseMap;
		}
		

		Optional<Station> stationOptional = stationDao.findById(id);
		if(!stationOptional.isPresent()){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no station record found");
			return responseMap;
		}

		Station station = stationOptional.get();
		station.setStation_name((stationVo.getStation_name() != null ? stationVo.getStation_name() : station.getStation_name()));
		
		Station savedStation=stationDao.save(station);
		
		if (savedStation != null) {
			responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
			responseMap.put(Constants.MESSAGE, "station record updated successfully");
			responseMap.put("updated records: ",savedStation);
		}
		else {
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Something went wrong, station cannot be updated");
		}
		
		return responseMap;
	}

	@Override
	public Map<String, Object> deleteStation(Integer id) {
Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
		
		if (id == null || id <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "id can not be empty ,zero or less than zero");
			return responseMap;
		}
		Optional<Station> stationOptional = stationDao.findById(id);
		if(!stationOptional.isPresent()){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no station record found");
			return responseMap;
		}

		Station station= stationOptional.get();
		stationDao.delete(station);
		
		responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
		responseMap.put(Constants.MESSAGE, "station record deleted successfully");
		return responseMap;
	}

	@Override
	public List<StationVo> listStation() {

		Iterable<Station> stationList = stationDao.findAll();
		
		List<StationVo> stationVoList = new ArrayList<>();
		
		stationList.forEach(station -> {
			StationVo stationVo = new StationVo(
					station.getId(), 
					station.getStation_name());
			stationVoList.add(stationVo);
		});
		
		return stationVoList;
	}

}
