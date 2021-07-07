package com.intern.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.student.entity.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, String>{

}
