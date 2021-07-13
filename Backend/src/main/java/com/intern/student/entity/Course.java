package com.intern.student.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(mappedBy = "courses")
	private Collection<Student> students;
	
	@ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
	private Collection<Lecturer> lecturer;
	
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL,fetch = FetchType.LAZY) // Quan hệ 1-n với đối tượng ở dưới (file)
    // MapopedBy trỏ tới tên biến Address ở trong Person.
    private Collection<File> files;
	


}
