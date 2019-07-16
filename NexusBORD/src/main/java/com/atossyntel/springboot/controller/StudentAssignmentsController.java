package com.atossyntel.springboot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentAssignmentsController {
@Autowired
StudentAssignmentsDAO assigndao;
@GetMapping(value = "/StudentAssignments")
   public String init(Model model, HttpServletRequest request) {
 	String usr = null; 
 	Cookie cookie = null;
 	Cookie[] cookies = null;
 	cookies = request.getCookies();
 	if(cookies != null) {
 	    for (int j = 0; j < cookies.length; j++){
 	        if(cookies[j].getName().equals("username")) {
 	            request.setAttribute("user", cookies[j].getValue());
 	        	usr = cookies[j].getValue();
 	        	String[] lines = usr.split("\\n");
 	        	System.out.println(lines[0]);
 	    }
 	    }}
 	List<Map<String, Object>> sassigns = assigndao.getAssignment(usr);
 	
 	//System.out.println(bean.get(0).toString());
 	int i = 0;
 	model.addAllAttributes(sassigns);
 	for(Map<String, Object> r: sassigns) {
 		String status = "Not turned in";
 		if(sassigns.get(i).get("submission_date") != null) {
 			status = "Turned in";
 		}
 		model.addAllAttributes(r);
 		model.addAttribute("assignmentName" + i, sassigns.get(i).get("assignment_name"));
 		model.addAttribute("dueDate" + i, sassigns.get(i).get("due_date"));
 		model.addAttribute("submissionStatus" + i, status);
 		System.out.println(r.toString());
 		i++;
 	}
 	
     return "StudentAssignments";
   }
}
