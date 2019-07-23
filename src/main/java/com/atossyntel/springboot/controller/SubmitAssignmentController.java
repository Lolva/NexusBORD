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

import com.atossyntel.springboot.service.EmailDAOService;
import com.atossyntel.springboot.service.AssignmentsDAOService;
import com.atossyntel.springboot.service.StudentAssignmentsDAOService;
import com.atossyntel.springboot.storage.StorageService;

@Controller
public class SubmitAssignmentController {
	
	// Instance of the storage location/object
    private final StorageService storageService;
    
    @Autowired
    public SubmitAssignmentController(StorageService storageService) {
        this.storageService = storageService;
    }
	
	// object to handle sending of email(s)
    @Autowired
    private EmailDAOService emailDAO;
    
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
			String streamId = studsub.getStream_id();
			String moduleId = studsub.getModule_id();
			String classId = studsub.getClass_id();
			
			System.out.println(filename);
			System.out.println(assignID);
			System.out.println(empID);
			
			//Test case as proof of concept for dynamic folder building
			StringBuilder modFolder = new StringBuilder("/"+streamId+"/"+classId+"/"+moduleId+"/"+ assignID + "/");

			//within com.atossyntel.springboot.storage.FileSystemStorageService.java
			storageService.store(file, modFolder.toString());
			
			//studentDAO.submitAssignment("2019-07-21",file,assignID,empID);
			studentDAO.submitAssignment(file,assignID,empID);
			
			
			//Get emailee list
			String emailee = emailDAO.getEmailStudentSubmission(classId);
			
			sms.setEmpId(empID);
			sms.setClassId(classId);
			sms.send(emailee, 1);
			
			System.out.println("Sent to DB");
		
			return "redirect:SubmitAssignment";
	
		}else {
			System.out.println("error");
			
			model.addAttribute("error","Please Upload a File");
			return "redirect:SubmitAssignment";
			
		}
		//HELLO
		
	}
	
}