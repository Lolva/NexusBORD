package com.atossyntel.springboot.controller;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	@RequestMapping("/logout")
	public String index(Model model, HttpSession session) {
		//remove session
		session.invalidate();
		return "redirect:login";
	}
}
