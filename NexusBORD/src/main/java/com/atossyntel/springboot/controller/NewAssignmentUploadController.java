package com.atossyntel.springboot.controller;

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

import com.atossyntel.springboot.model.InstructorAssignmentsBean;
import com.atossyntel.springboot.storage.StorageService;

@Controller
public class NewAssignmentUploadController {
	
	// Instance of the storage location/object
    private final StorageService storageService;

    @Autowired
    public NewAssignmentUploadController(StorageService storageService) {
        this.storageService = storageService;
    }
	
	@RequestMapping(value = "/NewAssignmentUpload", method = RequestMethod.GET)
	public String init(Model model) {
		return "NewAssignmentUpload";
	}

	@RequestMapping(value = "/NewAssignmentUpload", method = RequestMethod.POST)
	public String submit(Model model, HttpServletRequest request, HttpSession session,
			@RequestParam("fileName") MultipartFile file) {
		if (true) {
			
			String aName = request.getParameter("assignmentName");
			String sName = request.getParameter("streamInput");
			System.out.println(aName);
			System.out.println(sName);
			
			String filename = file.getOriginalFilename();
			
			storageService.store(file);
			
			return "redirect:InstructorAssignments";
		} else {
			model.addAttribute("error", "Please Fill All Fields");
			return "NewAssignmentUpload";
		}
	}

}
