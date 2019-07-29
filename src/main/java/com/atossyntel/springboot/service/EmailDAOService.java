package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmailDAOService implements EmailDAO {
	@Autowired
	private JdbcTemplate jTemplate;
	
	@Override
	public String getEmailNewAssignment(String class_id) {
		String sql = "SELECT email \r\n" + 
				"FROM employees\r\n" + 
				"INNER JOIN enrollments ON employees.employee_id = enrollments.employee_id\r\n" + 
				"WHERE enrollments.role_id = 2 \r\n" + 
				"	AND class_id = ?";

		List<Map<String, Object>> results;
		String concat = null;
		results = jTemplate.queryForList(sql, class_id);
		for(Map<String, Object> r: results) {
			System.out.println(r.toString());
			concat = concat + r.toString() + ",";
		}
		concat = concat.replaceAll("null","");
		concat = concat.replaceAll("\\{EMAIL=", "");
		concat = concat.replaceAll("\\}", "");
		concat = concat.substring(0, concat.length() - 1);

		/*
		// TESTING PURPOSES ONLY
		concat = concat.replaceAll("domgianatassio@gmail.com", "jacob-gp@hotmail.com");
		concat = concat.replaceAll("Hunter_Klieber@syntelinc.com", "umezaki.tatsuya@gmail.com");
		concat = concat.replace("Spencer_Bacon@syntelinc.com", "alfabenojar@yahoo.com");
		*/
		
		System.out.println(concat);
		return concat;
	}

	//Untested as of 21 JUL 2019
	@Override
	public String getEmailStudentSubmission(String class_id) {
		String sql = "SELECT email \r\n" + 
				"FROM employees\r\n" + 
				"INNER JOIN enrollments ON employees.employee_id = enrollments.employee_id\r\n" + 
				"WHERE enrollments.role_id = 1 \r\n" + 
				"	AND class_id = ?";

		List<Map<String, Object>> results;
		String concat = null;
		results = jTemplate.queryForList(sql, class_id);
		for(Map<String, Object> r: results) {
			System.out.println(r.toString());
			concat = concat + r.toString() + ",";
		}
		concat = concat.replaceAll("null","");
		concat = concat.replaceAll("\\{EMAIL=", "");
		concat = concat.replaceAll("\\}", "");
		concat = concat.substring(0, concat.length() - 1);
		System.out.println(concat);
		return concat;	}

	//Untested as of 21 JUL 2019
	@Override
	public String getEmailNewGrade(String assignment_id, String employee_id) {
		String sql = "SELECT email \r\n" + 
				"FROM employees\r\n" + 
				"INNER JOIN enrollments ON employees.employee_id = enrollments.employee_id\r\n" + 
				"INNER JOIN submissions ON employees.employee_id = submissions.employee_id\r\n" +
				"WHERE enrollments.role_id = 2 \r\n" + 
				"	AND assignment_id = ?" +
				"	AND employees.employee_id = ?";


		List<Map<String, Object>> results;
		String concat = null;
		results = jTemplate.queryForList(sql, assignment_id, employee_id);
		for(Map<String, Object> r: results) {
			System.out.println(r.toString());
			concat = concat + r.toString() + ",";
		}
		concat = concat.replaceAll("null","");
		concat = concat.replaceAll("\\{EMAIL=", "");
		concat = concat.replaceAll("\\}", "");
		concat = concat.substring(0, concat.length() - 1);
		
		System.out.println(concat);
		return concat;}
	
	
	@Override
	public String getEmailEnrollments(String employee_id, String class_id) {
		String sql = "SELECT email \r\n" + 
				"FROM employees\r\n" + 
				"INNER JOIN enrollments ON employees.employee_id = enrollments.employee_id\r\n" + 
				"WHERE enrollments.role_id = 2 \r\n" + 
				"	AND employees.employee_id = ?" +
				"	AND class_id = ?";


		List<Map<String, Object>> results;
		String concat = null;
		results = jTemplate.queryForList(sql, employee_id, class_id);
		for(Map<String, Object> r: results) {
			System.out.println(r.toString());
			concat = concat + r.toString() + ",";
		}
		concat = concat.replaceAll("null","");
		concat = concat.replaceAll("\\{EMAIL=", "");
		concat = concat.replaceAll("\\}", "");
		concat = concat.substring(0, concat.length() - 1);
		
		System.out.println(concat);
		return concat;
	}
	
	@Override
	public String getEmailEmpName(String empId) {
		String select = "select first_name from employees where employee_id=?";
		String fname;
		fname = jTemplate.queryForObject(select, String.class, empId);
		
		System.out.println(fname);
		
		String select2 = "select last_name from employees where employee_id=?";
		String lname;
		lname = jTemplate.queryForObject(select2, String.class, empId);	
		
		return fname + " " + lname;
		
	}
	
	@Override
	public String getEmailClassName(String classId) {
		String select = "SELECT DISTINCT s.stream_name From modules m, classes c, streams s, lessons l, enrollments e WHERE e.class_id=c.class_id AND c.STREAM_ID=s.STREAM_ID AND s.stream_id=l.stream_id AND m.MODULE_ID=l.MODULE_ID  and c.class_id =?";
		String cname;
		cname = jTemplate.queryForObject(select, String.class, classId);
		
		return cname;
	}
	
	@Override
	public String getEmailAssignName(String assignID) {
		String select = "select first_name from employees where employee_id=?";
		String aname;
		aname = jTemplate.queryForObject(select, String.class, assignID);
		
		return aname;
	}
}
