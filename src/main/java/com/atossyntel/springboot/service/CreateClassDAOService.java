package com.atossyntel.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atossyntel.springboot.model.ClassBean;

@Repository
@Transactional
public class CreateClassDAOService implements CreateClassDAO {
	
	@Autowired
    private JdbcTemplate jTemplate;

	@Override
	public void addClasses(ClassBean classToBeAdded) {
		// TODO Auto-generated method stub
		
	}
	


		 
	}

