package com.intern.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.student.entity.StudentHomework;

public interface StudentHomeworkRepository extends JpaRepository<StudentHomework, String>{

}
