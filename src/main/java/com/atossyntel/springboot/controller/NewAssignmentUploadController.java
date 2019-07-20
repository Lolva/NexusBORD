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
import org.springframework.web.servlet.ModelAndView;

import com.atossyntel.springboot.model.DescriptionBean;
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
    public NewAssignmentUploadController(StorageService storageService) {
        this.storageService = storageService;
    }
	
	@RequestMapping(value = "/NewAssignmentUpload", method = RequestMethod.GET)
	public String init(Model model) {
		return"NewAssignmentUpload";
	}

	@RequestMapping(value = "/NewAssignmentUpload", method = RequestMethod.POST)
	public String submit(Model model, HttpServletRequest request, HttpSession session,
			@RequestParam("fileName") MultipartFile file) throws MessagingException{
		if (true) {
			
			String aName = request.getParameter("assignmentName");
			String date = request.getParameter("due_date");
			//String desc = descBean.getDescriptionInput();
			String desc = request.getParameter("desc");
			String maxPoints = request.getParameter("max_points");
			String sId = request.getParameter("streamInput");
			String mId = request.getParameter("moduleInput");
			String cId = request.getParameter("classInput");
			String filename = file.getOriginalFilename();
			
			//println() for debugging purposes
			System.out.println(aName);
			System.out.println(date);
			System.out.println(desc);
			System.out.println(maxPoints);
			System.out.println(sId);
			System.out.println(mId);
			System.out.println(cId);
			System.out.println(filename);
			
			//Test case as proof of concept for dynamic folder building
			StringBuilder modFolder = new StringBuilder("/"+sId+"/"+cId+"/"+mId+"/");
//			switch(sId) {
//				//if the stream name is "1"
//				case "1":
//					//set the string to folder1
//					modFolder.append("/folder1/");
//					break;
//				//if the stream name is "1"
//				case "2":
//					//set the string to folder2
//					modFolder.append("/folder2/");
//					break;
//				default:
//					//set an empty folder(aka directly under the root folder)
//					modFolder.append("");
//			}					
			
			
			//within com.atossyntel.springboot.storage.FileSystemStorageService.java
			storageService.store(file, modFolder.toString());
			
			//within com.atossyntel.springboot.controller.SmtpMailSender.java
			sms.send("umezaki.tatsuya@gmail.com,alfabenojar@yahoo.com,jacob-gp@hotmail.com", "Proof of Concept files",
					"Our work is done. Maybe?");
			//System.out.print(file.getOriginalFilename());
			return "redirect:InstructorAssignments";
		} else {
			model.addAttribute("error", "Please Fill All Fields");
			return "NewAssignmentUpload";
		}
	}

}
