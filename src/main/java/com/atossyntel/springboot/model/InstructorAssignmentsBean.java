package com.atossyntel.springboot.model;

import java.sql.Date;
import java.sql.Timestamp;

public class InstructorAssignmentsBean {
	private String assignment_name;
	private String module_id;
	private String due_date;
	private String fileName;
	private String file_type;
	private String status;
	private String description;
	private String stream_id;
	private String class_id;
	private int assignment_id;
	
	
	
	public InstructorAssignmentsBean() {
		super();
		this.assignment_name = null;
		this.module_id = null;
		this.stream_id = null;
		this.due_date = null;
		this.fileName = null;
		this.file_type = null;
		this.status = null;
		this.description = null;
		this.class_id = null;
		this.assignment_id = 0;
	}

	public InstructorAssignmentsBean(String assignment_name, String module_id,  String due_date,
			String fileName, String file_type, String status, String description, String class_id, String stream_id, int assignment_id) {
		super();
		this.assignment_name = assignment_name;
		this.module_id = module_id;
		this.stream_id = null;
		this.class_id = null;
		this.due_date = due_date;
		this.fileName = fileName;
		this.file_type = file_type;
		this.status = status;
		this.description = description;
		this.assignment_id = assignment_id;
	}

	public String getAssignment_name() {
		return assignment_name;
	}

	public void setAssignment_name(String assignment_name) {
		this.assignment_name = assignment_name;
	}

	public String getModule_id() {
		return module_id;
	}

	public void setModule_id(String module_id) {
		this.module_id = module_id;
	}

	

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStream_id() {
		return stream_id;
	}

	public void setStream_id(String stream_id) {
		this.stream_id = stream_id;
	}

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	
	public int getAssignment_id() {
		return assignment_id;
	}

	public void setAssignment_id(int assignment_id) {
		this.assignment_id = assignment_id;
	}

	@Override
	public String toString() {
		return "InstructorAssignmentsBean [assignment_name=" + assignment_name + ", module_id=" + module_id
				+ ", due_date=" + due_date + ", fileName=" + fileName + ", file_type=" + file_type + ", status="
				+ status + ", description=" + description + ", stream_id=" + stream_id + ", class_id=" + class_id
				+ ", assignment_id=" + assignment_id + "]";
	}

	
	
	
	
	
	

	

	

}
