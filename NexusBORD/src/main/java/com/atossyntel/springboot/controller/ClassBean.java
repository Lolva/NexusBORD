package com.atossyntel.springboot.controller;

public class ClassBean {
	int class_Id;
	int course_Id;
	int capacity;
	
	
	public ClassBean(int class_Id, int course_Id, int capacity) {
		this.class_Id = class_Id;
        this.course_Id = course_Id;
        this.capacity = capacity;
    }
	
	 public int getClass_Id() {
	        return class_Id;
	    }

	    public void setClass_Id(int class_Id) {
	        this.class_Id = class_Id;
	    }

	    public int getCourse_Id() {
	        return course_Id;
	    }

	    public void setCourse_Id(int course_Id) {
	        this.course_Id = course_Id;
	    }

	    public int getCapacity() {
	        return capacity;
	    }

	    public void setCapacity(int capacity) {
	        this.capacity = capacity;
	    }
	    
	    @Override
	    public String toString() {
	        return "GradeBean{" + "class_Id=" + class_Id + ", course_Id=" + course_Id + ", capacity=" + capacity + '}';
	    }
	}
	


