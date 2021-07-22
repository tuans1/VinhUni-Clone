package com.intern.student.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intern.student.dto.ClassesDTO;
import com.intern.student.entity.Attendance;
import com.intern.student.entity.Classes;
import com.intern.student.repository.AttendanceRepository;
import com.intern.student.repository.ClassesRepository;

@RestController
@RequestMapping("classes")
public class ClassesController {

	@Autowired
	private ClassesRepository classesClassRepo;

	@Autowired
	private AttendanceRepository attendanceRepo;

//	Lấy List student kèm attendance 
	@GetMapping
	public ClassesDTO getStudent(@RequestParam String classesId, String lesson, String attendanceId,
			Byte attendanceVal) {
		if (attendanceId != null) {
			Optional<Attendance> attendance = attendanceRepo.findById(attendanceId);
			switch (lesson) {
			case "b1":
				attendance.get().setB1(attendanceVal);
				break;
			case "b2":
				attendance.get().setB2(attendanceVal);
				break;
			case "b3":
				attendance.get().setB3(attendanceVal);
				break;
			case "b4":
				attendance.get().setB4(attendanceVal);
				break;
			default:
				attendance.get().setB5(attendanceVal);
				break;
			}
			attendanceRepo.save(attendance.get());
		}
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
