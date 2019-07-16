package com.atossyntel.springboot.controller;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SmtpMailSender {
	
	final static private String subjectTeacherUpload="NexusBORD - Instructor File Upload";
	final static private String subjectStudentUpload="NexusBORD - Student Assignment Upload";
	final static private String subjectTeacherAssignment="NexusBORD - Instructor Assignment Upload";
	
	
	final static private String bodyTeacherUpload="Your instructor has uploaded a file to your module.";
	final static private String bodyStudentUpload="A student has uploaded an assignment for you to review.";
	final static private String bodyTeacherAssignment="Your instructor has uploaded an assignment for you to complete.";

	@Autowired
	private JavaMailSender javaMailSender;

	public void send(String to, String subject, String body) throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;

		helper = new MimeMessageHelper(message, true);
		helper.setTo(InternetAddress.parse(to));
		/***********
		 * switch([INT OR STRING]){
		 *  	case x:
		 *  		helper.setSubject(subjectTeacherUpload);
		 *  		helper.setText(bodyTeacherUpload, true);
		 *  		break;
		 *  	case y:
		 *  		helper.setSubject(subjectStudentUpload);
		 *  		helper.setText(bodyStudentUpload, true);
		 *  		break;
		 *  	case z:
		 *  		helper.setSubject(subjectTeacherAssignment);
		 *  		helper.setText(bodyTeacherAssignment, true);
		 *  		break;	
		 * }
		 *
		 ***********/
		helper.setSubject(subject);
		helper.setText(body, true);

		javaMailSender.send(message);

	}

}
