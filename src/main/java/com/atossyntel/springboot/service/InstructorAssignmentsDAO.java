package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

public interface InstructorAssignmentsDAO {
	public List<Map<String, Object>> getClasses(String username);
	public List<Map<String, Object>> getActiveAssignments(String class_id, String username);
	public List<Map<String, Object>> getOverdue(String class_id);
	public List<Map<String, Object>> getToGrade(String class_id, String username);
	public List<Map<String, Object>> overdueInstructor(String class_id);
	public List<Map<String, Object>> getStudentAssignments(String username, String class_id);
	public List<Map<String, Object>> studentGraded(String username, String class_id);
	public List<Map<String, Object>> studentTodo(String username, String class_id);
}