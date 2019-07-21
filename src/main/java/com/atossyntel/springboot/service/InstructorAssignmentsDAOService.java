package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
public class InstructorAssignmentsDAOService implements InstructorAssignmentsDAO {
	@Autowired
	private JdbcTemplate jTemplate;
	
	@Override
	public List<Map<String, Object>> getAssignment() {
		String sql = "SELECT ASSIGNMENT_NAME, DUE_DATE, MAX_POINTS, ATTACHED_FILES From Assignments";

		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql);
		return results;
	} 
	
	@Override
    public void setAssignment(String name, MultipartFile file, String dueDate, String moduleId, String classId, String desc, String status, String number) {
        String fullFile = file.getOriginalFilename();
        int index = fullFile.lastIndexOf(".");
        String fileName = fullFile.substring(0, index);
        String fileType = fullFile.substring(index+1, fullFile.length());
        
        String assignmentIdPlaceholder = number; // change this as needed until function can be updated to match auto-increment funtionality
        
        String sqlQuery = "INSERT INTO assignments(assignment_id, assignment_name, module_id, "
                + "description, due_date, status, file_name, file_type) "
                + "VALUES(?,?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?,?)";
        jTemplate.update(sqlQuery, assignmentIdPlaceholder, name, moduleId, desc, dueDate, status, fileName, fileType);
    } 

}
