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
		String sql = "SELECT e.class_id, e.role_id, s.stream_name from enrollments e, classes c, streams s WHERE e.CLASS_ID = c.CLASS_ID AND c.STREAM_ID = s.STREAM_ID AND e.employee_id = ? order by e.role_id";

		List<Map<String, Object>> results;
		
		results = jTemplate.queryForList(sql, username);
		for(Map<String, Object> r: results) {
			System.out.println(r.toString());
		}
		return results;

	}

	@Override
	public List<Map<String, Object>> getActiveAssignments(String class_id, String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT DISTINCT * FROM enrollments e, classes c, streams s, lessons l, modules m, assignments a WHERE e.CLASS_ID = c.CLASS_ID AND c.STREAM_ID = s.STREAM_ID AND l.STREAM_ID=s.STREAM_ID AND l.module_id = m.MODULE_ID AND m.MODULE_ID = a.MODULE_ID AND e.EMPLOYEE_ID = ? AND c.class_id = ? AND a.status != 'inactive' order by a.due_date, a.status";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, username, class_id);
		for(Map<String, Object> r: results) {
			System.out.println("Active Assignments " + r.toString());
		}
		return results;
		
	} 
	@Override
	public List<Map<String, Object>> getOverdue(String class_id) {
		String sql = "SELECT sub.*, a.* FROM submissions sub, assignments a, modules m, lessons l, streams str, classes c WHERE c.class_id = ? AND c.stream_id = str.stream_id AND str.stream_id = l.stream_id AND l.module_id = m.module_id AND m.module_id = a.module_id AND sub.assignment_id = a.assignment_id AND a.due_date < SYSDATE AND sub.submission_date IS NULL";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, class_id);
		for(Map<String, Object> r: results) {
			System.out.println("Overdue " + r.toString());
		}
		return results;
	}
	@Override
	public List<Map<String, Object>> getToGrade(String class_id, String username) {
		String sql = "SELECT DISTINCT * FROM assignments a, submissions s WHERE a.ASSIGNMENT_ID = s.ASSIGNMENT_ID AND a.status != 'inactive' AND s.grade IS NULL";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql);
		for(Map<String, Object> r: results) {
			System.out.println("to Grade " + r.toString());
		}
		return results;
	}

	@Override
	public List<Map<String, Object>> overdueInstructor(String class_id) {
		String SQLQuery = "SELECT sub.*, a.* FROM submissions sub, assignments a, modules m, lessons l, streams str, classes c WHERE c.class_id = ? AND c.stream_id = str.stream_id AND str.stream_id = l.stream_id AND l.module_id = m.module_id AND m.module_id = a.module_id AND sub.assignment_id = a.assignment_id AND a.due_date < SYSDATE AND sub.submission_date IS NULL";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(SQLQuery, class_id);
		for(Map<String, Object> r : results) {
			System.out.println("Submission: " + r.toString());
		}
		return results;
	}
	@Override
	public List<Map<String, Object>> getStudentAssignments(String username, String class_id){
		String sql = "SELECT DISTINCT e.employee_id, a.assignment_name, a.due_date, sub.submission_date\r\n" + 
				"FROM employees e, assignments a, submissions sub, lessons l, classes c, enrollments enr\r\n" + 
				"WHERE e.employee_id = ? AND c.class_id = ? AND a.status != 'inactive' \r\n" + 
				"    AND c.stream_id = l.stream_id AND l.module_id = a.module_id AND a.assignment_id = sub.assignment_id";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, username, class_id);
		for(Map<String, Object> r : results) {
			System.out.println("studentAssignments: " + r.toString());
		}
		return results;
	}
	
	
	@Override
	public List<Map<String, Object>> studentGraded(String username, String class_id){
		String sql = "SELECT sub.*, a.* FROM employees e, assignments a, submissions sub, lessons l, classes c, enrollments enr WHERE e.employee_id = ? AND c.class_id = ? AND a.status != 'inactive' AND sub.submission_date IS NOT NULL AND c.stream_id = l.stream_id AND l.module_id = a.module_id AND a.assignment_id = sub.assignment_id AND e.employee_id = sub.employee_id AND enr.employee_id = e.employee_id AND enr.class_id = c.class_id";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, username, class_id);
		for(Map<String, Object> r : results) {
			System.out.println("gradedStudents: " + r.toString());
		}
		return results;
	}
	@Override
	public List<Map<String, Object>> studentTodo(String username, String class_id){
		String sql = "SELECT a.*\r\n" + 
				"FROM employees e, assignments a, submissions sub, lessons l, classes c, enrollments enr\r\n" + 
				"WHERE e.employee_id = ? AND c.class_id = ? AND a.status != 'inactive' AND sub.submission_date IS NULL\r\n" + 
				"    AND c.stream_id = l.stream_id AND l.module_id = a.module_id AND a.assignment_id = sub.assignment_id AND e.employee_id = sub.employee_id AND enr.employee_id = e.employee_id AND enr.class_id = c.class_id";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, username, class_id);
		for(Map<String, Object> r : results) {
			System.out.println("todoStudents: " + r.toString());
		}
		return results;
	}

}
