package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

public interface InstructorAssignmentsDAO {
	public List<Map<String, Object>> getClasses(String username);
	public List<Map<String, Object>> getActiveAssignments(String class_id, String username);
	public List<Map<String, Object>> getOverdue(String class_id, String username);
}