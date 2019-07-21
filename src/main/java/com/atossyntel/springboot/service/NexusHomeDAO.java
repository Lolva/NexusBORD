package com.atossyntel.springboot.service;
import java.util.List;
import java.util.Map;

public interface NexusHomeDAO {
	public List<Map<String, Object>> overdueAssignments(String employee_id);
	public List<Map<String, Object>> toDoAssignments(String employee_id);
	public List<Map<String, Object>> changelog(String employee_id);
}