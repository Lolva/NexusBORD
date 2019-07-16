package com.atossyntel.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atossyntel.springboot.model.InstructorAssignmentsBean;

@Controller
public class NewAssignmentUploadController {
	@RequestMapping(value = "/NewAssignmentUpload", method = RequestMethod.GET)
	public String init(Model model) {
		return "NewAssignmentUpload";
	}

	@RequestMapping(value = "/NewAssignmentUpload", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("assignmentBean") InstructorAssignmentsBean assignmentBean) {
		if (assignmentBean != null /*
									 * && assignmentBean.getAssignmentName() != null & assignmentBean.getDue_date()
									 * != null & assignmentBean.getMax_points() != null
									 */) {
			model.addAttribute("title", assignmentBean.getAssignmentName());
			model.addAttribute("due_date", assignmentBean.getDue_date());
			model.addAttribute("max_points", assignmentBean.getMax_points());
			model.addAttribute("file", assignmentBean.getFileName());
			return "InstructorAssignments";
		} else {
			model.addAttribute("error", "Please Fill All Fields");
			return "NewAssignmentUpload";
		}
	}

}
