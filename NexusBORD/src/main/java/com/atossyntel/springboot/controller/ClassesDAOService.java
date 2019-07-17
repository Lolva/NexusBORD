package com.atossyntel.springboot.controller;

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
		 return results;
		
	}


	@Override
	public List<Map<String, Object>> getClasses() {
		String sql = "Select class_id From Classes";
		
		List<Map<String,Object>> results;
		results = jTemplate.queryForList(sql);
		return results;
		
	}


	@Override
	public List<Map<String, Object>> getAllStudents() {
		String sql = "Select class_id, first_name, last_name, email From Employee ORDER BY class_id";	
		List<Map<String,Object>> results;
		results = jTemplate.queryForList(sql);
		return results;
	}


	@Override
	public List<Map<String, Object>> changeClassId(String employeeId, String classId) {
		String sql = "Update Employee SET class_id = classId WHERE employee_id = empId";	
		List<Map<String,Object>> results;
		results = jTemplate.queryForList(sql);
		return results;
	}
}
