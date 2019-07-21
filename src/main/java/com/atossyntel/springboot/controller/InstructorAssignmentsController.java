package com.atossyntel.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atossyntel.springboot.model.GradeBean;
import com.atossyntel.springboot.model.StudentSubmissionBean;
import com.atossyntel.springboot.service.InstructorAssignmentsDAO;

@Controller
public class InstructorAssignmentsController {
	@Autowired
	InstructorAssignmentsDAO assigndao;
	private String username = null;
	@RequestMapping(value = "/InstructorAssignments", method = RequestMethod.GET)
	public String init(Model model, HttpSession session) {
		/*//user hasnt logged in yet, redirect to login page
		if(session.getAttribute("username")==null) {
			return "redirect:login";
		}
		//verify user is an instructor
		if((Boolean) session.getAttribute("instructor")) {
			List<Map<String, Object>> sassigns = assigndao.getAssignment();
			model.addAttribute("sassigns", sassigns);
			return "InstructorAssignments";
		}*/
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
				System.out.println("Instructor");
				activesI.add(assigndao.getActiveAssignments(t.get("class_Id").toString(), username));
				model.addAttribute("olist", assigndao.overdueInstructor(t.get("class_Id").toString()));
				model.addAttribute("tgList", assigndao.getToGrade(t.get("class_Id").toString(), username));
			} else {
				System.out.println("Student");
				assignsS.add(assigndao.getStudentAssignments(username, t.get("class_Id").toString()));
				gradesS.add(assigndao.studentGraded(username, t.get("class_Id").toString()));
				todoS.add(assigndao.studentTodo(username, t.get("class_Id").toString()));
			}
		}
		
		
	
		//for(Map<String,Object> m : classes) {
			//list1.add(assigndao.getActiveAssignments(m.get("class_Id").toString(), username));
			// list2.add(assigndao.overdueInstructor(m.get("class_Id").toString()));
			//model.addAttribute("tgList", assigndao.getToGrade(m.get("class_Id").toString(), username));
			
			//Student
			//list3.add(assigndao.getStudentAssignments(username, m.get("class_Id").toString()));
		//}
		//for(List<Map<String, Object>> l : list1) {
			//for(Map<String, Object> r: l) {
			//	System.out.println("active " + r.toString());
			//}}
		
		model.addAttribute("daList", activesI);
		//model.addAttribute("odList", overdueI);
		model.addAttribute("asList", assignsS);
		model.addAttribute("sgList", gradesS);
		model.addAttribute("tsList", todoS);
		return "InstructorAssignments";
	}
	
	@RequestMapping(value = "/InstructorAssignments", params="grades")
	public String grader(Model model, @ModelAttribute("grades") GradeBean grade) {
		System.out.println(grade.toString());
		assigndao.updateGrade(grade.getEmployee_id(), grade.getAssignment_id(), grade.getGrade());
		return "redirect:InstructorAssignments";
		
	}
	
	@RequestMapping(value = "/InstructorAssignments", params = "assignment")
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
}