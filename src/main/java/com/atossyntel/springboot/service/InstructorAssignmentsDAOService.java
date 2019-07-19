package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class InstructorAssignmentsDAOService implements InstructorAssignmentsDAO {
	@Autowired
	private JdbcTemplate jTemplate;

	@Override
	public List<Map<String, Object>> getClasses(String username) {
		String sql = "SELECT e.class_id, e.role_id, s.stream_name from enrollments e, classes c, streams s WHERE e.CLASS_ID = c.CLASS_ID AND c.STREAM_ID = s.STREAM_ID AND e.employee_id = ? order by e.role_id DESC";

		List<Map<String, Object>> results;
		
		results = jTemplate.queryForList(sql, username);
		for(Map<String, Object> r: results) {
			System.out.println(r.toString());
		}
		return results;

	} 

}
