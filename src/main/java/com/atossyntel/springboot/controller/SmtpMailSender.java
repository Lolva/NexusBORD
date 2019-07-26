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

	
		private String assignId;
		private String empId;
		private String classId;
		private String instId;
		
		//Teacher email subjects
		private final String subjectTeacherFile = "NexusBORD - Teacher File Upload";
		private final String subjectTeacherAssignment = "NexusBORD - Teacher Assignment Upload";
		
		//Student email subjects
		private final String subjectStudentAssignment = "NexusBORD - Student Assignment Upload";
		private final String subjectStudentGrade = "NexusBORD - Student Assignment Graded";
		
		//Teacher email body
		private final String bodyTeacherFile = "Your instructor has uploaded a file in the module.";
		private final String bodyTeacherAssignment0 = "An instructor has uploaded an assignment for you to complete in class ";
		private final String bodyTeacherAssignment1 = "<br><br>To view this assignment, <a href='localhost:8085'>Login Here.</a>";
		
		//Student email body
		private final String bodyStudentAssignment = " has uploaded an assignment for you to review and grade in class ";
		private String bodyStudentGrade1 = "Your instructor has graded assignment ";
		private String bodyStudentGrade2 = " for class ";		
		
		//Enrollments
		private final String subjectEnrollment = " NexusBord - New Class Enrollment ";
		private String bodyClassEnrollment = "Your Instructor has enrolled you in a class. ";
				
		
		
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
				//teacher creating an assignment
				case 0:
					helper.setSubject(subjectTeacherAssignment);
					helper.setText(bodyTeacherAssignment0 + classId + ". "
							+ bodyTeacherAssignment1 , true);
					break;
				//student submitting an assignment to instructor
				case 1:
					helper.setSubject(subjectStudentAssignment);
					helper.setText(empId+bodyStudentAssignment+classId, true);
					break;
				//teacher grading an assignment
				case 2:
					helper.setSubject(subjectStudentGrade + " for class " + classId);
					helper.setText(bodyStudentGrade1 + assignId + bodyStudentGrade2 + classId, true);
					break;
				case 3:
					helper.setSubject(subjectEnrollment);
					helper.setText(bodyClassEnrollment);
					break;
				default:
					System.out.println("Oh no my email broke");
					error = 1;
			}
			
			if(error == 0) {
				javaMailSender.send(message);
			}
		}

		public String getEmpId() {
			return empId;
		}

		public void setEmpId(String empId) {
			this.empId = empId;
		}

		public String getClassId() {
			return classId;
		}

		public void setClassId(String classId) {
			this.classId = classId;
		}

		public String getAssignId() {
			return assignId;
		}

		public void setAssignId(String assignId) {
			this.assignId = assignId;
		}
		
}
