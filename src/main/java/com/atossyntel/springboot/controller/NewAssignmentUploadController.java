package com.atossyntel.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atossyntel.springboot.model.InstructorAssignmentsBean;
import com.atossyntel.springboot.model.StudentSubmissionBean;

@Controller
public class NewAssignmentUploadController {
	@RequestMapping(value = "/NewAssignmentUpload", method = RequestMethod.GET)
	public String init(Model model,@ModelAttribute("newassignment") InstructorAssignmentsBean assignment) {
		System.out.println(assignment.getModule_id());
		
		return "NewAssignmentUpload";
	}

	
	

}
