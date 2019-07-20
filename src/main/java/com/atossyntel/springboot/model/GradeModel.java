package com.atossyntel.springboot.model;

import java.util.List;
import java.util.Map;

public class GradeModel {
	List<GradeBean> submissions;
	
	

	public GradeModel() {
		super();
		this.submissions = null;
	}

	public GradeModel(List<GradeBean> submissions) {
		super();
		this.submissions = submissions;
	}

	public List<GradeBean> getSubmissions() {
		return submissions;
	}

	public void setSubmissions(List<GradeBean> submissions) {
		this.submissions = submissions;
	}
	
}
