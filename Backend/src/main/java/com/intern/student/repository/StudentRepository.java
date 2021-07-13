package com.intern.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intern.student.dto.StudentDTO;
import com.intern.student.entity.Student;
import com.intern.student.projection.StudentProjection;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{
	@Query(value="select s.* from student s join student_course sc on sc.student_id = s.id inner join course c on c.id=sc.course_id where (s.id=1 )",nativeQuery = true)
	Optional<Student> getStd();
}

//select c.name from student s join student_course sc on sc.student_id = s.id join course c on c.id=sc.course_id where s.id=1