package com.intern.student.dto;

import java.util.Collection;

import com.intern.student.entity.ClassDetail;

import lombok.Data;

@Data
public class ClassesDTO {

	private String id;
	private String name;
	private Collection<ClassDetail> classDetail;
	private String lecturerName;
	private String lesson;
}
