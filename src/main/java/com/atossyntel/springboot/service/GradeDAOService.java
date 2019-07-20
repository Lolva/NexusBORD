package com.atossyntel.springboot.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.atossyntel.springboot.model.GradeBean;
@Service
public class GradeDAOService implements GradeDAO{
	@Autowired
	private JdbcTemplate jTemplate;

	@Override
	public List<GradeBean> getAssignments(String id) {
		String sql = "SELECT E.FIRST_NAME || ' ' || E.LAST_NAME AS student_name, S.SUBMISSION_DATE as submission_date, S.GRADE as grade, S.EMPLOYEE_ID as EMPLOYEE_ID " +
			"FROM EMPLOYEES E, SUBMISSIONS S WHERE S.ASSIGNMENT_ID=? AND E.EMPLOYEE_ID=S.EMPLOYEE_ID";
		List<Map<String, Object>> results = jTemplate.queryForList(sql,id);
		List<GradeBean> transformedResults = new ArrayList<GradeBean>();
		for(Map<String,Object> map: results) {
			map.put("file_name", "Test.pdf");
		}
		Iterator mapIterator = results.iterator();
		while(mapIterator.hasNext()) {
			@SuppressWarnings("unchecked")
			Map<String,Object> map =(Map<String,Object>) mapIterator.next();
			GradeBean newGrade = new GradeBean();
			newGrade.setStudentName((String) map.get("student_name"));
			newGrade.setSubmission_date((Timestamp) map.get("submission_date"));
			newGrade.setGrade((BigDecimal) map.get("grade"));
			newGrade.setFile_name((String) map.get("file_name"));
			newGrade.setEmployee_id((String) map.get("employee_id"));
			transformedResults.add(newGrade);
		}
		return transformedResults;
	}

	@Override
	public Boolean updateAssignments(String id,List<GradeBean>grades) {
		String sql="UPDATE SUBMISSIONS SET GRADE=? WHERE EMPLOYEE_ID=? AND ASSIGNMENT_ID=?";
		try {
			for(GradeBean row:grades) {
				jTemplate.update(sql,row.getGrade(),row.getEmployee_id(),id);
			}
		}catch(DataAccessException e) {
			return false;
		}
		return true;
	}
	
}
