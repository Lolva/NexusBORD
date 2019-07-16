package com.atossyntel.springboot.controller;

import java.util.List;
import java.util.Map;

public interface StudentAssignmentsDAO {
	public List<Map<String,Object>> getAssignment(String id);
}
