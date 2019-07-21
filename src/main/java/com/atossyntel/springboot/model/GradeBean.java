package com.atossyntel.springboot.model;


public class GradeBean {
	private String assignment_id;
	private String employee_id;
	private int grade;
	
	
	
	public GradeBean() {
		
		this.assignment_id = null;
		this.grade = 0;
		this.employee_id = null;
	
	}



	public GradeBean(String assignment_id, String employee_id, int grade) {
		super();
		this.assignment_id = assignment_id;
		this.employee_id = employee_id;
		this.grade = grade;
	}



	public String getAssignment_id() {
		return assignment_id;
	}



	public void setAssignment_id(String assignment_id) {
		this.assignment_id = assignment_id;
	}



	public String getEmployee_id() {
		return employee_id;
	}



	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}



	public int getGrade() {
		return grade;
	}



	public void setGrade(int grade) {
		this.grade = grade;
	}



	@Override
	public String toString() {
		return "GradeBean [assignment_id=" + assignment_id + ", employee_id=" + employee_id + ", grade=" + grade + "]";
	}
	
	
	
}
