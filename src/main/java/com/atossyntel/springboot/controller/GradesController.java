package com.atossyntel.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.atossyntel.springboot.model.GradeBean;
import com.atossyntel.springboot.model.GradeModel;
import com.atossyntel.springboot.service.GradeDAO;

@Controller
@SessionAttributes("finishedGrades")
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
			List<GradeBean> igrades = gradeDAO.getAssignments("55556");
			model.addAttribute("grades",new GradeModel(igrades));
			List<GradeBean> ngrades= new ArrayList<GradeBean>(igrades);
			model.addAttribute("finishedGrades",new GradeModel(ngrades));
			
			return "Grades";
		}
		return "redirect:assignments";
	}
	@RequestMapping(value = "/Grades", method = RequestMethod.POST)
	public String submit(@ModelAttribute("grades") GradeModel grades, SessionStatus sessionStatus) {
		System.out.println(grades.getSubmissions());
		gradeDAO.updateAssignments("55556", grades.getSubmissions());
		sessionStatus.setComplete();
		return "redirect:login";
	}
}