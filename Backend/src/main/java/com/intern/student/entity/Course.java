package com.intern.student.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity(name = "course")

public class Course {

	@Id
	private String id;
	@Column(name = "name")
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private Collection<Classes> classes;

	@ManyToMany
	@JoinTable(name = "lecturer_course", joinColumns = @JoinColumn(name = "lecturer_id"),

			inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Collection<Lecturer> lecturers;
	
//	@JsonIgnore
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private Collection<File> file;
}
