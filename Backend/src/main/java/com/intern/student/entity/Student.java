package com.intern.student.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name = "student")
@Data
public class Student {

	@Id
	private String id;

	private String name;

	private String dob;

	@JsonIgnore
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private Collection<ClassDetail> classDetail;

}
