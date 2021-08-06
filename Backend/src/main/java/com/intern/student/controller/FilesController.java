package com.intern.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intern.student.dto.FileInfo;
import com.intern.student.dto.StudentHomeworkUpload;
import com.intern.student.entity.File;
import com.intern.student.service.FilesStorageService;

@RestController
@RequestMapping("/file")
public class FilesController {

	@Autowired
	private FilesStorageService fileService;

	@GetMapping("/download/{fileName:.+}")
	public void downloadFile(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("fileName") String fileName) throws IOException {
		fileService.downloadFile(request, response, fileName);
	}

	@GetMapping
	public List<File> getFileByCourseIdAndLecturerId(@RequestParam String courseId, String lecturerId) {
		List<File> files = fileService.getFileByCourseIdAndLecturerId(courseId, lecturerId);
		return files;
	}

	@PostMapping("/upload")
	public void uploadFile(@RequestPart("fileDetail") String info, @RequestPart("file") MultipartFile file) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			FileInfo fileInfo = objectMapper.readValue(info, FileInfo.class);
			fileService.uploadFile(file, fileInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostMapping("/student-homework")
	public void uploadStudentHomework(@RequestPart("student") String info, @RequestPart("file") MultipartFile file) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			StudentHomeworkUpload fileInfo = objectMapper.readValue(info, StudentHomeworkUpload.class);
			fileService.uploadStudentHomework(file, fileInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteFile(@PathVariable String id) {
		fileService.deleteFile(id);
		return HttpStatus.OK;
	}
}
