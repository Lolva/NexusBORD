package com.atossyntel.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atossyntel.springboot.model.StudentSubmissionBean;

@Controller
public class SubmitAssignmentController {
	@RequestMapping(value = "/SubmitAssignment", method = RequestMethod.GET)
	public String init(Model model, @ModelAttribute("assignment") StudentSubmissionBean assignment) {
		System.out.println(assignment.toString());
		System.out.println(assignment.getAssignment_id());
		return "SubmitAssignment";
	}
}
