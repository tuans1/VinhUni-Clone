package com.intern.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intern.student.entity.Classes;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, String> {


}
