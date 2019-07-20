package com.irctc.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4571972748358164033L;
	private BigInteger id;
	private String email;
	private String name;
	private int age;
	//private Gender g;

	public User() {
		super();
	}
	
	

	public User(BigInteger id, String email, String name, int age) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.age = age;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public BigInteger getUserId() {
		return id;
	}

	public void setUserId(BigInteger id) {
		this.id = id;
	}

	@Column(name="email", nullable = false, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="age", nullable = false)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + id + ", email=" + email + ", name=" + name + ", age=" + age + "]";
	}
}
