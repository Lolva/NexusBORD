package com.atossyntel.springboot.controller;


import javax.mail.MessagingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.atossyntel.springboot.model.StudentSubmissionBean;
import com.atossyntel.springboot.service.InstructorAssignmentsDAOService;
import com.atossyntel.springboot.service.StudentAssignmentsDAOService;
import com.atossyntel.springboot.storage.StorageService;

@Controller
public class SubmitAssignmentController {
	
	// object to handle sending of email(s)
    @Autowired
    private SmtpMailSender sms;
    
    
    @Autowired
    private StudentAssignmentsDAOService studentDAO;
    
    
    private StudentSubmissionBean studsub; 
    
	@RequestMapping(value = "/SubmitAssignment", method = RequestMethod.GET)
	public String init(Model model, @ModelAttribute("assignment") StudentSubmissionBean assignment) {
		
		
		studsub=assignment;

		System.out.println(assignment.toString());
		System.out.println(studsub.getAssignment_id());
		System.out.println(assignment.getAssignment_id());
		studsub=assignment;
		return "SubmitAssignment";
	}
	
	//@SuppressWarnings("unused")
	@RequestMapping(value = "/SubmitAssignment", method = RequestMethod.POST)
	public String submit(Model model, HttpServletRequest request, HttpSession session,
			@RequestParam("fileName") MultipartFile file, @ModelAttribute("assignment") StudentSubmissionBean assignment) 
					throws MessagingException{
		if (true) {
			

			
			String assignID = studsub.getAssignment_id();
			String empID = studsub.getEmployee_id();
			String filename = file.getOriginalFilename();
			
			System.out.println(filename);
			System.out.println(assignID);
			System.out.println(empID);
			

			studentDAO.submitAssignment("2019-07-21", 90, file, assignID, empID);
			
			
			sms.send("umezaki.tatsuya@gmail.com,alfabenojar@yahoo.com,jacob-gp@hotmail.com", "Student Side",
					"Student Submission Complete?");
			
			System.out.println("Sent to DB");
		
			return "redirect:SubmitAssignment";
	
		}else {
			System.out.println("error");
			sms.send("umezaki.tatsuya@gmail.com,alfabenojar@yahoo.com,jacob-gp@hotmail.com", "Did not Submit",
					"Student Submission Failure");
			
			model.addAttribute("error","Please Upload a File");
			return "redirect:SubmitAssignment";
			
		}
		
		
	}
	
}