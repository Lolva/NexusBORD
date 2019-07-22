package com.atossyntel.springboot.model;

import java.sql.Date;

public class ModuleBean {
	
	private int module_name;
	private int course_id;
	
	public ModuleBean() {
		super();
		this.module_name = 0;
		this.course_id = 0;
	}
	
	
	public ModuleBean(int module_name, int course_id) {
		super();
		this.module_name = module_name;
		this.course_id = course_id;
	}


	public int getModule_name() {
		return module_name;
	}


	public void setModule_name(int module_name) {
		this.module_name = module_name;
	}


	public int getCourse_id() {
		return course_id;
	}


	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
	
	
	

}

