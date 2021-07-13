package com.intern.student.dto;

import lombok.Data;

@Data
public class FileDTO {

	private String id;
	
	private String name;
	
	private String type;

	private String content;
	
	private String lecturerId;
}
