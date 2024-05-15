package com.entities;

import jakarta.persistence.*;

@Entity
public class Subject_Class {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private int subjectID;
	private int classID;
	
	public Subject_Class() {
		
	}
	
	public Subject_Class(int subjectID, int classID) {
		super();
		this.subjectID = subjectID;
		this.classID = classID;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubjectID() {
		return subjectID;
	}



	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}



	public int getClassID() {
		return classID;
	}



	public void setClassID(int classID) {
		this.classID = classID;
	}



	
	
	
}
