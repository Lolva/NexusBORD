package com.atossyntel.springboot.controller;

public class ClassBean {
	String class_Id;
	String course_Id;
	String capacity;
	
	
	
	    
	public String getClass_Id() {
		return class_Id;
	}




	public void setClass_Id(String class_Id) {
		this.class_Id = class_Id;
	}




	public String getCourse_Id() {
		return course_Id;
	}




	public void setCourse_Id(String course_Id) {
		this.course_Id = course_Id;
	}




	public String getCapacity() {
		return capacity;
	}




	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}




		@Override
	    public String toString() {
	        return "GradeBean{" + "class_Id=" + class_Id + ", course_Id=" + course_Id + ", capacity=" + capacity + '}';
	    }
	}
	


