package com.atossyntel.springboot.controller;

import java.util.List;
import java.util.Map;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atossyntel.springboot.service.ModuleDAO;


@Controller
public class ModulesController {
	
	@Autowired
	ModuleDAO moduledao;

	@RequestMapping(value = "/Modules", method = RequestMethod.GET)
	public String init(Model model, HttpSession session) {
		if(session.getAttribute("username")!=null) {
		
		//user is a student
		if(!(Boolean) session.getAttribute("instructor")) {
	
			List<Map<String, Object>> assignments = moduledao.getModuleInfo();

			model.addAttribute("assignments", assignments);
			List<Map<String, Object>> moduleIds = moduledao.getModuleList();
	
			model.addAttribute("moduleIds", moduleIds);
		    return "Modules";
		  }
		}
		return "redirect:login";
	}
}