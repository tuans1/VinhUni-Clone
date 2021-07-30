package com.intern.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intern.student.entity.Homework;
import com.intern.student.repository.HomeworkRepository;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

	@Autowired
	HomeworkRepository homeworkRepo;
	@GetMapping
	public Homework getDetailHomework(@RequestParam String homeworkId) {
		return homeworkRepo.findById(homeworkId).get();
	}
}
