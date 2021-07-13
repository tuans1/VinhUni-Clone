package com.intern.student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.student.dto.CourseDTO;
import com.intern.student.dto.LecturerDTO;
import com.intern.student.entity.Course;
import com.intern.student.entity.Lecturer;
import com.intern.student.repository.CourseRepository;
import com.intern.student.service.impl.CourseServiceImpl;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseServiceImpl courseServiceImpl;

	@Autowired
	private CourseRepository courseRepo;

//	Lấy Khóa học kèm File dựa theo Tên Khóa học
	@GetMapping("/{id}")
	public CourseDTO getCourse(@PathVariable String id) {
		Optional<Course> course = courseRepo.findById(id);
		CourseDTO courseDTO = new CourseDTO();
		List<LecturerDTO> lecturerDTOList = new ArrayList<>();
		for (Lecturer lecturer : course.get().getLecturer()) {
			LecturerDTO lecturerDTO = new LecturerDTO();
			lecturerDTO.setId(lecturer.getId());
			lecturerDTO.setName(lecturer.getName());
			lecturerDTOList.add(lecturerDTO);
		}
		courseDTO.setName(course.get().getName());
		courseDTO.setLecturerDTO(lecturerDTOList);
		courseDTO.setFileDTO(course.get().getFiles());
		return courseDTO;
		
	}

}