package com.intern.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intern.student.dto.ClassDetailDTO;
import com.intern.student.dto.ClassesDTO;
import com.intern.student.dto.StudentDTO;
import com.intern.student.entity.ClassDetail;
import com.intern.student.entity.Classes;
import com.intern.student.repository.ClassesRepository;

@RestController
@RequestMapping("classes")
public class ClassesController {

	@Autowired
	private ClassesRepository classesClassRepo;

//	Get info course contain List student 
	@GetMapping
	public ClassesDTO getStudent(@RequestParam String classesId, String lesson) {
		Classes classes = classesClassRepo.findById(classesId).get();
		ClassesDTO classesDTO = new ClassesDTO();
		classesDTO.setId(classes.getId());
		classesDTO.setClassName(classes.getClassName());
		List<ClassDetailDTO> classDetail = new ArrayList<>();
		for (ClassDetail cd  : classes.getClassDetail()) {
			ClassDetailDTO cdDTO = new ClassDetailDTO();
			StudentDTO s = new StudentDTO();
			cdDTO.setId(cd.getId());
			s.setId(cd.getStudent().getId());
			s.setName(cd.getStudent().getName());
			s.setDob(cd.getStudent().getDob());
			cdDTO.setStudent(s);
			cdDTO.setAttendance(cd.getAttendance());
			classDetail.add(cdDTO);
		}
		
		classesDTO.setClassDetail(classDetail);
		classesDTO.setLesson(lesson);
		return classesDTO;
	}

	@GetMapping("/homework")
	public ClassesDTO getHomework(@RequestParam String classesId) {
		Classes classes = classesClassRepo.findById(classesId).get();
		ClassesDTO classesDTO = new ClassesDTO();
		classesDTO.setHomework(classes.getHomeWork());
		return classesDTO;
	}
}
