package com.atossyntel.springboot.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atossyntel.springboot.service.UserLoginDAO;
import com.atossyntel.springboot.service.UserLoginServiceDAO;

@Configuration
public class DAOBean {
	@Bean
	public UserLoginDAO dao() {
		UserLoginDAO dao = new UserLoginServiceDAO();
		return dao;
	}
}