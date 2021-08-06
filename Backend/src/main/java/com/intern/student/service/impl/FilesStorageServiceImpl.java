package com.intern.student.service.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.intern.student.dto.FileInfo;
import com.intern.student.dto.StudentHomeworkUpload;
import com.intern.student.entity.StudentHomework;
import com.intern.student.repository.FileRepository;
import com.intern.student.repository.StudentHomeworkRepository;
import com.intern.student.service.FilesStorageService;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

	@Autowired
	private FileRepository fileRepo;
	
	@Autowired
	private StudentHomeworkRepository studentHomeworkRepo;

	private static final String EXTERNAL_FILE_PATH = "C:/FileVinhUni/";

	@Override
	public void downloadFile(HttpServletRequest request, HttpServletResponse response, String fileName) {
		File file = new File(EXTERNAL_FILE_PATH + fileName);
		if (file.exists()) {
			try {
				// get the mimetype
				String mimeType = URLConnection.guessContentTypeFromName(file.getName());
				if (mimeType == null) {
					// unknown mimetype so set the mimetype to application/octet-stream
					mimeType = "application/octet-stream";
				}

				response.setContentType(mimeType);

				/**
				 * In a regular HTTP response, the Content-Disposition response header is a
				 * header indicating if the content is expected to be displayed inline in the
				 * browser, that is, as a Web page or as part of a Web page, or as an
				 * attachment, that is downloaded and saved locally.
				 * 
				 */

				/**
				 * Here we have mentioned it to show inline
				 */
				response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

				// Here we have mentioned it to show as attachment
				// response.setHeader("Content-Disposition", String.format("attachment;
				// filename=\"" + file.getName() + "\""));

				response.setContentLength((int) file.length());

				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

				FileCopyUtils.copy(inputStream, response.getOutputStream());

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	private void storeFile(MultipartFile file) {
		File folder = new File(EXTERNAL_FILE_PATH, file.getOriginalFilename());
		try {
			file.transferTo(folder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void uploadFile(MultipartFile file, FileInfo info) {
		try {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			com.intern.student.entity.File f = new com.intern.student.entity.File();
			f.setId(UUID.randomUUID().toString());
			f.setContent(info.getContent());
			f.setLecturerId(info.getLecturerId());
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			f.setCreateDate(dateFormat.format(date));
			f.setPath(fileName);
			f.setCourseId(info.getCourseId());
			fileRepo.save(f);
			this.storeFile(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<com.intern.student.entity.File> getFileByCourseIdAndLecturerId(String courseId, String lecturerId) {
		return fileRepo.findByCourseIdAndLecturerId(courseId, lecturerId);
	}

	
	
	@Override
	public void deleteFile(String id) {
		com.intern.student.entity.File f = fileRepo.findById(id).get();
		File file = new File(EXTERNAL_FILE_PATH, f.getPath());
		if (file.delete()) // returns Boolean value
		{
			fileRepo.deleteById(id);
		} else {
			System.out.println("failed");
		}
	}
	@Override
	public void uploadStudentHomework(MultipartFile file, StudentHomeworkUpload info) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		StudentHomework sh = new StudentHomework();
		sh.setId(UUID.randomUUID().toString());
		sh.setHomeworkId(info.getHomeworkId());
		sh.setPath(fileName);
		sh.setStudentId(info.getStudentId());
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm dd-MM-yyyy");  
		Date date = new Date();  
		sh.setCreateDate(formatter.format(date));
		studentHomeworkRepo.save(sh);
		this.storeFile(file);
	}

}