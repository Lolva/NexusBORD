
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

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "UserLogin{" + "username=" + username + ", password=" + password + '}';
    }
    
}
