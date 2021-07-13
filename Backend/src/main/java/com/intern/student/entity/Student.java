package com.intern.student.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;


@Entity(name="student")
@Data
public class Student {

	@Id
	@Column(name="id")
	private String id;
	@Column(name = "name")
	private String name;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "student_course", 
	joinColumns = @JoinColumn(name = "student_id"), 
	inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Collection<Course> courses;	


}
