package com.intern.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.student.entity.Classes;

public interface ClassesRepository extends JpaRepository<Classes, String> {

}
