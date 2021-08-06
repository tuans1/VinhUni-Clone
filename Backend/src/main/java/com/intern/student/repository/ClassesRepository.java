package com.intern.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intern.student.entity.Classes;
import com.intern.student.projection.StudentHomeworkProjection;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, String> {

	@Query(value="SELECT hw.id , hw.class_id as 'classId' , hw.name as 'homework', hw.dead_line as 'deadLine',hw.required, sh.name,sh.path ,sh.create_date as 'createDate' FROM database1.homework hw left join database1.student_homework sh on sh.homework_id = hw.id and sh.student_id=?2 where hw.class_id = ?1",nativeQuery = true)
	List<StudentHomeworkProjection> findStudentHomeworkById(String classesId,String studentId);
	
}
