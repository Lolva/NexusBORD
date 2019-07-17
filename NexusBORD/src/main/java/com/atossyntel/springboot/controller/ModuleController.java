package com.atossyntel.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atossyntel.springboot.model.ModuleBean;
import com.atossyntel.springboot.model.UserLogin;
import com.atossyntel.springboot.service.UserLoginDAO;

@Controller
public class ModuleController {
	
	@Autowired
	private UserLoginDAO dao;

	@RequestMapping(value = "/Modules", method = RequestMethod.GET)
	public String module(Model model) {
		return "Modules";
	}

	

}






	