package com.atossyntel.springboot.model;


public class EmployeeBean {
    private String First_Name;
    private String Last_Name;
    private String Email;
    private String Employee_Id;
    private String class_id;

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String First_Name) {
        this.First_Name = First_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEmployee_Id() {
        return Employee_Id;
    }

    public void setEmployee_Id(String Employee_Id) {
        this.Employee_Id = Employee_Id;
    }

    
    public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	@Override
    public String toString() {
        return "EmployeeBean{" + "First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", Email=" + Email + ", Employee_Id=" + Employee_Id + '}';
    }
    
    
    
}
