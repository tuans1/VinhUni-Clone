package com.intern.student.dto;

import java.util.Collection;

import com.intern.student.entity.File;
import com.intern.student.entity.Lecturer;

import lombok.Data;

@Data
public class CourseDTO {

	private String id;
	
	private String name;
	
	private Collection<LecturerDTO> lecturerDTO;		

	private Collection<File> fileDTO;
}
