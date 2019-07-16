package com.atossyntel.springboot.controller;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atossyntel.springboot.model.UserLogin;
import com.atossyntel.springboot.service.UserLoginDAO;

@Controller
public class LoginController {
	@Autowired
	private UserLoginDAO dao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("login") UserLogin login, HttpServletResponse response) {
		if (login != null && login.getUsername() != null & login.getPassword() != null) {
			if (dao.checkPassword(login)) {
				return "Nexus"; // after successful login, go to page <return value without quotes>.jsp
			} else {
				model.addAttribute("error", "Invalid Username or Password");
				return "login";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "login";
		}
	}
}