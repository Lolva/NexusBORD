package com.atossyntel.springboot.model;


public class StudentSubmissionBean {
	private String assignment_id;
	private String employee_id;
	private String stream_id;
	private String module_id;
	private String class_id;
	
	
	


	public StudentSubmissionBean() {
		super();
		this.assignment_id = null;
		this.employee_id = null;
		this.stream_id = null;
		this.module_id = null;
		this.class_id = null;
	}



	public StudentSubmissionBean(String assignment_id, String employee_id, String stream_id, String module_id,
			String class_id) {
		super();
		this.assignment_id = assignment_id;
		this.employee_id = employee_id;
		this.stream_id = stream_id;
		this.module_id = module_id;
		this.class_id = class_id;
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



	public String getStream_id() {
		return stream_id;
	}



	public void setStream_id(String stream_id) {
		this.stream_id = stream_id;
	}



	public String getModule_id() {
		return module_id;
	}



	public void setModule_id(String module_id) {
		this.module_id = module_id;
	}



	public String getClass_id() {
		return class_id;
	}



	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}



	@Override
	public String toString() {
		return "StudentSubmissionBean [assignment_id=" + assignment_id + ", employee_id=" + employee_id + ", stream_id="
				+ stream_id + ", module_id=" + module_id + ", class_id=" + class_id + "]";
	}





	
	
}
