package com.intern.student.dto;

import java.util.List;

import lombok.Data;

@Data
public class HomeworkDTO {
	private List<StudentHomeworkDTO> students;
	private StudentHomeworkDTO student;
	private String id;
	private String name;
	private String required;
	private String deadLine;
	
}
