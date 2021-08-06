package com.intern.student.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.intern.student.dto.FileInfo;
import com.intern.student.dto.StudentHomeworkUpload;

public interface FilesStorageService {
	void downloadFile(HttpServletRequest request, HttpServletResponse response, String fileName);

	void uploadFile(MultipartFile file, FileInfo info);
	
	void uploadStudentHomework(MultipartFile file, StudentHomeworkUpload info);
	
	void deleteFile(String id);

	List<com.intern.student.entity.File> getFileByCourseIdAndLecturerId(String courseId, String lecturerId);

}
