package com.intern.student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.student.dto.CourseDTO;
import com.intern.student.dto.StudentDTO;
import com.intern.student.dto.LecturerDTO;
import com.intern.student.entity.Course;
import com.intern.student.entity.Student;
import com.intern.student.entity.Lecturer;
import com.intern.student.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepo;

	@GetMapping("")
	public Student getStudentWithCourses() {
		Optional<Student> student = studentRepo.findById("231e");
		Student std = student.get();
		return student.get();
	}
}
