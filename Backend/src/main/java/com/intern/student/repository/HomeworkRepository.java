package com.intern.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.student.entity.Homework;

public interface HomeworkRepository extends JpaRepository<Homework, String>{

}
