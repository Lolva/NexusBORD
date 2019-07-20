package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

import com.atossyntel.springboot.model.GradeBean;

public interface GradeDAO {
	
	public List<GradeBean> getAssignments(String id);
	public Boolean updateAssignments(String id, List<GradeBean> grades);
}
