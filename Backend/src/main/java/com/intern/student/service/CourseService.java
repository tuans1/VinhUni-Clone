package com.intern.student.service;

import java.util.List;

import com.intern.student.entity.Course;

public interface CourseService {

	 abstract Iterable<Course> getCourses();
}
