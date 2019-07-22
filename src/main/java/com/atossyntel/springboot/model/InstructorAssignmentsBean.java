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
	
	
	
	public InstructorAssignmentsBean() {
		super();
		this.assignment_name = null;
		this.module_id = null;

		this.due_date = null;
		this.fileName = null;
		this.file_type = null;
		this.status = null;
		this.description = null;
	}

	public InstructorAssignmentsBean(String assignment_name, String module_id,  String due_date,
			String fileName, String file_type, String status, String description) {
		super();
		this.assignment_name = assignment_name;
		this.module_id = module_id;
	
		this.due_date = due_date;
		this.fileName = fileName;
		this.file_type = file_type;
		this.status = status;
		this.description = description;
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

	@Override
	public String toString() {
		return "InstructorAssignmentsBean [assignment_name=" + assignment_name + ", module_id=" + module_id  + ", due_date=" + due_date + ", fileName=" + fileName + ", file_type=" + file_type + ", status="
				+ status + ", description=" + description + "]";
	}
	
	
	
	
	

	

	

}
