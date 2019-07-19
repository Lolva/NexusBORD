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

import com.atossyntel.springboot.model.InstructorAssignmentsBean;
import com.atossyntel.springboot.storage.StorageService;

@Controller
public class NewAssignmentUploadController {

	// Instance of the storage location/object
    private final StorageService storageService;
    
    // object to handle sending of email(s)
    @Autowired
    private SmtpMailSender sms;

    @Autowired
    public NewAssignmentUploadController(StorageService storageService, HttpSession session) {
        this.storageService = storageService;
    }
	
	@RequestMapping(value = "/NewAssignmentUpload", method = RequestMethod.GET)
	public String init(Model model) {
		return "NewAssignmentUpload";
	}

	@RequestMapping(value = "/NewAssignmentUpload", method = RequestMethod.POST)
	public String submit(Model model, HttpServletRequest request, HttpSession session,
			@RequestParam("fileName") MultipartFile file) throws MessagingException{
		if (true) {
			
			String aName = request.getParameter("assignmentName");
			String sName = request.getParameter("streamInput");
			
			//Test case as proof of concept for dynamic folder building
			StringBuilder modFolder = new StringBuilder();
			switch(sName) {
				//if the stream name is "1"
				case "1":
					//set the string to folder1
					modFolder.append("/folder1/");
					break;
				//if the stream name is "1"
				case "2":
					//set the string to folder2
					modFolder.append("/folder2/");
					break;
				default:
					//set an empty folder(aka directly under the root folder)
					modFolder.append("");
			}
			
			//println() for debugging purposes
			System.out.println(aName);
			System.out.println(sName);
			
			String filename = file.getOriginalFilename();
			
			//within com.atossyntel.springboot.storage.FileSystemStorageService.java
			storageService.store(file, modFolder.toString());
			
			//within com.atossyntel.springboot.controller.SmtpMailSender.java
			sms.send("umezaki.tatsuya@gmail.com,alfabenojar@yahoo.com,jacob-gp@hotmail.com", "Proof of Concept files",
					"Our work is done. Maybe?");
			return "redirect:InstructorAssignments";
		} else {
			model.addAttribute("error", "Please Fill All Fields");
			return "NewAssignmentUpload";
		}
	}

}
