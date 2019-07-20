package com.irctc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="EMAIL", nullable = false, unique = true)
	private String email;
	@Column(name="NAME", nullable = false)
	private String name;
	@Column(name="AGE", nullable = false)
	private int age;
	//private Gender g;

	public User() {
		super();
	}
	
	

	public User(long userId, String email, String name, int age) {
		super();
		this.userId = userId;
		this.email = email;
		this.name = name;
		this.age = age;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", name=" + name + ", age=" + age + "]";
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
