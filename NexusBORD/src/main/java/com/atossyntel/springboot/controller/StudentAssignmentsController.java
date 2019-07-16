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
 	
 	List<Map<String, Object>> bean = assigndao.getAssignment("DG5061505");
 	//System.out.println(bean.get(0).toString());
 	for(Map<String, Object> r: bean) {
 		System.out.println(r.toString());
 	}
     return "StudentAssignments";
   }
}
