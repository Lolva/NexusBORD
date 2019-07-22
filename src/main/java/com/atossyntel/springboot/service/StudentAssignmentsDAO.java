package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface StudentAssignmentsDAO {
//	public List<Map<String, Object>> getAssignment(String id);
	

	
	public void submitAssignment(String submitDate, int grade, MultipartFile file, String assignmentID, String empID);
	
	//public void submitAssignment(String assignmentID, String empID, String submitDate, int grade, MultipartFile file);
}
