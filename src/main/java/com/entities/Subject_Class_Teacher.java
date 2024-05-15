package com.entities;

import jakarta.persistence.*;

@Entity
public class Subject_Class_Teacher {

	private int subjectID;
	private int classID;
	private int TeacherID;
	
	public Subject_Class_Teacher() {
		
	}

	public Subject_Class_Teacher(int subjectID, int classID, int teacherID) {
		super();
		this.subjectID = subjectID;
		this.classID = classID;
		TeacherID = teacherID;
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

	public int getTeacherID() {
		return TeacherID;
	}

	public void setTeacherID(int teacherID) {
		TeacherID = teacherID;
	}
	
	
	
	
}
