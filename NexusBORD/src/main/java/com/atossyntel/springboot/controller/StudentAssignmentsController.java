package com.atossyntel.springboot.controller;

import java.util.List;
import java.util.Map;

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
   public String init(Model model) {
 	
 	List<Map<String, Object>> sassigns = assigndao.getAssignment("DG5061505");
 	
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
