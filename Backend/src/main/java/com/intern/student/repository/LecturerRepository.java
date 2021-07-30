package com.intern.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intern.student.entity.Lecturer;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, String>{

	
}
