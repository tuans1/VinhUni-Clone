package com.intern.student.dto;

import java.util.List;

import com.intern.student.entity.Attendance;

import lombok.Data;

@Data
public class ClassDetailDTO {
	private String id;
	private CourseDTO course;
	private StudentDTO student;
	private List<StudentDTO> studentList;
	private Attendance attendance;
	private ClassesDTO classes;
}
