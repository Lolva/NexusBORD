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
	public List<Map<String, Object>> getClasses(String username) {
		String sql = "SELECT e.class_id, e.role_id, s.stream_name, s.stream_id from enrollments e, classes c, streams s WHERE e.CLASS_ID = c.CLASS_ID AND c.STREAM_ID = s.STREAM_ID AND e.employee_id = ? order by e.role_id ";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, username);
	
		return results;
	}

	@Override
	public List<Map<String, Object>>getAssignments(String module_id) {
		String sql = "SELECT * FROM assignments WHERE assignments.module_id= ?";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, module_id);
		return results;
	}
	@Override
	public List<Map<String, Object>>getModuleList(String class_id) {
		String sql = "SELECT * From modules m, classes c, streams s, lessons l WHERE c.STREAM_ID=s.STREAM_ID AND l.STREAM_ID=s.STREAM_ID AND m.MODULE_ID=l.MODULE_ID AND c.class_id= ?";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, class_id);
		return results;
	}
	@Override
	public List<Map<String, Object>>getModuleFiles(String module_id) {
		String sql = "SELECT * FROM module_files WHERE MODULE_ID = ?";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, module_id);
		return results;
	}
	
	@Override
	public List<Map<String, Object>>getModuleName(String module_id) {
		String sql = "Select module_name from modules where module_id =?";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, module_id);
		return results;
	}
	}

	
	
	
	

