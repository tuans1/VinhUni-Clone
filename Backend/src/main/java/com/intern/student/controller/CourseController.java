package com.intern.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.student.entity.Course;
import com.intern.student.repository.CourseRepository;
import com.intern.student.service.impl.CourseServiceImpl;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseServiceImpl courseServiceImpl;

	@Autowired
	private CourseRepository courseRepo;

//	Lấy Khóa học kèm File dựa theo Tên Khóa học
	@GetMapping
	public Course getCourse() {
		Course course = courseRepo.findByName("CSDL");
		return course;
	}

	@GetMapping("/student")
	public List<Course> getStudent() {
		return courseRepo.findAll();
	}
}