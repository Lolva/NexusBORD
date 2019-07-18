package com.atossyntel.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreateClassController {
	@Autowired
	 CreateClassDAO createclassdao;
	@RequestMapping(value = "/CreateClass", method = RequestMethod.GET)
	public String init(Model model) {
		return "CreateClass";
	}
	
   @RequestMapping(value = "/CreateClass", method = RequestMethod.POST)
   public String submit(Model model, @ModelAttribute("classBean") ClassBean ClassBean) {
	  if (ClassBean != null) {
		  System.out.println("Controller");
		  createclassdao.addClass(ClassBean.getClass_Id(),ClassBean.getCourse_Id(),
				  ClassBean.getCapacity());
		  
		  return "redirect:CreateClasses.htm";
	  }else {
		  return "CreateClass";
	  }
   }
}