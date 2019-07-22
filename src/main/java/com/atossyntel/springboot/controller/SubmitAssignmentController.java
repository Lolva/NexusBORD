package com.atossyntel.springboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.atossyntel.springboot.model.StudentSubmissionBean;

@Controller
public class SubmitAssignmentController {
	
	private StudentSubmissionBean assign;
	
	@RequestMapping(value = "/SubmitAssignment", method = RequestMethod.GET)
	public String init(Model model, @ModelAttribute("assignment") StudentSubmissionBean assignment, HttpSession session) {
		System.out.println(assignment.toString());
		System.out.println(assignment.getAssignment_id());
		assign=assignment;
		return "SubmitAssignment";
	}
	
	@RequestMapping(value = "/SubmitAssignment", method = RequestMethod.POST)
	public String submit(Model model, HttpServletRequest request, HttpSession session,
			@RequestParam("fileName") MultipartFile file) {
		System.out.println("AssignmentId: "+assign.getAssignment_id());
		System.out.println("EmptId: "+assign.getEmployee_id());
		System.out.println("StreamId: "+assign.getStream_id());
//		System.out.println("AssignmentId: "+assignment.getAssignment_id());
//		System.out.println("EmptId: "+assignment.getEmployee_id());
//		System.out.println("StreamId: "+assignment.getStream_id());
		return "SubmitAssignment";
	}
}
