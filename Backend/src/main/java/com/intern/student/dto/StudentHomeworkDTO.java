package com.intern.student.dto;

import lombok.Data;

@Data
public class StudentHomeworkDTO {
	private String id;
	private String path;
	
	private String class_id;
	private String deadLine;
	private String required;
	private String name;
	private String homework;
	private String createDate;
}
