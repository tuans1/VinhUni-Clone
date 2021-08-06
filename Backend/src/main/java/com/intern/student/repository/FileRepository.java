package com.intern.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intern.student.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File, String>{
	
	List<File> findByCourseIdAndLecturerId(String courseId,String lecturerId);
}
