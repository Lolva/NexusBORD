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
	public String submit(Model model, @ModelAttribute("login") UserLogin login, HttpSession session) {
		if (login != null && login.getUsername() != null & login.getPassword() != null) {
			if (dao.checkPassword(login)) {
				if(dao.isInstructor(login)) { //if user has instructor role set session valeus for instructor
					session.setAttribute("username", login.getUsername());
					session.setAttribute("instructor", true);
					return "Nexus"; // after successful login, go to page <return value without quotes>.jsp
				} else {	//user is NOT instructor, set session values
					session.setAttribute("username", login.getUsername());
					session.setAttribute("instructor", false);
					return "Nexus";
				}
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