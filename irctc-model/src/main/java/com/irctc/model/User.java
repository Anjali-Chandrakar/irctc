package com.irctc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2187713984476743735L;
	private Integer id;
	private String email;
	private String name;
	private int age;
	private Boolean isAdmin;

	public User() {
		super();
	}
	
	public User(String email, String name, int age, Boolean isAdmin) {
		super();
		this.email = email;
		this.name = name;
		this.age = age;
		this.isAdmin = isAdmin;
	}
	
	public User(Integer id, String email, String name, int age, Boolean isAdmin) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.age = age;
		this.isAdmin = isAdmin;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	
	@Column(name="is_admin", nullable = false)
	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", age=" + age + ", isAdmin=" + isAdmin + "]";
	}

	
}
