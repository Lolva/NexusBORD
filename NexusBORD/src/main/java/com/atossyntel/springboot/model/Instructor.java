package com.atossyntel.springboot.model;

class Instructor {
    String firstname;
    String lastname;
    String password;
    Boolean is_instructor;
    int Grade;

    public Instructor(String firstname, String lastname, String password, Boolean is_instructor, int Grade) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.is_instructor = is_instructor;
        this.Grade = Grade;
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

    public Boolean getIs_instructor() {
        return is_instructor;
    }

    public void setIs_instructor(Boolean is_instructor) {
        this.is_instructor = is_instructor;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int Grade) {
        this.Grade = Grade;
    }
    
    
}
