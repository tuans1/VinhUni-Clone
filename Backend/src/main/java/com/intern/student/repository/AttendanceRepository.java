package com.intern.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.intern.student.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, String> {
	@Modifying
	@Query(value = "update attendance a set a.b1=?1 where a.id=?2", nativeQuery = true)
	void updateAttendance(String val, String id);
}
