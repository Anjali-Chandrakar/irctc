package com.irctc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.irctc.dao.StudentDao;
import com.irctc.model.Student;

@Controller
public class StudentController {
	
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addStudent")
	public String addStudent(Student student) {
		System.out.println(student);
		studentDao.save(student);
		System.out.println(student);
		return "home.jsp";
	}

}