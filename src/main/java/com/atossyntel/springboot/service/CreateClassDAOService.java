package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
@Transactional
public class CreateClassDAOService implements CreateClassDAO {
	@Autowired
    private JdbcTemplate jTemplate;
	
	public void addClass(String class_Id, String course_Id, String capacity) {
			System.out.println(class_Id+ " " + course_Id + " " + capacity);
		  String SQLQuery = "INSERT INTO Classes(class_Id,course_Id,capacity) VALUES(?,?,?)";
	      
	      this.jTemplate.update(SQLQuery, class_Id,course_Id,capacity);
		  
	    }
	
}

