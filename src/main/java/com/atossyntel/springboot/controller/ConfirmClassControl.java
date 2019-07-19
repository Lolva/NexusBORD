package com.atossyntel.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atossyntel.springboot.model.ClassBean;
import com.atossyntel.springboot.service.ClassesDAO;
import com.atossyntel.springboot.service.ConfirmClassDAO;

public class ConfirmClassControl {
	@Autowired
	private ClassesDAO classesdao;
	
	@Autowired
	private ConfirmClassDAO confirmclassdao;
	
	@RequestMapping(value = "/ConfirmClass", method = RequestMethod.GET)
	   public String init(@ModelAttribute("newProduct") ClassBean classToBeAdded) {
		   if (classToBeAdded != null) {
		   classesdao.getClasses();
		   return "ConfirmClass";
	   } else {
	   	return "CreateClass";
	   }

	}
}

