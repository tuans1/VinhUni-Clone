package com.intern.student.dto;

import java.util.Collection;

import com.intern.student.entity.ClassDetail;
import com.intern.student.entity.Homework;

import lombok.Data;

@Data
public class ClassesDTO {

	private String id;
	private String className;
	private Collection<ClassDetailDTO> classDetail;
	private String lecturerName;
	private String lesson;
	private Collection<Homework> homework;
}
