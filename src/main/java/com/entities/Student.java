package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullName;
	private String gender;
	private int age;
	private int classID;

//	@ManyToOne
//	@JoinColumn(name = "class_id")
//	private Class classObj;
	
	public Student() {
		
	}
	
	public Student(String fullName, String gender, int age, int classID) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.age = age;
		this.classID = classID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

//	public Class getClassObj() {
//		return classObj;
//	}
//
//	public void setClassObj(Class classObj) {
//		this.classObj = classObj;
//	}

}
