package com.intern.student.dto;

import java.util.Collection;

import com.intern.student.entity.File;

import lombok.Data;

@Data
public class CourseDTO {

	private String id;
	
	private String courseName;
	
	private Collection<LecturerDTO> teacherDTO;		

	private Collection<File> fileDTO;
}
