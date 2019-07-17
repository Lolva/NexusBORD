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
	public List<Map<String, Object>> getAssignment() {
		String sql = "SELECT ASSIGNMENT_NAME, DUE_DATE, MAX_POINTS, ATTACHED_FILES From Assignments";

		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql);
		return results;

	} 

}
