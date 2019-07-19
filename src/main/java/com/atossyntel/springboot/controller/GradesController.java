package com.atossyntel.springboot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atossyntel.springboot.model.GradeModel;
import com.atossyntel.springboot.service.GradeDAO;

@Controller
public class GradesController {
	@Autowired
	GradeDAO gradeDAO;
	
	
	@RequestMapping(value = "/Grades", method = RequestMethod.GET)
	public String init(Model model, HttpSession session) {
		//verify user is logged in
		if(session.getAttribute("username")==null) {
				return "redirect:login";
		}
		
		//if(!(Boolean) session.getAttribute("instructor")) 
		if(true){
			List<Map<String, Object>> igrades = gradeDAO.getAssignments("55556");
			model.addAttribute("grades",new GradeModel(igrades));
			
			return "Grades";
		}
		return "redirect:assignments";
	}
	@RequestMapping(value = "/Grades", method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute("grades") GradeModel grades) {
		gradeDAO.updateAssignments("55556", grades.getSubmissions());
		return "assignments";
	}
}