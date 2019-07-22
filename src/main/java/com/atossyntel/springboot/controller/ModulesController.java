package com.atossyntel.springboot.controller;

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
		List<Map<String,Object>> classes = moduledao.getClasses(session.getAttribute("username").toString());
		model.addAttribute("classes", classes);

		int b = 1;
		for (Map<String, Object> a : classes) {
			System.out.println(moduledao.getModuleIDList(classes.get(b).toString()));
			List<Map<String,Object>> modules = moduledao.getModuleIDList(classes.toString());
			model.addAttribute("modules", modules);
			b+=1;
		}
		
		List<Map<String, Object>> assignments = moduledao.getModuleAssignments(null);
		model.addAttribute("assignments", assignments);
		List<Map<String, Object>> modulefiles = moduledao.getModuleFiles(null);
		model.addAttribute("modulefiles", modulefiles);
		return "Modules";
	}
}