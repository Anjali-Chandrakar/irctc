package com.irctc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {
	
	private static final long serialVersionUID = -3469247738879425434L;
	@Id
	private int studentId;
	private String studentName;
	
	public Student() {
		super();
		System.out.println("\"Student Object Ctreated\"");
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void show() {
		System.out.println("In Student.show()");
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}
	
}

