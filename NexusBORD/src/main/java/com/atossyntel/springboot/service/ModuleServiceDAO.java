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
	public List<Map<String, Object>> getModuleInfo(int module_id) {
		String sql = "SELECT m.module_id, a.assignment_name, a.due_date, s.submissions_date"
				+ "FROM modules m, assignments a, student_submission s"
				+ "WHERE m.? = a.? AND a.assignment_id = s.assignment_id";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, module_id);
		List<ModuleBean> list;
		for (Map<String, Object> m : results) {
			System.out.println(m.toString());
		}
		return results;
	}

	@Override
	public List<Map<String, Object>>getModuleList(String username) {
		String sql = "SELECT module_id FROM MODULES";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql);
		List<ModuleBean> list;
		for (Map<String, Object> m : results) {
			System.out.println(m.toString());
		}
		return results;
	}
	}

	
	
	
	


