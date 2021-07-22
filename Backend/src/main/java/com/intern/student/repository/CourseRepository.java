package com.intern.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intern.student.entity.Course;

public interface CourseRepository extends JpaRepository<Course, String>{

	@Query(value="select * from course c left join file f on c.id = f.course_id "
			+ "where f.type = 1 and c.id = 1",nativeQuery = true)
	Course findByCourseFile();
	
	
}
