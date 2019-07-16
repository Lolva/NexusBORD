package com.atossyntel.springboot.controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAOBean {
    @Bean
    public UserLoginDAO dao(){
        UserLoginDAO dao = new UserLoginServiceDAO();
        return dao;
    }
    @Bean
    public AssignmentDAO assigndao() {
    	AssignmentDAO dao = new AssignmentDAOService();
		return dao;
    	
    }
}