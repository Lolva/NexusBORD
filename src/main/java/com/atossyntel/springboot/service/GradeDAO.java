package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

public interface GradeDAO {
	public List<Map<String, Object>> getAssignments(String id);
}
