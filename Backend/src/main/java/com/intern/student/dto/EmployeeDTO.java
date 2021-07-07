package com.intern.student.dto;

import java.util.Collection;

import com.intern.student.entity.Course;
import com.intern.student.entity.Student;

import lombok.Data;

@Data
public class EmployeeDTO {
	
	private String id;

	private String name;

	private Collection<CourseDTO> coursesDto;

}
