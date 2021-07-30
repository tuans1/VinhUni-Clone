package com.intern.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.student.entity.ClassDetail;
import com.intern.student.repository.ClassDetailRepository;

@RestController
@RequestMapping("class-detail")
public class ClassDetailController {
	
	@Autowired
	private ClassDetailRepository classDetailRepo;
	
	@GetMapping("/{id}")
	public ClassDetail getDetail(@PathVariable String id) {
		ClassDetail classDetail = classDetailRepo.findById(id).get();
		return classDetail;
	}
}
