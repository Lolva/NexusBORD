package com.atossyntel.springboot.controller;

import java.sql.Date;
import java.sql.Timestamp;

public class InstructorAssignmentsBean {
	private String assignmentName;
	private String due_date;
	private String max_points;
	private String fileName;
	

	public InstructorAssignmentsBean() {
	
	}
	public InstructorAssignmentsBean(String assignmentName, String due_date, String string, String filename) {
		this.assignmentName = assignmentName;
		this.due_date = due_date;
		this.max_points = string;
		this.fileName = filename;
	}
	public InstructorAssignmentsBean(String assignmentName, String due_date) {
		this.assignmentName = assignmentName;
		this.due_date = due_date;
	}
	public String getAssignmentName() {
		return assignmentName;
	}


	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}


	public String getDue_date() {
		return due_date;
	}


	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}


	public String getMax_points() {
		return max_points;
	}


	public void setMax_points(String max_points) {
		this.max_points = max_points;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	@Override
	public String toString() {
		return "AssignmentBean [assignmentName=" + assignmentName + ", due_date=" + due_date + ", max_points="
				+ max_points + ", fileName=" + fileName  + "]";
	}
	
	
	
	
	
}
