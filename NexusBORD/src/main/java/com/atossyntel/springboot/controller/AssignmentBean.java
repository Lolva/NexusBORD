package com.atossyntel.springboot.controller;

public class AssignmentBean {
	private String assignmentName;
	private String due_date;
	private String max_points;
	private String submissionStatus;
	private String fileName;


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


	public String getSubmissionStatus() {
		return submissionStatus;
	}


	public void setSubmissionStatus(String submissionStatus) {
		this.submissionStatus = submissionStatus;
	}
	
	
}
