package com.atossyntel.springboot.controller;

import java.util.List;
import java.util.Map;

public interface InstructorAssignmentsDAO {
	public List<Map<String,Object>> getAssignment();
}