package com.atossyntel.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InstructorAssignmentsController {
	@Autowired
	InstructorAssignmentsDAO assigndao;
 @RequestMapping(value = "/InstructorAssignments", method = RequestMethod.GET)
  public String init(Model model) {
	 List<Map<String, Object>> sassigns = assigndao.getAssignment();
	 int i =0;
	 
	 for(Map<String, Object> r: sassigns) {
		 model.addAttribute("title"+i, sassigns.get(i).get("assignment_name"));
		 model.addAttribute("due_date"+i, sassigns.get(i).get("DUE_DATE"));
		 model.addAttribute("max_points"+i, sassigns.get(i).get("max_points"));
		 model.addAttribute("file"+i, sassigns.get(i).get("attached_files"));
		 System.out.println(r.toString());
		 i++;
	 }
    return "InstructorAssignments";
  }
}