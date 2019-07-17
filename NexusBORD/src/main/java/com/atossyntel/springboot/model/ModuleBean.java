package com.atossyntel.springboot.model;

import java.sql.Date;

public class ModuleBean {
	
	private int module_name;
	private String assignment_name; 
	private Date due_date;
	private boolean submitted;
	
	public ModuleBean() {
		super();
		this.module_name = 0;
		this.assignment_name = "";
		this.due_date = null;
		this.submitted = false;
	}
	
	public ModuleBean(int module_name, String assignment_name, Date due_date, boolean submitted) {
		super();
		this.module_name = module_name;
		this.assignment_name = assignment_name;
		this.due_date = due_date;
		this.submitted = submitted;
	}

	public int getModule_name() {
		return module_name;
	}

	public void setModule_name(int module_name) {
		this.module_name = module_name;
	}

	public String getAssignment_name() {
		return assignment_name;
	}

	public void setAssignment_name(String assignment_name) {
		this.assignment_name = assignment_name;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public boolean isSubmitted() {
		return submitted;
	}

	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}
	
	
	

}

