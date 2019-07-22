package com.atossyntel.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.atossyntel.springboot.model.ClassBean;
import com.atossyntel.springboot.service.CreateClassDAO;
import com.atossyntel.springboot.service.CreateClassDAOService;

@Controller
public class CreateClassController {
	@Autowired
	 CreateClassDAO createclassdao;
	@RequestMapping(value = "/CreateClass", method = RequestMethod.GET)
	public String getNewClassForm(@ModelAttribute("ClassBean") ClassBean ClassBean) {
		return "CreateClass";
	}
	
	@RequestMapping(value = "/CreateClass", method = RequestMethod.POST)
	   public String submit(Model model, @ModelAttribute("ClassBean") ClassBean ClassBean, HttpSession session) {
		   if (ClassBean != null) {
		  createclassdao.addClasses(ClassBean.getClass_Id(),ClassBean.getStream_Id(),ClassBean.getStart_date(),ClassBean.getEnd_date());
		 //  model.addAttribute("classBean", ClassBean);
		   return "ConfirmClass";
	   } else {
	   	return "CreateClass";
	   }

	}

}
	 
