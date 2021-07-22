package com.intern.student.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.student.dto.CourseDTO;
import com.intern.student.dto.StudentDTO;
import com.intern.student.dto.LecturerDTO;
import com.intern.student.entity.Course;
import com.intern.student.entity.Student;
import com.intern.student.entity.Lecturer;
import com.intern.student.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepo;

	@GetMapping("")
	public List<Student> getStudentCourse() {
		List<Student> student = studentRepo.findAll();
		return student;
//		List<CourseDTO> courseDTOList = new ArrayList<>();
//		for (Course course : student.get().getCourses()) {
//			CourseDTO courseDTO = new CourseDTO();
//			courseDTO.setId(course.getId());
//			courseDTO.setName(course.getName());
//			List<LecturerDTO> lecturerList = new ArrayList<>();
//			for (Lecturer lecturer : course.getLecturer()) {
//				LecturerDTO lecturerDTO = new LecturerDTO();
//				lecturerDTO.setId(lecturer.getId());
//				lecturerDTO.setName(lecturer.getName());
//				lecturerList.add(lecturerDTO);
//			}
//			courseDTO.setLecturerDTO(lecturerList);
//			courseDTO.setFileDTO(course.getFiles());
//			courseDTOList.add(courseDTO);
//		}
//		StudentDTO studentDTO = new StudentDTO();
//		studentDTO.setCoursesDto(courseDTOList);
//		return studentDTO;
	}
	
//	@GetMapping("/student-course-detail")
//	public StudentDTO getStudentCourseDetail() {
//		Optional<Student> student = studentRepo.findById("231e");
//		List<CourseDTO> courseList = new ArrayList<>();
//		for (Course course : student.get().getCourses()) {
//			CourseDTO courseDTO = new CourseDTO();
//			courseDTO.setName(course.getName());
//			List<LecturerDTO> lecturerList = new ArrayList<>();
//			for (Lecturer lecturer : course.getLecturer()) {
//				LecturerDTO lecturerDTO = new LecturerDTO();
//				lecturerDTO.setName(lecturer.getName());
//				lecturerList.add(lecturerDTO);
//			}
//			courseDTO.setLecturerDTO(lecturerList);
//			courseDTO.setFileDTO(course.getFiles());
//			courseList.add(courseDTO);
//		}
//		StudentDTO studentDTO = new StudentDTO();
//		studentDTO.setCoursesDto(courseList);
//		return studentDTO;
//	}
}
