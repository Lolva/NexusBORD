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

	//Teacher email subjects
		private final String subjectTeacherFile = "NexusBORD - Teacher File Upload";
		private final String subjectTeacherAssignment = "NexusBORD - Teacher Assignment Upload";
		
		//Student email subjects
		private final String subjectStudentAssignment = "NexusBORD - Student Assignment Upload";
		
		//Teacher email body
		private final String bodyTeacherFile = "Your instructor has uploaded a file in the module.";
		private final String bodyTeacherAssignment = "Your instructor has uploaded an assignment for you to complete";
		
		//Student email body
		private final String bodyStudentAssignment = "A student has uploaded an assignment for you to review and grade";
		
		
		@Autowired
		private JavaMailSender javaMailSender;

		/******
		 * function send(String recipient(s),String subject,String msg)
		 * -Sends email to recipient(s) based on parameters
		 * -String recipient(s) is comma delimited
		 *  
		 * 1st parameter: String to
		 * 		One recipient: "[email]"
		 * 		Multiple     : "[email1],[email2]..."
		 * 2nd parameter: String subject
		 * 3rd parameter: String body
		 ******/
		public void send(String to, int msg) throws MessagingException {

			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper;
			int error = 0;

			// helper.setTo
			helper = new MimeMessageHelper(message, true);
			helper.setTo(InternetAddress.parse(to));

			switch(msg) {
				case 0:
					helper.setSubject(subjectTeacherAssignment);
					helper.setText(bodyTeacherAssignment, true);
					break;
				case 1:
					helper.setSubject(subjectStudentAssignment);
					helper.setText(bodyStudentAssignment, true);
					break;
				default:
					System.out.println("Oh no my email broke");
					error = 1;
			}
			
			if(error == 0) {
				javaMailSender.send(message);
			}
		}
}
