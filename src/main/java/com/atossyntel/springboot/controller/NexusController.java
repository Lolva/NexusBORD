package com.atossyntel.springboot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

import com.atossyntel.springboot.service.NexusHomeDAO;
import com.atossyntel.springboot.service.NexusHomeServiceDAO;
import java.util.List;
import java.util.Map;

@Controller
public class NexusController {
	@Autowired
	NexusHomeDAO homedao;
	
	@RequestMapping(value = "/Nexus")
	public String init(Model model, HttpSession session) {
		String employeeId = (String)session.getAttribute("username");
		if(employeeId != null) {
			List<Map<String, Object>> overdue = homedao.overdueAssignments(employeeId);
			List<Map<String, Object>> todo = homedao.toDoAssignments(employeeId);
			List<Map<String, Object>> changelog = homedao.changelog(employeeId);
			
			model.addAttribute("overdue",overdue);
			model.addAttribute(todo);
			model.addAttribute(changelog);
			System.out.println(model);

			return "Nexus";
		} else {
			return "login";
		}
	}
}