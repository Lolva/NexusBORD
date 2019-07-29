package com.atossyntel.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atossyntel.springboot.model.GradeBean;
import com.atossyntel.springboot.model.InstructorAssignmentsBean;
import com.atossyntel.springboot.model.StudentSubmissionBean;
import com.atossyntel.springboot.service.EmailDAOService;

import com.atossyntel.springboot.service.ModuleDAO;

import com.atossyntel.springboot.service.StudentAssignmentsDAOService;

import com.atossyntel.springboot.storage.StorageService;
import com.atossyntel.springboot.service.AssignmentsDAO;

@Controller
public class AssignmentsController {
	
	
	@Autowired
    public AssignmentsController(StorageService storageService) {
        this.storageService = storageService;
    }
	
    @Autowired
    private SmtpMailSender sms;
    
    @Autowired
    private EmailDAOService emailDAO;
    
    @Autowired
	private ModuleDAO moduledao;
    
	@Autowired
	private StorageService storageService;

	@Autowired
    private StudentAssignmentsDAOService studentDAO;



	@Autowired
	AssignmentsDAO assigndao;
	
	private String username = null;
	@RequestMapping(value = "/Assignments", method = RequestMethod.GET)
	public String init(Model model, HttpSession session) {
	
		if(session.getAttribute("username")==null) {
			return "redirect:login";
		}
	
		//user is not an instructor redirect to assignments
		username = session.getAttribute("username").toString();
		
		List<Map<String, Object>> classes = assigndao.getClasses(username);
		model.addAttribute("classes", classes);
		
		List<List<Map<String,Object>>> activesI = new ArrayList<>();
		//List<List<Map<String,Object>>> overdueI = new ArrayList<>();
		List<List<Map<String,Object>>> assignsS = new ArrayList<>();
		List<List<Map<String,Object>>> gradesS = new ArrayList<>();
		List<List<Map<String,Object>>> todoS = new ArrayList<>();
		for(Map<String, Object> t:classes) {
			System.out.println("da classes " + t.toString());
			if(t.get("role_id").equals("1")) {
				//System.out.println("Instructor");
				activesI.add(assigndao.getActiveAssignments(t.get("class_Id").toString(), username));
				model.addAttribute("olist", assigndao.overdueInstructor(t.get("class_Id").toString()));
				model.addAttribute("tgList", assigndao.getToGrade(t.get("class_Id").toString(), username));
			} else {
				//System.out.println("Student");
				assignsS.add(assigndao.getStudentAssignments(username, t.get("class_Id").toString()));
				gradesS.add(assigndao.studentGraded(username, t.get("class_Id").toString()));
				model.addAttribute("todoAssignments",assigndao.studentTodo(username, t.get("class_Id").toString()));
			}
		}
		
		
		
		model.addAttribute("daList", activesI);
		//model.addAttribute("odList", overdueI);
		model.addAttribute("asList", assignsS);
		model.addAttribute("sgList", gradesS);
		model.addAttribute("tsList", todoS);
		return "Assignments";
	}
	
	@RequestMapping(value = "/Assignments", params="grades")
	public String grader(Model model, @ModelAttribute("grades") GradeBean grade) throws MessagingException{
		System.out.println(grade.toString());
		
		//emailee list
		String emailee = emailDAO.getEmailNewGrade(grade.getAssignment_id(), grade.getEmployee_id());

		//within com.atossyntel.springboot.controller.SmtpMailSender.java	
		sms.setAssignId(grade.getAssignment_id());
		sms.send(emailee, 2);
		
		assigndao.updateGrade(grade.getEmployee_id(), grade.getAssignment_id(), grade.getGrade());
		return "redirect:Assignments";
		
	}
	
	@RequestMapping(value = "/Assignments", params = "assignment")
	public String submitAssignment(Model model, @ModelAttribute("assignment") StudentSubmissionBean assignment, RedirectAttributes redirectAttributes, 
			@RequestParam("fileName") MultipartFile file, HttpServletRequest request,HttpSession session) throws MessagingException {
		StringBuilder modFolder = new StringBuilder("/"+assignment.getStream_id()+"/"+assignment.getClass_id()+"/"+assignment.getModule_id()+"/"+ assignment.getAssignment_id() + "/");
		storageService.store(file, modFolder.toString());
		studentDAO.submitAssignment(file,assignment.getAssignment_id(),username);
		String emailee = emailDAO.getEmailStudentSubmission(assignment.getClass_id());
		
		sms.setEmpId(username);
		sms.setClassId(assignment.getClass_id());
		sms.send(emailee, 1);
		
		System.out.println("Sent to DB");
	
		return "redirect:Assignments";
		

	}
	@RequestMapping(value = "/addAssignmentsFile", method = RequestMethod.POST)
	public String newAssignmentFile(Model model, HttpServletRequest request, @RequestParam("name") String name, @RequestParam("module_id") String module_id,
			@RequestParam("class_id") String class_id, @RequestParam("stream_id") int stream_id,
			@RequestParam("fileName") MultipartFile file, @RequestParam("due_date") String due_date, @RequestParam("desc") String desc, @RequestParam("status") String status) {
		
		System.out.println(name + " " + file.toString() + " " + module_id + " " + class_id + " " + due_date + " " + desc + " " + status);
		System.out.println(moduledao.newAssignment(name, file, due_date, module_id, class_id, desc, status));
		storageService.store(file, "/" + stream_id + "/" + class_id + "/" + module_id + "/");
		return "redirect:Assignments";

	}
	
	@ModelAttribute("modules")
	public List<Map<String, Object>> getModules(HttpSession session){
		
		return assigndao.getModules(session.getAttribute("username").toString());
	}
}