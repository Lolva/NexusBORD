package com.atossyntel.springboot.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class InstructorAssignmentsDAOService implements InstructorAssignmentsDAO {
	@Autowired
    private JdbcTemplate jTemplate;
	
	
	@Override
	public List<Map<String,Object>> getAssignment() {
		String sql = "SELECT ASSIGNMENT_NAME, DUE_DATE, MAX_POINTS, ATTACHED_FILES From Assignments";
		
		List<Map<String,Object>> results;
		results = jTemplate.queryForList(sql);
		List<StudentAssignmentsBean> list;
		for(Map<String, Object> m: results) {
			//System.out.println(m.toString());
		 }
		 return results;
		
	} /*
	public List<AssignmentBean> getAssignment(){
    List<AssignmentBean> employeeslist = jTemplate.query("SELECT * FROM assignments", new AssignmentRowMapper());
    for(AssignmentBean r: employeeslist) {
    	System.out.println(r.toString());
    }
    return employeeslist;
	}*/

	
}
