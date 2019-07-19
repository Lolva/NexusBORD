package com.atossyntel.springboot.service;

import org.springframework.stereotype.Service;

import com.atossyntel.springboot.model.ClassBean;



public interface CreateClassDAO {
	

		void addClasses(ClassBean classToBeAdded);
}
