package com.atossyntel.springboot.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atossyntel.springboot.service.LoginDAO;
import com.atossyntel.springboot.service.LoginDAOService;

@Configuration
public class DAOBean {
	@Bean
	public LoginDAO dao() {
		LoginDAO dao = new LoginDAOService();
		return dao;
	}
}