package com.intern.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.student.dto.CourseDTO;
import com.intern.student.dto.EmployeeDTO;
import com.intern.student.dto.LecturerDTO;
import com.intern.student.entity.Course;
import com.intern.student.entity.Student;
import com.intern.student.entity.Lecturer;
import com.intern.student.repository.StudentRepository;

@RestController
@RequestMapping("/employee")
public class Test {

	@Autowired
	private StudentRepository studentRepo;

	@GetMapping("")
	public List<Student> getStudent() {
		List<Student> std = (List<Student>) studentRepo.findAll();
		List<EmployeeDTO> studentListDTO = new ArrayList<>();
		return std;
	}
}
