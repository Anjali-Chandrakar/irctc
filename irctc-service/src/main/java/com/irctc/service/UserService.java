package com.irctc.service;

import java.util.List;
import java.util.Map;

import com.irctc.vo.UserVo;

public interface UserService  {

	Map<String, Object> createUser(UserVo userVo);
	Map<String, Object> readUser(Integer id);
	Map<String, Object> updateUser(UserVo userVo);
	Map<String, Object> deleteUser(Integer id);
	List<UserVo> listUser();
	
}
