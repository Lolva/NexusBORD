package com.atossyntel.springboot.controller;

import java.util.List;

public interface AssignmentDAO {
	public List<AssignmentBean> getAssignment(String id);
}
