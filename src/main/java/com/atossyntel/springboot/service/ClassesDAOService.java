package com.atossyntel.springboot.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ClassesDAOService implements ClassesDAO {
	@Autowired
    private JdbcTemplate jTemplate;
	
	
	@Override
	public List<Map<String,Object>> getStudents(String classId) {
		String sql = "Select first_name, last_name, email From Employee WHERE class_ID = ?";
		
		List<Map<String,Object>> results;
		results = jTemplate.queryForList(sql, classId);
//		for(Map<String, Object> m: results) {
//			System.out.println(m.toString());
//		 }
		 return results;
		
	}


	@Override
	public List<Map<String, Object>> getClasses() {
		String sql = "Select class_id From Classes";
		
		List<Map<String,Object>> results;
		results = jTemplate.queryForList(sql);
		return results;
		
	}
}
