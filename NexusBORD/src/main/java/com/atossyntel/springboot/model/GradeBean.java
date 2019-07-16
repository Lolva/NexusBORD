package com.atossyntel.springboot.model;

public class GradeBean {
	private int sub_grade;
	private int sub_id;
	
	public GradeBean() {
		super();
		this.sub_grade = 0;
		this.sub_id = 0;
	}
	public GradeBean(int sub_grade, int sub_id) {
		super();
		this.sub_grade = sub_grade;
		this.sub_id = sub_id;
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

  
