package com.atossyntel.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atossyntel.springboot.model.ClassBean;



@Repository
@Transactional
public class ConfirmClassDAOService implements ConfirmClassDAO {
	@Autowired
    private JdbcTemplate jTemplate;
	
	
	private final static String INSERT_CLASS = "insert into classes (class_Id, stream_Id,start_date,end_date) values (?,?,?,?)";
	



	@Override
	public void submit(ClassBean classToBeAdded) {
		Object[] insertParams = new Object[] {classToBeAdded.getClass_Id(),classToBeAdded.getStart_date(),classToBeAdded.getEnd_date()
		 };
	jTemplate.update(INSERT_CLASS, insertParams);
		// TODO Auto-generated method stub
	
	System.out.println(insertParams);
	}
}

