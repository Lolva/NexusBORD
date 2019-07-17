package com.atossyntel.springboot.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atossyntel.springboot.model.StudentAssignmentsBean;

@Repository
@Transactional
public class StudentAssignmentsDAOService implements StudentAssignmentsDAO {
	@Autowired
	private JdbcTemplate jTemplate;

	@Override
	public List<Map<String, Object>> getAssignment(String id) {
		String sql = "Select assignments.assignment_name, assignments.due_date, student_submissions.submission_date from assignments \r\n"
				+ "INNER JOIN student_submissions ON student_submissions.assignment_id = assignments.ASSIGNMENT_ID WHERE student_submissions.student_id = ?";

		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, id);
		List<StudentAssignmentsBean> list;
		for (Map<String, Object> m : results) {
			System.out.println(m.toString());
		}
		return results;

	} /*
		 * public List<AssignmentBean> getAssignment(){ List<AssignmentBean>
		 * employeeslist = jTemplate.query("SELECT * FROM assignments", new
		 * AssignmentRowMapper()); for(AssignmentBean r: employeeslist) {
		 * System.out.println(r.toString()); } return employeeslist; }
		 */

}
