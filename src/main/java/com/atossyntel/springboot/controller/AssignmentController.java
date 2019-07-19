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
		System.out.println("Outside if statement");
		if(session.getAttribute("instructor") != null) {
			if((Boolean) session.getAttribute("instructor")) {
				System.out.println("In Instructor");
				return "redirect:InstructorAssignments";
			}
			System.out.println("In student");
			return "redirect:StudentAssignments";
		}
		System.out.println("need to login");
		return "redirect:login";
	}
}
