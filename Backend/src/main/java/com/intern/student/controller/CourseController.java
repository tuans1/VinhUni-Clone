package com.intern.student.controller;

import java.util.List;

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

	@GetMapping("")
	public List<Course> getStudent() {
		return courseServiceImpl.getCourses();
	}
}