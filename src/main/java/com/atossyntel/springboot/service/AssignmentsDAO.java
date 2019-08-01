package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface AssignmentsDAO {
	// READ
	public List<Map<String, Object>> getAssignment();
	// CREATE
	public void setAssignment(String name, MultipartFile file, String dueDate, String moduleId, String classId, String desc, String status);
	// UPDATE
	public void updateAssignment(String name, MultipartFile file, String dueDate, String moduleId, String classId, String desc, String status, String number);
	// DELETE
	public void deleteAssignment(String number);

	public List<Map<String, Object>> getClasses(String username);
	public List<Map<String, Object>> getActiveAssignments(String stream_id, String username);
	public List<Map<String, Object>> getToGrade(String stream_id, String username);
	public List<Map<String, Object>> overdueInstructor(String stream_id);
	public List<Map<String, Object>> getStudentAssignments(String username, String class_id);
	public List<Map<String, Object>> studentGraded(String username, String class_id);
	public List<Map<String, Object>> studentTodo(String username, String class_id);
	public int updateGrade(String username, String assignmentId, int grade);
	public List<Map<String, Object>> getModules(String username);
}