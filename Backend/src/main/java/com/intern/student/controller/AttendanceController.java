package com.intern.student.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intern.student.entity.Attendance;
import com.intern.student.repository.AttendanceRepository;

@RequestMapping("attendance")
@RestController
public class AttendanceController {

	@Autowired
	private AttendanceRepository attendanceRepo;

//	điểm danh 
	@PostMapping
	public HttpStatus attendanceStudent(@RequestParam String attendanceId, Byte attendanceVal, String lesson) {
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
		return HttpStatus.OK;
	}
}
