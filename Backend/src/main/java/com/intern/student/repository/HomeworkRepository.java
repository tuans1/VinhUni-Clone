package com.intern.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intern.student.entity.Homework;
import com.intern.student.projection.StudentHomeworkProjection;

public interface HomeworkRepository extends JpaRepository<Homework, String>{

	@Query(value = "SELECT s.name , sh.path ,sh.create_date as 'createDate' FROM database1.student s left join database1.student_homework sh on sh.student_id = s.id and sh.homework_id=?1   ORDER BY SUBSTRING_INDEX((s.name),\" \",-1);",nativeQuery = true)
	List<StudentHomeworkProjection> findStudentHomeworkByHomeworkId(String id);
}
