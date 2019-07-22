package com.atossyntel.springboot.service;
import java.util.List;
import java.util.Map;


public interface ModuleDAO {
	
	public List<Map<String, Object>> getModuleList(String class_id);
	public List<Map<String, Object>> getModuleAssignments(String module_id);
	public List<Map<String, Object>> getModuleFiles(String module_id);
	public List<Map<String, Object>> getClasses(String string);
	public List<Map<String, Object>> getModuleIDList(String class_id); 
}
