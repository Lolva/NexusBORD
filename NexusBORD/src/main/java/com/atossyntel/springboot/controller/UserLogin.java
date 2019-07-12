
package com.atossyntel.springboot.controller;

public class UserLogin {
    
    private String username;
    private String password;
    private String suffix;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String skills;

    public UserLogin() {
    }
        
	public UserLogin(String username, String password, String suffix, String firstName, String lastName,
			String birthDate, String skills) {
		super();
		this.username = username;
		this.password = password;
		this.suffix = suffix;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.skills = skills;
	}
	
	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", password=" + password + ", suffix=" + suffix + ", firstName="
				+ firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", skills=" + skills + "]";
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

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
    
    
  
}
