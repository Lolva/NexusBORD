package com.atossyntel.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.atossyntel.springboot.service.StudentAssignmentsDAO;

//Controller to redirect if they are an instructor
@Controller
public class AssignmentController {
	@Autowired
	StudentAssignmentsDAO assigndao;

	@GetMapping(value = "/assignments")
	public String init(Model model, HttpSession session) {
		if((Boolean) session.getAttribute("instructor")) {
			return "redirect:InstructorAssignments";
		}
		return "redirect:StudentAssignments";
	}
}
