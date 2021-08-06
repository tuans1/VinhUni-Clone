package com.intern.student.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Homework {

	@Id
	private String id;

	@Column
	private String name;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "class_id", nullable = false)
	private Classes classes;

	@JsonIgnore
	@OneToMany(mappedBy = "homework")
	private Collection<StudentHomework> studentHomework;

	private String deadLine;

	private String required;
}
