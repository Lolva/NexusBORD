package com.atossyntel.springboot.model;

import java.sql.Date;

public class GradeBean {
	String studentName;
	Date submissionDate;
	String attachedFiles;
	Integer grade;
	
	
	

	public GradeBean() {
		super();
		this.studentName = "";
		this.submissionDate = null;
		this.attachedFiles = null;
		this.grade = null;
	}



	public GradeBean(String studentName) {
		super();
		this.studentName = studentName;
		this.submissionDate = null;
		this.attachedFiles = null;
		this.grade = null;
	}



	public GradeBean(String studentName, Date submissionDate, String attachedFiles, Integer grade) {
		super();
		this.studentName = studentName;
		this.submissionDate = submissionDate;
		this.attachedFiles = attachedFiles;
		this.grade = grade;
	}



	public String getStudentName() {
		return studentName;
	}



	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}



	public Date getSubmissionDate() {
		return submissionDate;
	}



	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}



	public String getAttachedFiles() {
		return attachedFiles;
	}



	public void setAttachedFiles(String attachedFiles) {
		this.attachedFiles = attachedFiles;
	}



	public Integer getGrade() {
		return grade;
	}



	public void setGrade(Integer grade) {
		this.grade = grade;
	}



	@Override
	public String toString() {
		return "GradeBean [studentName=" + studentName + ", submissionDate=" + submissionDate + ", attachedFiles="
				+ attachedFiles + ", grade=" + grade + "]";
	}
	
	
}
