package com.atossyntel.springboot.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atossyntel.springboot.storage.StorageService;

@Controller
public class MailController {

	@Autowired
	private SmtpMailSender smtpMailSender;
	
	private final StorageService storageService;

	@Autowired
    public MailController(StorageService storageService) {
        this.storageService = storageService;
    }
	@RequestMapping(value = "/mail", method = RequestMethod.GET)
	public String init(Model model) {
		System.out.println("Request completed");
		return "mail";
	}

	@GetMapping("/download")
	public ResponseEntity<Resource> submit(Model model) throws MessagingException {
		System.out.println("Download is startintreg...");
		StringBuilder folder = new StringBuilder("/stream/class/module/");
		Resource file = storageService.loadAsResource("SQL.txt",folder.toString());
		System.out.println("Downloading done");
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
		
		//System.out.print("going to new page");
		//smtpMailSender.send("umezaki.tatsuya@gmail.com,alfabenojar@yahoo.com,jacob-gp@hotmail.com", 999);
	}
}
