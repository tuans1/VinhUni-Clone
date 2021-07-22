package com.intern.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name = "student_course")
@Data
public class StudentCourse {
	@Id
	private String id;

	@Column(name = "student_id")
	private String studentId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "student_id", insertable = false, updatable = false)
	private Student student;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "course_id", insertable = false, updatable = false)
	private Course course;

}
