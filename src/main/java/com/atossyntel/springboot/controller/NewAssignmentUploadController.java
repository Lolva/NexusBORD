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
import com.atossyntel.springboot.service.AssignmentsDAOService;
import com.atossyntel.springboot.service.EmailDAOService;
import com.atossyntel.springboot.storage.StorageService;

@Controller
public class NewAssignmentUploadController {

	// Instance of the storage location/object
    private final StorageService storageService;
    
    // object to handle sending of email(s)
    @Autowired
    private SmtpMailSender sms;
    
    @Autowired
    private AssignmentsDAOService instructDAO;
    
    @Autowired
    private EmailDAOService emailDAO;

    //setting these values directly because of enctype
    private String sId;
    private String mId;
    private String cId;
    
    @Autowired
    public NewAssignmentUploadController(StorageService storageService) {
        this.storageService = storageService;
    }
	
	@RequestMapping(value = "/NewAssignmentUpload", method = RequestMethod.GET)
	public String init(Model model, HttpSession session, @ModelAttribute("newassignment") InstructorAssignmentsBean instructBean) {
		if(session.getAttribute("username")==null) {
			return "redirect:login";
		}
		System.out.println(instructBean.getStream_id());
		System.out.println(instructBean.getModule_id());
		System.out.println(instructBean.getClass_id());
		model.addAttribute("streamId",instructBean.getStream_id());
		model.addAttribute("moduleId",instructBean.getModule_id());
		model.addAttribute("classId",instructBean.getClass_id());
		sId = instructBean.getStream_id();
		mId = instructBean.getModule_id();
		cId = instructBean.getClass_id();
		
		return "NewAssignmentUpload";
	}

	@RequestMapping(value = "/NewAssignmentUpload", method = RequestMethod.POST)
	public String submit(Model model, HttpServletRequest request, HttpSession session,
			@RequestParam("fileName") MultipartFile file/*,
			@RequestParam("streamInput") String sId,
			@RequestParam("moduleInput") String mId,
			@RequestParam("classInput") String cId*/) throws MessagingException{
		if (true) {
			
			//String aId = request.getParameter("assignmentId");
			String aName = request.getParameter("assignmentName");
			String date = request.getParameter("due_date");
			String option = request.getParameter("options");
			String desc = request.getParameter("desc");
			//String sId = request.getParameter("streamInput");
			//String mId = request.getParameter("moduleInput");
			//String cId = request.getParameter("classInput");
			String filename = file.getOriginalFilename();
			
			//println() for debugging purposes
			System.out.println(aName);
			System.out.println(filename);
			System.out.println(date);
			System.out.println(option);
			System.out.println(desc);
			System.out.println(sId);
			System.out.println(mId);
			System.out.println(cId);
			
			//Test case as proof of concept for dynamic folder building
			StringBuilder modFolder = new StringBuilder("/"+sId+"/"+cId+"/"+mId+"/");

			//within com.atossyntel.springboot.storage.FileSystemStorageService.java
			storageService.store(file, modFolder.toString());
			
			instructDAO.setAssignment(aName, file, date, mId, cId, desc, option);
			//instructDAO.updateAssignment("A BRAND NEW UPDATE", file, date, mId, cId, "Blah", option, aId);
			//instructDAO.deleteAssignment(aId);

			//retrieve emails of necessary participants
			String emailee = emailDAO.getEmailNewAssignment(cId);

			//within com.atossyntel.springboot.controller.SmtpMailSender.java		
			sms.send(emailee, 0);
			
			return "redirect:Assignments";
		} else {
			model.addAttribute("error", "Please Fill All Fields");
			return "redirect:NewAssignmentUpload";
		}
	}
}
