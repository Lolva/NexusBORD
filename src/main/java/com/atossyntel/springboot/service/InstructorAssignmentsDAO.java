package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

public interface InstructorAssignmentsDAO {
	public List<Map<String, Object>> getClasses(String username);
}