package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class GradeDAOService implements GradeDAO{
	@Autowired
	private JdbcTemplate jTemplate;

	@Override
	public List<Map<String, Object>> getAssignments(String id) {
		String sql = "SELECT E.FIRST_NAME || ' ' || E.LAST_NAME AS STUDENT_NAME, S.SUBMISSION_DATE as SUBMISSION_DATE, S.GRADE as GRADE" +
			"FROM EMPLOYEE E, SUBMISSIONS S WHERE S.ASSIGNMENT_ID=? AND E.EMPLOYEE_ID=S.EMPLOYEE_ID";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql,id);
		for(Map map: results) {
			map.put("file_name", "Test.pdf");
		}
		return results;
	}
	
}
