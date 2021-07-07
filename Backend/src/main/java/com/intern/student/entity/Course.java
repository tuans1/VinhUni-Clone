package com.intern.student.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity(name = "course")

public class Course {

	
	@Id
	private String id;
	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "courses")
	private Collection<Student> students;
	@JsonIgnore
	@ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
	private Collection<Lecturer> lecturer;
	

	


}
