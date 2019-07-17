package com.atossyntel.springboot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atossyntel.springboot.service.InstructorAssignmentsDAO;

@Controller
public class InstructorAssignmentsController {
	@Autowired
	InstructorAssignmentsDAO assigndao;

	@RequestMapping(value = "/InstructorAssignments", method = RequestMethod.GET)
	public String init(Model model, HttpSession session) {
		if(session.getAttribute("username")==null) {
			return "redirect:login";
		}
		if((Boolean) session.getAttribute("instructor")) {
			List<Map<String, Object>> sassigns = assigndao.getAssignment();
			model.addAttribute("sassigns", sassigns);
			return "InstructorAssignments";
		}
		return "redirect:assignments";
	}
}