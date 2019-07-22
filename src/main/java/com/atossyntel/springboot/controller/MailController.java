package com.atossyntel.springboot.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MailController {

	@Autowired
	private SmtpMailSender smtpMailSender;

	@RequestMapping(value = "/mail", method = RequestMethod.GET)
	public String init(Model model) {
		System.out.println("Request completed");
		return "mail";
	}

	@PostMapping("/mail")
	public String submit(Model model) throws MessagingException {
		System.out.print("going to new page");
		smtpMailSender.send("umezaki.tatsuya@gmail.com,alfabenojar@yahoo.com,jacob-gp@hotmail.com", 999);
		return "mail";
	}
}
