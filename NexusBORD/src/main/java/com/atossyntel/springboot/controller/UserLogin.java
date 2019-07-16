package com.atossyntel.springboot.controller;

public class UserLogin {
    private String username;
    private String password;
    private boolean instructor;

    public UserLogin() {
    	this.username = "";
    	this.password = "";
    	this.instructor = false;
    }
    public UserLogin(String username, String password) {
    	this.username = username;
    	this.password = password;
    	this.instructor = false;
    }
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getInstructor() {
		return instructor;
	}
	public void setInstructor(boolean instructor) {
		this.instructor = instructor;
	}
	
	public void updateInst(UserLoginDAO dao) {
		this.instructor = dao.isInstructor(this);
	}
	
	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", password=" + password + "]";
	} 
}