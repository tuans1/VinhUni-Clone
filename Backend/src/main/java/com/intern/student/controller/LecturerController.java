package com.intern.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.student.dto.ClassesDTO;
import com.intern.student.dto.CourseDTO;
import com.intern.student.dto.LecturerDTO;
import com.intern.student.entity.Classes;
import com.intern.student.entity.Course;
import com.intern.student.entity.Lecturer;
import com.intern.student.repository.LecturerRepository;

@RestController
@RequestMapping("/lecturer")
public class LecturerController {

	@Autowired
	LecturerRepository lecturerRepo;

	@GetMapping("/classes/{id}")
	public LecturerDTO getLecturerClasses(@PathVariable String id) {
		Lecturer lecturer = lecturerRepo.findById(id).get();
		LecturerDTO lecturerDTO = new LecturerDTO();
		
		List<ClassesDTO> classes = new ArrayList<>();
		for (Classes cl : lecturer.getClasses()) {
			ClassesDTO cls = new ClassesDTO();
			cls.setId(cl.getId());
			cls.setClassName(cl.getClassName());
			classes.add(cls);
		}
		lecturerDTO.setClasses(classes);
		return lecturerDTO;
	}
	
	@GetMapping("/homework/{id}")
	public LecturerDTO getLecturerHomework(@PathVariable String id) {
		Lecturer lecturer = lecturerRepo.findById(id).get();
		LecturerDTO lecturerDTO = new LecturerDTO();
		
		List<ClassesDTO> classes = new ArrayList<>();
		for (Classes cl : lecturer.getClasses()) {
			ClassesDTO cls = new ClassesDTO();
			cls.setId(cl.getId());
			cls.setClassName(cl.getClassName());
			classes.add(cls);
		}
		lecturerDTO.setClasses(classes);
		return lecturerDTO;
	}

	@GetMapping("/course/{id}")
	public LecturerDTO getLecturerCourse(@PathVariable String id) {
		Lecturer lecturer = lecturerRepo.findById(id).get();
		LecturerDTO lecturerDTO = new LecturerDTO();
		
		List<CourseDTO> course = new ArrayList<>();
		for (Course cl : lecturer.getCourses()) {
			CourseDTO c = new CourseDTO();
			c.setId(cl.getId());
			c.setName(cl.getName());
			c.setFiles(cl.getFile());
			course.add(c);
		}
		lecturerDTO.setCourse(course);
		return lecturerDTO;
	}
}
