package com.intern.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intern.student.entity.ClassDetail;

@Repository
public interface ClassDetailRepository extends JpaRepository<ClassDetail, String> {

	
}
