package com.atossyntel.springboot.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    			// after the DAO checks the user's input, set two cookies:
    			// "username" maps to the employee's employee_id, "password" maps to the employee's password
    			// to see these cookies in action and how to use them in .jsp, refer to Nexus.jsp
                response.addCookie(new Cookie("username", login.getUsername()));
                response.addCookie(new Cookie("password", login.getPassword()));
                
                login.updateInst(dao);
                response.addCookie(new Cookie("instructor", login.getInstructor() ? "true" : "false"));
                
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