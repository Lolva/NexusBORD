package com.atossyntel.springboot.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atossyntel.springboot.controller.UserLoginDAO;
import com.atossyntel.springboot.controller.UserLoginServiceDAO;

@Configuration
public class GradeDAOBean  {
	
	@Bean
    public GradeDAO gradeDAO(){
        GradeDAO gradeDAO = new GradeDAOImp();
        return gradeDAO;

	}
	
	@Bean 
	public GradeBean gradeBean() {
		GradeBean gradeBean = new GradeBean();
		return gradeBean;
	}
}


