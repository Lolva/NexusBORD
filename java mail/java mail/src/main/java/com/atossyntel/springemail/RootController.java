package com.atossyntel.springemail;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
	
	@Autowired
	private SmtpMailSender smtpMailSender;

	@RequestMapping("/mail")
	public void sendMail() throws MessagingException {
		
		
		smtpMailSender.send("umezaki.tatsuya@gmail.com,alfabenojar@yahoo.com,jacob-gp@hotmail.com", "Subject Test mail", "The message. Hello, Thank you for the email.");
		
	}
	

}
