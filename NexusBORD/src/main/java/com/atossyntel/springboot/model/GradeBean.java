package com.atossyntel.springboot.model;

import java.sql.Date;

public class GradeBean {
	private int sub_grade;
	private int sub_id;
	private String student_id;
	private Date submission_date;
	private String attached_files;
	
	public GradeBean() {
		super();
		this.sub_grade = 0;
		this.sub_id = 0;
		this.student_id ="";
		this.submission_date = null;
		this.attached_files = "";
	}
	public GradeBean(int sub_grade, int sub_id) {
		super();
		this.sub_grade = sub_grade;
		this.sub_id = sub_id;
		this.student_id ="";
		this.submission_date = null;
		this.attached_files = "";
	}
	
	public GradeBean(int sub_grade, int sub_id, String student_id, Date submission_date, String attached_files) {
		super();
		this.sub_grade = sub_grade;
		this.sub_id = sub_id;
		this.student_id = student_id;
		this.submission_date = submission_date;
		this.attached_files = attached_files;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public Date getSubmission_date() {
		return submission_date;
	}
	public void setSubmission_date(Date submission_date) {
		this.submission_date = submission_date;
	}
	public String getAttached_files() {
		return attached_files;
	}
	public void setAttached_files(String attached_files) {
		this.attached_files = attached_files;
	}
	public int getSub_grade() {
		return sub_grade;
	}
	public void setSub_grade(int sub_grade) {
		this.sub_grade = sub_grade;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	
	

}

  
