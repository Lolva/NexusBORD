package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class GradeDAOService implements GradeDAO{
	@Autowired
	private JdbcTemplate jTemplate;
	private List<Map<String, Object>> results = null;

	@Override
	public List<Map<String, Object>> getAssignments(String id) {
		String sql = "SELECT E.FIRST_NAME || ' ' || E.LAST_NAME AS student_name, S.SUBMISSION_DATE as submission_date, S.GRADE as grade, S.EMPLOYEE_ID as EMPLOYEE_ID " +
			"FROM EMPLOYEES E, SUBMISSIONS S WHERE S.ASSIGNMENT_ID=? AND E.EMPLOYEE_ID=S.EMPLOYEE_ID";
		results = jTemplate.queryForList(sql,id);
		for(Map<String,Object> map: results) {
			map.put("file_name", "Test.pdf");
		}
		return results;
	}

	@Override
	public Boolean updateAssignments(String id,List<Map<String, Object>>grades) {
		String sql="UPDATE SUBMISSIONS SET GRADE=? WHERE EMPLOYEE_ID=? AND ASSIGNMENT_ID=?";
		try {
			for(Map<String,Object> row:grades) {
				jTemplate.update(sql,row.get("grade"),row.get("employee_id"),id);
			}
		}catch(DataAccessException e) {
			return false;
		}
		return true;
	}
	
}
