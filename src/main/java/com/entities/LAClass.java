package com.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class LAClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    
    public LAClass() {
    	
    }
    
	public LAClass(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    

//    @ManyToMany
//    @JoinTable(
//        name = "class_subject",
//        joinColumns = @JoinColumn(name = "class_id"),
//        inverseJoinColumns = @JoinColumn(name = "subject_id")
//    )
//    private List<Subject> subjects;
//
//    @ManyToMany
//    @JoinTable(
//        name = "class_teacher",
//        joinColumns = @JoinColumn(name = "class_id"),
//        inverseJoinColumns = @JoinColumn(name = "teacher_id")
//    )
//    private List<Teacher> teachers;
//
//    @OneToMany(mappedBy = "clazz")
//    private List<Student> students;

    // Constructors, getters, setters
}

