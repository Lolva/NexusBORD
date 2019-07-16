package com.atossyntel.springboot.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	@RequestMapping("/logout")
	public String index(Model model, HttpServletResponse response) {
		return "login";
	}
}
