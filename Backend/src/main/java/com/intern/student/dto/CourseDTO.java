package com.intern.student.dto;

import java.util.Collection;

import lombok.Data;

@Data
public class CourseDTO {

	private String id;
	
	private String courseName;
	
	private Collection<LecturerDTO> teacherDto;		

	
}
