package com.atossyntel.springboot.model;

import java.util.List;
import java.util.Map;

public class GradeModel {
	List<Map<String, Object>> submissions;
	

	public GradeModel() {
		super();
		this.submissions = null;
	}

	public GradeModel(List<Map<String, Object>> submissions) {
		super();
		this.submissions = submissions;
	}

	public List<Map<String, Object>> getSubmissions() {
		return submissions;
	}

	public void setSubmissions(List<Map<String, Object>> submissions) {
		this.submissions = submissions;
	}
	
}
