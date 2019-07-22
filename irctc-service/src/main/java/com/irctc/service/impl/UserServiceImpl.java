package com.irctc.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.irctc.dao.UserDao;
import com.irctc.model.User;
import com.irctc.service.UserService;
import com.irctc.utils.Constants;
import com.irctc.vo.UserVo;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public Map<String, Object> createUser(UserVo userVo) {

		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();

		if (userVo == null){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Input required");
			return responseMap;
		}

		String name = userVo.getName();
		if (name == null || name.trim().isEmpty()){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "name can not be empty");
			return responseMap;
		}

		Integer age = userVo.getAge();
		if (age == null || age <=0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "age can not be empty ,zero or less than zero");
			return responseMap;
		}

		String email = userVo.getEmail();
		if (email == null || email.trim().isEmpty()){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "email not be empty");
			return responseMap;
		}
		
		Boolean isAdmin =userVo.getIsAdmin();

		User user = new User(email, name, age, isAdmin);
		User savedUser = userDao.save(user);

		if (savedUser != null) {
			responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
			responseMap.put(Constants.MESSAGE, "user record created successfully");
			responseMap.put("id",savedUser.getId());
		}
		else {
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Something went wrong, user cannot be create");
		}
		return responseMap;
	}

	@Override
	public Map<String, Object>  readUser(Integer id) {

		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();

		if (id == null || id <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "id can not be empty ,zero or less than zero");
			return responseMap;
		}

		Optional<User> userOptional = userDao.findById(id);

		if(userOptional.isPresent()){
			User user = userOptional.get();
			UserVo userVo = new UserVo(user.getId(), 
					user.getEmail(),
					user.getName(), 
					user.getAge(),
					user.getIsAdmin());
			responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
			responseMap.put(Constants.MESSAGE, "user record found");
			responseMap.put("user record: ", userVo);
		}else {
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no user record found");
		}
		return responseMap;
	}

	@Override
	public Map<String, Object> updateUser(UserVo userVo) {
		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();

		if (userVo == null){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Input required");
			return responseMap;
		}

		Integer id = userVo.getId();
		if (id == null || id <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "id can not be empty ,zero or less than zero");
			return responseMap;
		}

		Optional<User> userOptional = userDao.findById(id);
		if(!userOptional.isPresent()){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no user record found");
			return responseMap;
		}

		User user = userOptional.get();

		user.setName(userVo.getName() != null ? userVo.getName() : user.getName());
		user.setAge(userVo.getAge() != null ? userVo.getAge() : user.getAge());
		user.setEmail(userVo.getEmail() != null ? userVo.getEmail() : user.getEmail());

		User savedUser = userDao.save(user);
		if (savedUser != null) {
			responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
			responseMap.put(Constants.MESSAGE, "user record updated successfully");
			responseMap.put("updated records: ",savedUser);
		}
		else {
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "Something went wrong, user cannot be create");
		}
		return responseMap;
	}

	@Override
	public Map<String, Object> deleteUser(Integer id) {

		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();

		if (id == null || id <= 0){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "id can not be empty ,zero or less than zero");
			return responseMap;
		}

		Optional<User> userOptional = userDao.findById(id);
		if(!userOptional.isPresent()){
			responseMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE, "no user record found");
			return responseMap;
		}

		User user = userOptional.get();
		userDao.delete(user);
		
		responseMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
		responseMap.put(Constants.MESSAGE, "user record deleted successfully");
		return responseMap;
	}

	@Override
	public List<UserVo> listUser() {

		Iterable<User> userList = userDao.findAll();
		
		List<UserVo> userVoList = new ArrayList<>();
		
		userList.forEach(user -> {
			UserVo userVo = new UserVo(
					user.getId(), 
					user.getEmail(),
					user.getName(),
					user.getAge(),
					user.getIsAdmin());
			userVoList.add(userVo);
		});
		
		return userVoList;
	}
}
