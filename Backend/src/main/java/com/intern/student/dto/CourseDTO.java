package com.intern.student.dto;

import java.util.Collection;

import com.intern.student.entity.File;

import lombok.Data;

@Data
public class CourseDTO {

	private String id;
	
	private String name;
	
	private Collection<LecturerDTO> lecturers;
	
	private Collection<File> files;

}
