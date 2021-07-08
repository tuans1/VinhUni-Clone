package com.intern.student.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.intern.student.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String>{
	
}
