package com.intern.student.dto;

import java.util.List;

import lombok.Data;

@Data
public class StudentDTO {
	
	private String id;

	private String name;
	
	private String dob;
	
//
	private ClassesDTO classes;

	private List<ClassDetailDTO> courses;
	
	

}
