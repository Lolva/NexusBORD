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
		System.out.println("Time to log in:LoginController");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("login") UserLogin login, HttpSession session) {
		// First, check that the input isn't null
		if (login.getUsername() != "" & login.getPassword() != "") {
			System.out.println("Username: " + login.getUsername());
			System.out.println("Password: " + login.getPassword());
			// Next, check that the user exists in the database
			if (dao.checkPassword(login)) {

				// Finally, check that the user is enrolled in a class
				if (dao.isEnrolled(login)) {
					session.setAttribute("username", login.getUsername()); // Store the user's username in the session
					return "Nexus"; // Send the user to the main page

				} else { // Username has no entry in the Enrollments table
					model.addAttribute("error", "You are not enrolled in any classes");
					return "login";
				}

			} else { // Username and password are not a combination in the database
				model.addAttribute("error", "Invalid Username or Password");
				return "login";
			}

		} else { // User has not entered any input
			model.addAttribute("error", "Please enter your information");
			return "login";
		}
	}
}