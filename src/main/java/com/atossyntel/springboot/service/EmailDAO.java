package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

public interface EmailDAO {
	public String getEmailNewAssignment(String class_id);
	public String getEmailStudentSubmission(String class_id);
	public String getEmailNewGrade(String assignment_id, String employee_id);
	public String getEmailEnrollments(String employee_id, String class_id);
}
