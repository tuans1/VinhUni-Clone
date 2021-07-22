package com.intern.student.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.tomcat.jni.Address;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name="class_detail")
@Data
public class ClassDetail {
	@Id
	private String id;
	
	
	@ManyToOne
	@JoinColumn(name = "student_id", insertable=false, updatable=false)
	private Student student;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "class_id", insertable = false, updatable = false)
	private Classes classes;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "attendance_id", referencedColumnName = "id")
	private Attendance attendance;
}


