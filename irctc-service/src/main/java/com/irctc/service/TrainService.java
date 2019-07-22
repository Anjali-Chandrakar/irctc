package com.irctc.service;

import java.util.List;
import java.util.Map;

import com.irctc.vo.TrainVo;


public interface TrainService {

	Map<String, Object> createTrain(TrainVo trainVo);
	Map<String, Object> readTrain(Integer id);
	Map<String, Object> updateTrain(TrainVo trainVo);
	Map<String, Object> deleteTrain(Integer id);
	List<TrainVo> listTrain();
}
