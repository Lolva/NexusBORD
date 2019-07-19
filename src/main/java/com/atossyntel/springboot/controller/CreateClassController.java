package com.atossyntel.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atossyntel.springboot.model.ClassBean;
import com.atossyntel.springboot.service.CreateClassDAO;

@Controller
public class CreateClassController {
	@Autowired
	 CreateClassDAO createclassdao;
	@RequestMapping(value = "/CreateClass", method = RequestMethod.GET)
	public String getNewClassForm(@ModelAttribute("newProduct") ClassBean newProduct) {
		return "CreateClass";
	}
	
	@RequestMapping(value = "/CreateClass", method = RequestMethod.POST)
	   public String submit(Model model, @ModelAttribute("newProduct") ClassBean classToBeAdded) {
		   if (classToBeAdded != null) {
		   createclassdao.addClasses(classToBeAdded);
		   model.addAttribute("classToBeAdded", classToBeAdded);
		   return "ConfirmClass";
	   } else {
	   	return "CreateClass";
	   }

	}

}
