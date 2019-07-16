package com.atossyntel.springboot.model;

public class Student {
	   // @Id
	    //@Column
	    //@GeneratedValue(strategy=GenerationType.AUTO)        
	    String studentId;
	    String firstname;
	    String lastname;
	    String password;
	    int grade;

	    public Student(String studentId, String firstname, String lastname, String password, int grade) {
	        this.studentId = studentId;
	        this.firstname = firstname;
	        this.lastname = lastname;
	        this.password = password;
	        this.grade = grade;
	    }
	   

	   

	  

	    public Student() {
	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }

	    

	   
	    

	    public String getFirstname() {
	        return firstname;
	    }

	    public void setFirstname(String firstname) {
	        this.firstname = firstname;
	    }

	    public String getLastname() {
	        return lastname;
	    }

	    public void setLastname(String lastname) {
	        this.lastname = lastname;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getStudentId() {
	        return studentId;
	    }

	    public void setStudentId(String studentId) {
	        this.studentId = studentId;
	    }

	  

	    public int getGrade() {
	        return grade;
	    }

	    public void setGrade(int grade) {
	        this.grade = grade;
	    }
	    
	    
	    
	    
	}
