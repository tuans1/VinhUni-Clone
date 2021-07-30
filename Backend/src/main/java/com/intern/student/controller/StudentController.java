package com.intern.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.student.dto.ClassDetailDTO;
import com.intern.student.dto.CourseDTO;
import com.intern.student.dto.LecturerDTO;
import com.intern.student.dto.StudentDTO;
import com.intern.student.entity.ClassDetail;
import com.intern.student.entity.Lecturer;
import com.intern.student.entity.Student;
import com.intern.student.repository.ClassDetailRepository;
import com.intern.student.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private ClassDetailRepository classDetailRepo;

	

	@GetMapping("/{id}")
	public StudentDTO getStudentCourseDetail(@PathVariable String id) {
		Student std = studentRepo.findById("231e").get();
		StudentDTO student = new StudentDTO();
		List<ClassDetailDTO> classList = new ArrayList<>();
		for (ClassDetail classDetail : std.getClassDetail()) {
			ClassDetailDTO cd = new ClassDetailDTO();
			CourseDTO c = new CourseDTO();
			c.setId(classDetail.getClasses().getCourse().getId());
			c.setName(classDetail.getClasses().getCourse().getName());
			c.setFiles(classDetail.getClasses().getCourse().getFile());
			List<LecturerDTO> lecturer = new ArrayList<>();
			for (Lecturer l : classDetail.getClasses().getCourse().getLecturers()) {
				LecturerDTO lDTO = new LecturerDTO();
				lDTO.setId(l.getId());
				lDTO.setName(l.getName());
				lecturer.add(lDTO);
			}
			c.setLecturers(lecturer);
			cd.setCourse(c);
			classList.add(cd);
		}
		student.setCourses(classList);
		return student;
	}
}
