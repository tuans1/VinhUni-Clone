package com.intern.student.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Lecturer {

	@Id
	private String id;
	@Column(name="name")
	private String name;
	
	
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "lecturer_course", 
	joinColumns = @JoinColumn(name = "lecturer_id"), 
	inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Collection<Course> courses;	

	
	@OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL)
	private Collection<Classes> classes;
	
}
