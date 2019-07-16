package com.atossyntel.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AssignmentDAOService implements AssignmentDAO {
	@Autowired
    private JdbcTemplate jTemplate;
	
	@Override
	public List<AssignmentBean> getAssignment(String id) {
		String sql = "Select assignments.assignment_name, assignments.due_date, student_submissions.submission_date from assignments \r\n" + 
				"INNER JOIN student_submissions ON student_submissions.assignment_id = assignments.ASSIGNMENT_ID WHERE student_submissions.student_id = ?";
		 
		List<AssignmentBean> results;
		 results = jTemplate.queryForList(sql, new Object[] { id }, AssignmentBean.class);
		 return results;
		
	}
	
}
