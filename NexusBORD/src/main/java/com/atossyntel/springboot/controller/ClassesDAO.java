package com.atossyntel.springboot.controller;

import java.util.List;
import java.util.Map;

public interface ClassesDAO {
	public List<Map<String,Object>> getStudents(String classId);
}
