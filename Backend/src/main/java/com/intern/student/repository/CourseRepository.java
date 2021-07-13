package com.intern.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intern.student.entity.Course;

public interface CourseRepository extends JpaRepository<Course, String>{

	Course findByName(String name);
	
	
}
