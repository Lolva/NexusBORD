package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface InstructorAssignmentsDAO {
	public List<Map<String, Object>> getAssignment();
	public void setAssignment(String name, MultipartFile file, String dueDate, String moduleId, String classId, String desc, String status, String number);
	public void updateAssignment(String name, MultipartFile file, String dueDate, String moduleId, String classId, String desc, String status, String number);
	public void deleteAssignment(String number);
}