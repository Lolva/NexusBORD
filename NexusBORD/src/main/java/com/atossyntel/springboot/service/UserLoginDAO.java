package com.atossyntel.springboot.service;

import com.atossyntel.springboot.model.UserLogin;

public interface UserLoginDAO {
	public boolean checkPassword(UserLogin e);
}