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
	public List<Map<String, Object>>getModuleList(String class_id) {
		String sql = "SELECT m.MODULE_ID, m.MODULE_NAME From modules m, classes c, streams s, lessons l WHERE c.STREAM_ID=s.STREAM_ID AND l.STREAM_ID=s.STREAM_ID AND m.MODULE_ID=l.MODULE_ID AND c.class_id= ?";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, class_id);
		return results;
	}
	
	@Override
	public List<Map<String, Object>>getModuleIDList(String class_id) {
		String sql = "SELECT m.module_id FROM classes c, streams s, lessons l, modules m, assignments a WHERE c.STREAM_ID = s.STREAM_ID AND s.STREAM_ID =l.STREAM_ID AND m.MODULE_ID = l.MODULE_ID AND l.MODULE_ID = a.MODULE_ID AND c.class_id = ?";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, class_id);
		return results;
	}
	
	@Override
	public List<Map<String, Object>> getModuleAssignments(String module_id) {
		String sql = "SELECT * FROM assignments WHERE module_id= ?";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, module_id);
		return results;
	}

	@Override
	public List<Map<String, Object>> getModuleFiles(String module_id) {
		String sql = "SELECT * FROM module_files WHERE module_id= ?";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, module_id);
		return results;
	}
	}

	
	
	
	


