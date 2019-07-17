package com.atossyntel.springboot.service;
import java.util.List;
import java.util.Map;

//import com.atossyntel.springboot.model.ModuleBean

public interface ModuleDAO {
	
	public List<Map<String, Object>>getModuleInfo(int id);
	public List<Map<String, Object>>getModuleList(String username); 
}
