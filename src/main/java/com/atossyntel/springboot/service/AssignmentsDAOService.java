package com.atossyntel.springboot.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
public class AssignmentsDAOService implements AssignmentsDAO {
	@Autowired
	private JdbcTemplate jTemplate;
	
	@Override
	public List<Map<String, Object>> getClasses(String username) {
		String sql = "SELECT e.class_id, e.role_id, s.stream_name, s.stream_id from enrollments e, classes c, streams s WHERE e.CLASS_ID = c.CLASS_ID AND c.STREAM_ID = s.STREAM_ID AND e.employee_id = ? order by e.role_id";

		List<Map<String, Object>> results;
		
		results = jTemplate.queryForList(sql, username);
		for(Map<String, Object> r: results) {
			System.out.println(r.toString());
		}
		return results;
	} 
	
	@Override
    public void setAssignment(String name, MultipartFile file, String dueDate, String moduleId, String classId, String desc, String status) {
		String fileName = null;
		String fileType = null;
		if(!file.isEmpty()) {
			
			String fullFile = file.getOriginalFilename();
	        int index = fullFile.lastIndexOf(".");
	        fileName = fullFile.substring(0, index);
	        fileType = fullFile.substring(index+1, fullFile.length());
        
        
        //String assignmentIdPlaceholder = number; // change this as needed until function can be updated to match auto-increment funtionality
        
        String sqlQuery = "INSERT INTO assignments(assignment_name, module_id, "
                + "description, due_date, status, file_name, file_type) "
                + "VALUES(?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?,?)";
        jTemplate.update(sqlQuery, name, moduleId, desc, dueDate, status, fileName, fileType);
		} else {
			System.out.println("file is empty help");
			String sqlQuery = "INSERT INTO assignments(assignment_name, module_id, "
	                + "description, due_date, status) "
	                + "VALUES(?,?,?,TO_DATE(?,'YYYY-MM-DD'),?)";
	        jTemplate.update(sqlQuery, name, moduleId, desc, dueDate, status);
		}
    } 

	@Override
	public List<Map<String, Object>> getActiveAssignments(String stream_id, String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT * from assignments a, lessons l, modules m WHERE l.module_id = m.module_id AND a.module_id = m.module_id AND l.STREAM_ID= ? AND a.status != 'inactive' order by a.due_date, a.status";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, stream_id);
		for(Map<String, Object> r: results) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
			String strDate = dateFormat.format(r.get("due_date"));
			r.put("formattedDate", strDate);
			System.out.println(strDate);
		}
		return results;
		
	} 

	@Override
	public List<Map<String, Object>> getToGrade(String stream_id, String username) {
		String sql = "SELECT * from employees e, submissions so, assignments a, lessons l, modules m WHERE l.module_id = m.module_id AND a.module_id = m.module_id AND a.ASSIGNMENT_ID = so.ASSIGNMENT_ID AND e.EMPLOYEE_ID = so.EMPLOYEE_ID AND l.STREAM_ID= ? AND so.grade IS NULL";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, stream_id);
		for(Map<String, Object> r: results) {
			System.out.println("to Grade " + r.toString());
		}
		return results;
	}

	@Override
	public List<Map<String, Object>> overdueInstructor(String stream_id) {
		String SQLQuery = "SELECT * from employees e, submissions so, assignments a, lessons l, modules m WHERE l.module_id = m.module_id AND a.module_id = m.module_id AND a.ASSIGNMENT_ID = so.ASSIGNMENT_ID AND e.EMPLOYEE_ID = so.EMPLOYEE_ID AND l.STREAM_ID= ? AND a.due_date < SYSDATE AND so.submission_date IS NULL";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(SQLQuery, stream_id);
		for(Map<String, Object> r : results) {
			System.out.println("Submission: " + r.toString());
		}
		return results;
	}
	@Override
	public List<Map<String, Object>> getStudentAssignments(String username, String class_id){
		String sql = "SELECT DISTINCT e.employee_id, a.assignment_name, a.due_date, sub.submission_date, c.class_id, a.description, a.file_name, a.file_type, a.assignment_id\r\n" + 
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
	
	@Override
	public int updateGrade(String username, String assignmentId, int grade){
		String sql = "UPDATE SUBMISSIONS SET GRADE=? WHERE EMPLOYEE_ID=? AND ASSIGNMENT_ID=?";
		
		return jTemplate.update(sql, grade, username, assignmentId);
	}
	
	// Does not change Assignment ID
	@Override
    public void updateAssignment(String name, MultipartFile file, String dueDate, String moduleId, String classId, String desc, String status, String number) {
        String fileName = null;
        String fileType = null;
		if(file != null && file.getOriginalFilename() !="" && file.getOriginalFilename() != null && file.getOriginalFilename().contains(".")) {
			String fullFile = file.getOriginalFilename();
	        int index = fullFile.lastIndexOf(".");
	        fileName = fullFile.substring(0, index);
	        fileType = fullFile.substring(index+1, fullFile.length());
        }
        
        String assignmentIdPlaceholder = number; // change this as needed until function can be updated to match auto-increment funtionality
        
        String sqlQuery = "UPDATE assignments SET assignment_name = ?, module_id = ?, "
                + "description = ?, due_date = TO_DATE(?,'YYYY-MM-DD'), status = ?, file_name = ?, file_type = ? "
        		+ "WHERE assignment_id = ?";
        jTemplate.update(sqlQuery, name, moduleId, desc, dueDate, status, fileName, fileType, assignmentIdPlaceholder);
    } 

	
	@Override
    public void deleteAssignment(String number) {
        //String fullFile = file.getOriginalFilename();
        //int index = fullFile.lastIndexOf(".");
        //String fileName = fullFile.substring(0, index);
        //String fileType = fullFile.substring(index+1, fullFile.length());
        
        String assignmentIdPlaceholder = number; // change this as needed until function can be updated to match auto-increment funtionality
        String sqlQuery1 = "DELETE FROM SUBMISSIONS WHERE ASSIGNMENT_ID=?";
        String sqlQuery2 = "DELETE FROM assignments WHERE assignment_id =?";
        jTemplate.update(sqlQuery1,assignmentIdPlaceholder);
        jTemplate.update(sqlQuery2, assignmentIdPlaceholder);
    }

	@Override
	public List<Map<String, Object>> getAssignment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getModules(String username){
		String sql = "SELECT DISTINCT m.MODULE_name, m.module_id From modules m, classes c, lessons l, enrollments e WHERE e.class_id=c.class_id AND c.STREAM_ID=l.STREAM_ID AND m.MODULE_ID=l.MODULE_ID AND e.EMPLOYEE_ID = ? AND e.role_id = 1";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, username);
		return results;
	}
}
