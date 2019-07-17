package com.atossyntel.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atossyntel.springboot.model.UserLogin;
import com.atossyntel.springboot.service.LoginDAO;

@Controller
public class LoginController {
	@Autowired
	private LoginDAO dao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("login") UserLogin login, HttpSession session) {
		if (login != null && login.getUsername() != null & login.getPassword() != null) {
			//check if the user exists in the DB and the password is correct
			if (dao.checkPassword(login)) {
				//if user has instructor role set session values for instructor
				if(dao.isInstructor(login)) { 
					session.setAttribute("username", login.getUsername());
					session.setAttribute("instructor", true);
					return "Nexus"; // after successful login, go to page <return value without quotes>.jsp
				} else {	
					//user is NOT instructor, set session values
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