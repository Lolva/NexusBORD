package com.atossyntel.springboot.controller;

public interface UserLoginDAO {
    public boolean checkPassword(UserLogin e);
    public boolean isInstructor(UserLogin e);
}