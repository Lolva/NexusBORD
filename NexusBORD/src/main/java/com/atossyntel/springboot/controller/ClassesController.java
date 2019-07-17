package com.atossyntel.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClassesController {
	@Autowired
	ClassesDAO classdao;
	@RequestMapping(value = "/Classes", method = RequestMethod.GET)
	public String init(Model model) {
		List<Map<String, Object>> allStudents = classdao.getAllStudents();

		model.addAttribute("allStudents", allStudents);
		List<Map<String, Object>> classIds = classdao.getClasses();
		int j=0;
		model.addAttribute("classIds", classIds);
//		for(Map<String, Object> id: classIds) {
////			 model.addAttribute("classId"+j, classIds.get(j).get("class_id"));
//			 System.out.println(id.toString());
//			for (Map.Entry<String, Object> entry : id.entrySet()) {
//				List<Map<String, Object>> students = classdao.getStudents(entry.getValue().toString());
//				model.addAttribute("students"+j, students);
//				System.out.println("Students"+j);	
//				j++;
//			
//				if (students != null) {
//					int i=0;
//					for(Map<String, Object> r: students) {
////						 model.addAttribute("first_name"+i, students.get(i).get("first_name"));
////						 model.addAttribute("last_name"+i, students.get(i).get("last_name"));
////						 model.addAttribute("email"+i, students.get(i).get("email"));
//						 System.out.println(r.toString());	
//						 i++;
//					 }
//				}
//				
//		    }
//			
//		}
	    return "Classes";
	  }

}