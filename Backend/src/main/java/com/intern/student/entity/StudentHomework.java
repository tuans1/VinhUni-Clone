package com.intern.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name = "student_homework")
@Data
public class StudentHomework {
	@Id
	private String id;

	@Column(name = "student_id")
	private String studentId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "student_id", insertable = false, updatable = false)
	private Student student;

	@Column(name = "homework_id")
	private String homeworkId;
	
	
	@ManyToOne
	@JoinColumn(name = "homework_id", insertable = false, updatable = false)
	private Homework homework;

	private String path;
	
	private String createDate;
}
