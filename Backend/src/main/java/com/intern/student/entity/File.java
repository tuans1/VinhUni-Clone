package com.intern.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class File {

	@Id
	private String id;
	@Column(name="name")
	private String name;
	@JsonIgnore
	@ManyToOne 
    @JoinColumn(name = "course_id") // thông qua khóa ngoại address_id
	private Course course;
}
