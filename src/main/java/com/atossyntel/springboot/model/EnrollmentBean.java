package com.atossyntel.springboot.model;

import java.sql.Date;

public class EnrollmentBean {
	String Employee_ID;
	String old_Class_ID;
	String Class_ID;
	String Role_ID;
	Date Enrollment_Date;
	
	
	public String getOld_Class_ID() {
		return old_Class_ID;
	}
	public void setOld_Class_ID(String old_Class_ID) {
		this.old_Class_ID = old_Class_ID;
	}
	public String getEmployee_ID() {
		return Employee_ID;
	}
	public void setEmployee_ID(String employee_ID) {
		Employee_ID = employee_ID;
	}
	public String getClass_ID() {
		return Class_ID;
	}
	public void setClass_ID(String class_ID) {
		Class_ID = class_ID;
	}
	public String getRole_ID() {
		return Role_ID;
	}
	public void setRole_ID(String role_ID) {
		Role_ID = role_ID;
	}
	public Date getEnrollment_Date() {
		return Enrollment_Date;
	}
	public void setEnrollment_Date(Date enrollment_Date) {
		Enrollment_Date = enrollment_Date;
	}
	@Override
	public String toString() {
		return "EnrollementBean [Employee_ID=" + Employee_ID + ", Class_ID=" + Class_ID + ", Role_ID=" + Role_ID
				+ ", Enrollment_Date=" + Enrollment_Date + "]";
	}
	
	

}