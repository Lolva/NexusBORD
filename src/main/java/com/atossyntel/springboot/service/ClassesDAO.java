package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

import java.io.IOException;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public interface ClassesDAO {
	public List<Map<String, Object>> getAllClasses();
	public List<Map<String, Object>> getActiveClasses();
	public List<Map<String, Object>> getInactiveClasses();
	public List<Map<String,Object>> getStudents(String classId);
	public List<Map<String,Object>> getAllStudents();
	public void changeClassId(String employee_id, String class_id);
	public void addClasses(String class_Id,String stream_Id, Date start_date, Date end_date);
	public void deleteEmployee(String class_Id, String employee_id);
	public void deleteClass(String class_Id);
	void addEmployees(MultipartFile file, String fileName, String class_id) throws IOException;
	public void editClass(String class_id, Date start_date, Date end_date);
	
}