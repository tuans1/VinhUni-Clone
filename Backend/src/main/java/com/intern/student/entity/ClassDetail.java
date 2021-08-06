package com.intern.student.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity(name="class_detail")
@Data
public class ClassDetail {
	@Id
	private String id;


	@ManyToOne
	@JoinColumn(name = "student_id", insertable=false, updatable=false)
	private Student student;
	
	
	@ManyToOne
	@JoinColumn(name = "class_id", insertable = false, updatable = false)
	private Classes classes;
	
	
	@OneToOne(mappedBy = "classDetail")
	private Attendance attendance;
}


