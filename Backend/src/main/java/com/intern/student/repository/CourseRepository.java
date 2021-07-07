package com.intern.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.student.entity.Course;

public interface CourseRepository extends JpaRepository<Course, String>{

}
