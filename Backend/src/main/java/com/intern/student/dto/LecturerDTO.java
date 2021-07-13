package com.intern.student.dto;

import java.util.Collection;

import lombok.Data;

@Data
public class LecturerDTO {
	private String id;
	private String name;

	private Collection<FileDTO> fileDTO;
}
