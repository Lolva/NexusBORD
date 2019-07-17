package com.atossyntel.springboot.service;

import com.atossyntel.springboot.model.UserLogin;

public interface LoginDAO {
	public boolean checkPassword(UserLogin e);
	public boolean isInstructor(UserLogin e);
}