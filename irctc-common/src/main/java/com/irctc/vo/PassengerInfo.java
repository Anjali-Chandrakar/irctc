package com.irctc.vo;

import java.io.Serializable;
import java.math.BigInteger;

public class PassengerInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1277090913971191865L;
	private BigInteger id;
	private String name;
	private String gender;
	private int age;
	
	public PassengerInfo() {
		super();
	}
	
	public PassengerInfo(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public PassengerInfo(BigInteger id, String name, String gender, int age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PassengerInfo [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	
}
