package com.intern.student.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intern.student.dto.ClassesDTO;
import com.intern.student.entity.Classes;
import com.intern.student.repository.ClassesRepository;

@RestController
@RequestMapping("classes")
public class ClassesController {

	@Autowired
	private ClassesRepository classesClassRepo;



//	Get info course contain List student kèm attendance 
	@GetMapping
	public ClassesDTO getStudent(@RequestParam String classesId, String lesson) {
		Optional<Classes> classes = classesClassRepo.findById(classesId);
		ClassesDTO classesDTO = new ClassesDTO();
		classesDTO.setId(classes.get().getId());
		classesDTO.setName(classes.get().getClassName());
		classesDTO.setClassDetail(classes.get().getClassDetail());
		classesDTO.setLecturerName(classes.get().getLecturer().getName());
		classesDTO.setLesson(lesson);
		return classesDTO;
	}
}
