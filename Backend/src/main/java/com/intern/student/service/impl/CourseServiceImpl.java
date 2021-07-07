package com.intern.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.student.dto.CourseDTO;
import com.intern.student.entity.Course;
import com.intern.student.repository.CourseRepository;
import com.intern.student.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepo;

	@Override
	public List<Course> getCourses() {
		List<Course> courses = courseRepo.findAll();
		return courses;
	}
}
