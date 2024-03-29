package com.atossyntel.springboot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atossyntel.springboot.service.StudentAssignmentsDAO;

@Controller
public class StudentAssignmentsController {
	@Autowired
	StudentAssignmentsDAO assigndao;

	@GetMapping(value = "/StudentAssignments")
	public String init(Model model, HttpSession session) {
		//verify user is logged in
		if(session.getAttribute("username")==null) {
			return "redirect:login";
		}
		//user is a student
		if(!(Boolean) session.getAttribute("instructor")) {
			//List<Map<String, Object>> sassigns = assigndao.getAssignment(session.getAttribute("username").toString());
			//model.addAttribute("sassigns", sassigns);
			
			return "StudentAssignments";
		}
		//user is not a student redirect 
		return "redirect:assignemts";
	}
}