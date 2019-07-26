package com.atossyntel.springboot.service;
import java.util.List;
import java.util.Map;

//import com.atossyntel.springboot.model.ModuleBean

public interface ModuleDAO {
	
	public List<Map<String, Object>>getModuleList(String class_id);
	public List<Map<String, Object>> getClasses(String username);
	public List<Map<String, Object>> getAssignments(String employee_id);
	public List<Map<String, Object>> getModuleFiles(String employee_id);
	public List<Map<String, Object>> getModuleName(String employee_id);
	public int insertModule(String modulename); 
}
