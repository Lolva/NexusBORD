package com.atossyntel.springboot.service;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

//import com.atossyntel.springboot.model.ModuleBean

public interface ModuleDAO {
	
	public List<Map<String, Object>>getModuleList(String class_id);
	public List<Map<String, Object>> getClasses(String username);
	public List<Map<String, Object>> getAssignments(String employee_id);
	public List<Map<String, Object>> getModuleFiles(String employee_id);
	public List<Map<String, Object>> getModuleName(String employee_id);
	public int insertModule(String modulename, int streamid);
	
	public int deleteModule(int module_id);
	public int deleteAssignment(int assignment_id);
	public int deleteModuleFile(int module_file_id);
	public int updateModule(String module_name, int module_id);
	public int insertModuleFile(String module_id, MultipartFile file, String name, String desc);
	public int newAssignment(String name, MultipartFile file, String dueDate, String moduleId, String classId, String desc,
			String status);
	public int editAssignmentFile(String name, MultipartFile file, String dueDate, String moduleId, String desc,
			String status, String assignment_id);
	public int editModuleFile(String module_file_id, MultipartFile file, String module_id, String name, String description);
	public Map<String, Object> getDeleteAssignment(int id);
	public Map<String, Object> getDeleteModuleFile(int id);
	
}
