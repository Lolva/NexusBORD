package com.atossyntel.springboot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		for(Map<String, Object> r: classes) {
			System.out.println(r.toString());
		}
		model.addAttribute("classes", classes);
		return "InstructorAssignments";
	}
	public List<Map<String, Object>> doneInstructor(String classID) {
		
		//List<Map<String, Object>> doneQuery = assigndao.getActiveAssignments(classID, username);
		
		//return doneQuery;
		return null;
	}
	public List<Map<String, Object>> togradeInstructor(String classID) {
		
		//List<Map<String, Object>> togradeQuery = assigndao.getToGrade(classID, username);
		
		//return togradeQuery;
		return null;
	}
	public List<Map<String, Object>> overdueInstructor(String classID) {
		
		//List<Map<String, Object>> overdueQuery = assigndao.getOverdue(classID, username);
		
		//return overdueQuery;
		return null;
	}
	public List<Map<String, Object>> allStudent(String classID) {
		
		//List<Map<String, Object>> allQuery = assigndao.getstudentAssignments(classID, username);
		
		//return allQuery;
		return null;
	}
	public List<Map<String, Object>> gradeSubmitted(String classID) {
		
		//List<Map<String, Object>> gradeQuery = assigndao.getstudentGrade(classID, username);
		
		//return gradeQuery;
		return null;
	}
	public List<Map<String, Object>> todoStudent(String classID) {
		
		//List<Map<String, Object>> todoQuery = assigndao.getstudentTodo(classID, username);
		
		//return todoQuery;
		return null;
	}
}