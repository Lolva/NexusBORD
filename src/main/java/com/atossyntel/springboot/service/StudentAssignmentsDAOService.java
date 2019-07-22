package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.atossyntel.springboot.model.StudentAssignmentsBean;

@Service
public class StudentAssignmentsDAOService implements StudentAssignmentsDAO {
	@Autowired
	private JdbcTemplate jTemplate;

//	@Override
//	public List<Map<String, Object>> getAssignment(String id) {
//		String sql = "Select assignments.assignment_name, assignments.due_date, student_submissions.submission_date, student_submissions.attached_files from assignments "
//				+ "INNER JOIN student_submissions ON student_submissions.assignment_id = assignments.ASSIGNMENT_ID WHERE student_submissions.student_id = ?";
//
//		List<Map<String, Object>> results;
//		results = jTemplate.queryForList(sql, id);
//
//		return results;
//
//	} 
	
	
	@Override
	public void submitAssignment(String submitDate, MultipartFile file, String assignmentID, String empID) {
		
		String fullFile = file.getOriginalFilename();
        int index = fullFile.lastIndexOf(".");
        String fileName = fullFile.substring(0, index);
        String fileType = fullFile.substring(index+1, fullFile.length());
        
        String assignmentIdPlaceholder = assignmentID; // change this as needed until function can be updated to match auto-increment functionality
        
        
        String sqlQuery = "UPDATE submissions SET submission_date= TO_DATE(?,'YYYY-MM-DD'), file_name= ?, file_type= ?"
        		+ "WHERE assignment_id=? and employee_id=?"; 
        jTemplate.update(sqlQuery, submitDate, fileName, fileType, assignmentIdPlaceholder, empID);
        
        
	}


}