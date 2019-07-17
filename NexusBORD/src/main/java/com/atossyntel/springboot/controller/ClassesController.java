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
	    return "Classes";
	  }

}