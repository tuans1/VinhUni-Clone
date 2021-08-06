package com.intern.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.student.dto.StudentHomeworkDTO;
import com.intern.student.projection.StudentHomeworkProjection;
import com.intern.student.repository.HomeworkRepository;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

	@Autowired
	HomeworkRepository homeworkRepo;

	@GetMapping("/{id}")
	public List<StudentHomeworkDTO> getDetailHomework(@PathVariable String id) {
		List<StudentHomeworkProjection> pro = homeworkRepo.findStudentHomeworkByHomeworkId(id);
		List<StudentHomeworkDTO> list = new ArrayList<>();
		for (StudentHomeworkProjection shPro : pro) {
			StudentHomeworkDTO sh = new StudentHomeworkDTO();
			sh.setName(shPro.getName());
			sh.setPath(shPro.getPath());
			sh.setCreateDate(shPro.getCreateDate());
			sh.setId(shPro.getId());
			list.add(sh);
		}
		return list;
	}
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteHomework(@PathVariable String id) {
		homeworkRepo.deleteById(id);
		return HttpStatus.OK;
	}
}
