package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atossyntel.springboot.model.ModuleBean;



@Repository
@Transactional
public class ModuleServiceDAO implements ModuleDAO {
	
	@Autowired
	private JdbcTemplate jTemplate;

	@Override
	public List<Map<String, Object>> getModuleInfo() {
		String sql = "SELECT DISTINCT a.assignment_name, a.due_date, s.submission_date, a.module_id FROM assignments a LEFT JOIN student_submissions s ON a.ASSIGNMENT_ID =s.ASSIGNMENT_ID";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql);
	
		return results;
	}

	@Override
	public List<Map<String, Object>>getModuleList() {
		String sql = "SELECT module_id FROM modules";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql);
		return results;
	}
	}

	
	
	
	


