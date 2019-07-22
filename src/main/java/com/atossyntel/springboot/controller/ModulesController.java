package com.atossyntel.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atossyntel.springboot.service.ModuleDAO;

@Controller
public class ModulesController {

	@Autowired
	ModuleDAO moduledao;

	@RequestMapping(value = "/Modules", method = RequestMethod.GET)
	public String init(Model model, HttpSession session) {
		List<Map<String, Object>> classes = moduledao.getClasses(session.getAttribute("username").toString());

		model.addAttribute("classes", classes);
		Map<String, Object> mom = new HashMap<String, Object>();
		for (Map<String, Object> m : classes) {
			String classid =m.get("class_id").toString();
			List<List<Map<String, Object>>> modules = new ArrayList<List<Map<String, Object>>>();
			//List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
			modules.add(moduledao.getModuleList(m.get("class_id").toString()));
			Map<String, Object> modulemap = new HashMap<String, Object>();
			for(List<Map<String,Object>> a : modules) {
				
				//List<List<List<Map<String, Object>>>> assigns= new ArrayList<List<List<Map<String,Object>>>>();
				List<List<Map<String, Object>>> assigns = new ArrayList<List<Map<String, Object>>>();
				for(Map<String, Object> z: a) {
					String moduleid = z.get("module_id").toString();
					assigns.add(moduledao.getAssignments(moduleid));
					modulemap.put(moduleid, assigns);
				}
			}
			mom.put(classid, modulemap);
		}
		
		
		
		System.out.println(mom.toString());
		
		model.addAttribute("modules", mom);
		return "Modules";
	}
}