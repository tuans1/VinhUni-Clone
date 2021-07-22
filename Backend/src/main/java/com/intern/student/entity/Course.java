package com.intern.student.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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



	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private Collection<Classes> classes;


	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private Collection<File> file;
}
