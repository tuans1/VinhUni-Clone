package com.intern.student.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name = "attendance")
@Data
public class Attendance {

	@Id
	private String id;
	@Column(name = "b1")
	private Byte b1;
	@Column(name = "b2")
	private Byte b2;
	@Column(name = "b3")
	private Byte b3;
	@Column(name = "b4")
	private Byte b4;
	@Column(name = "b5")
	private Byte b5;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "class_detail_id", referencedColumnName = "id")
	private ClassDetail classDetail;

}
