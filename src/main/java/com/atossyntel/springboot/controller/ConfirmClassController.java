package com.atossyntel.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atossyntel.springboot.model.ClassBean;
import com.atossyntel.springboot.service.ClassesDAO;
import com.atossyntel.springboot.service.CreateClassDAO;

public class ConfirmClassController {
	@Autowired
	private ClassesDAO classesdao;
	
	@Autowired
	private CreateClassDAO createclassdao;
	
	@RequestMapping(value = "/ConfirmClass", method = RequestMethod.GET)
	   public String init(@ModelAttribute("ClassBean") ClassBean ClassBean) {
		   if (ClassBean != null) {
		   classesdao.getClasses();
		   return "ConfirmClass";
	   } else {
	   	return "CreateClass";
	   }
		 

	}
}	
	


