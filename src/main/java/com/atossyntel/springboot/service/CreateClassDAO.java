package com.atossyntel.springboot.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.atossyntel.springboot.model.ClassBean;



public interface CreateClassDAO {
	

	public void addClasses(String class_Id,String stream_Id, Date start_date, Date end_date);
		public int update(ClassBean classToBeAdded);
		public int delete(int class_Id);
		//public List<ClassBean> getClasses();
}
