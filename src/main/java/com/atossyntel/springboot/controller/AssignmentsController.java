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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atossyntel.springboot.model.GradeBean;
import com.atossyntel.springboot.model.InstructorAssignmentsBean;
import com.atossyntel.springboot.model.StudentSubmissionBean;
import com.atossyntel.springboot.service.EmailDAOService;
import com.atossyntel.springboot.service.AssignmentsDAO;

@Controller
public class AssignmentsController {
	
    @Autowired
    private SmtpMailSender sms;
    
    @Autowired
    private EmailDAOService emailDAO;


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
		sms.send(emailee, 2);
		
		assigndao.updateGrade(grade.getEmployee_id(), grade.getAssignment_id(), grade.getGrade());
		return "redirect:Assignments";
		
	}
	
	@RequestMapping(value = "/Assignments", params = "assignment")
	public String submitAssignment(Model model, @ModelAttribute("assignment") StudentSubmissionBean assignment, RedirectAttributes redirectAttributes) {
		System.out.println(assignment.toString());
		model.addAttribute("assignment_id", assignment.getAssignment_id());
		model.addAttribute("class_id", assignment.getClass_id());
		model.addAttribute("module_id", assignment.getModule_id());
		model.addAttribute("stream_id", assignment.getStream_id());
		assignment.setEmployee_id(username);
		model.addAttribute("employee_id", assignment.getEmployee_id());
		redirectAttributes.addFlashAttribute("assignment", assignment);
		return "redirect:SubmitAssignment";
		

	}
	@RequestMapping(value = "/Assignments", params = "newassignment")
	public String newAssignment(Model model, @ModelAttribute("newassignment") InstructorAssignmentsBean assignment, RedirectAttributes redirectAttributes, HttpServletRequest result) {
		System.out.println(assignment.toString());
		//assignment.setModule_id(result.getParameter("module"));
		model.addAttribute("module_id", assignment.getModule_id());
		model.addAttribute("moduleS", assignment);
		
		redirectAttributes.addFlashAttribute("newassignment", assignment);
		return "redirect:NewAssignmentUpload";
		

	}
	@ModelAttribute("modules")
	public List<Map<String, Object>> getModules(HttpSession session){
		
		return assigndao.getModules(session.getAttribute("username").toString());
	}
}