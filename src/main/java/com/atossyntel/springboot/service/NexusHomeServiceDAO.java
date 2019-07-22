package com.atossyntel.springboot.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;

public class NexusHomeServiceDAO implements NexusHomeDAO {
	@Autowired
	private JdbcTemplate jTemplate;
	
	@Override
	public List<Map<String, Object>> overdueAssignments(String employeeId) {
		List<Map<String, Object>> results;
		String SQLQuery = "SELECT DISTINCT str.stream_name, a.assignment_name, a.description, a.due_date "+ 
							"FROM employees e, assignments a, submissions sub, lessons l, classes c, enrollments enr, streams str "+ 
							"WHERE e.employee_id = ? AND SYSDATE >= a.due_date AND a.status = 'active' "+ 
								"AND e.employee_id = enr.employee_id AND enr.class_id = c.class_id "+ 
								"AND c.stream_id = l.stream_id AND str.stream_id = l.stream_id "+ 
								"AND l.module_id = a.module_id AND a.assignment_id = sub.assignment_id "+ 
								"AND sub.submission_date IS NULL";
		
		results = jTemplate.queryForList(SQLQuery, employeeId);
		
		return results;
	}

	@Override
	public List<Map<String, Object>> toDoAssignments(String employeeId) {
		List<Map<String, Object>> results;
		String SQLQuery = "SELECT DISTINCT str.stream_name, a.assignment_name, a.description, a.due_date " + 
				"FROM employees e, assignments a, submissions sub, lessons l, classes c, enrollments enr, streams str " + 
				"WHERE e.employee_id = ? AND SYSDATE < a.due_date AND a.status = 'active' " + 
					"AND e.employee_id = enr.employee_id AND enr.class_id    = c.class_id "        + 
					"AND c.stream_id   = l.stream_id     AND str.stream_id   = l.stream_id "       + 
					"AND l.module_id   = a.module_id     AND a.assignment_id = sub.assignment_id " + 
					"AND sub.submission_date IS NULL";

		results = jTemplate.queryForList(SQLQuery, employeeId);

		return results;
	}

	@Override
	public List<Map<String, Object>> changelog(String employeeId) {
		List<Map<String, Object>> results;
		String SQLQuery = "SELECT DISTINCT str.stream_name, a.assignment_name, a.description, a.due_date " + 
				"FROM employees e, assignments a, submissions sub, lessons l, classes c, enrollments enr, streams str " + 
				"WHERE e.employee_id = ? AND a.status = 'active' " + 
					"AND e.employee_id = enr.employee_id AND enr.class_id    = c.class_id "        + 
					"AND c.stream_id   = l.stream_id     AND str.stream_id   = l.stream_id "       + 
					"AND l.module_id   = a.module_id     AND a.assignment_id = sub.assignment_id " + 
					"AND sub.submission_date IS NULL " +
					"ORDER BY a.due_date DESC";

		results = jTemplate.queryForList(SQLQuery, employeeId);

		return results;
	}
}