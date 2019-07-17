package com.atossyntel.springboot.controller;

import java.util.List;
import java.util.Map;

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
	public String init(Model model) {
		List<Map<String, Object>> sassigns = assigndao.getAssignment();
		model.addAttribute("sassigns", sassigns);
		return "InstructorAssignments";
	}
}