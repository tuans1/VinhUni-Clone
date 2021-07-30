package com.intern.student.dto;

import java.util.Collection;

import com.intern.student.entity.Classes;

import lombok.Data;

@Data
public class LecturerDTO {
	private String id;
	
	private String name;
	
	private Collection<ClassesDTO> classes;
	
	
}
