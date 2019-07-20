package com.atossyntel.springboot.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class GradeBean {
	private String studentName;
	private Timestamp submission_date;
	private BigDecimal grade;
	private String employee_id;
	private String file_name;
	
	
	
	public GradeBean() {
		super();
		this.studentName = "";
		this.submission_date = null;
		this.grade = null;
		this.employee_id = "";
		this.file_name = "";
	}
	public GradeBean(String studentName, Timestamp submission_date, BigDecimal grade, String employee_id, String file_name) {
		super();
		this.studentName = studentName;
		this.submission_date = submission_date;
		this.grade = grade;
		this.employee_id = employee_id;
		this.file_name = file_name;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Timestamp getSubmission_date() {
		return submission_date;
	}
	public void setSubmission_date(Timestamp submission_date) {
		this.submission_date = submission_date;
	}
	public BigDecimal getGrade() {
		return grade;
	}
	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	@Override
	public String toString() {
		return "GradeBean [studentName=" + studentName + ", submission_date=" + submission_date + ", grade=" + grade
				+ ", employee_id=" + employee_id + ", file_name=" + file_name + "]";
	}
	
	
}
