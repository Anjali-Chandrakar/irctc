package com.irctc.vo;

import java.io.Serializable;

public class UserVo implements Serializable{

	private static final long serialVersionUID = 8539820885339646418L;
	private Integer id;
	private String email;
	private String name;
	private Integer age;
	
	public UserVo() {
	}
	
	public UserVo(String email, String name, Integer age) {
		super();
		this.email = email;
		this.name = name;
		this.age = age;
	}

	public UserVo(Integer id, String email, String name, Integer age) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserVo [id=" + id + ", email=" + email + ", name=" + name + ", age=" + age + "]";
	}
	
}
