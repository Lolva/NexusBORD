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
import java.util.Stack;

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
			
			Stack<Map<String, Object>> changelogDesc = new Stack<Map<String, Object>>();
			for(Map<String, Object> change : changelog)
                changelogDesc.push(change);
			
			model.addAttribute("overdue",overdue);
			model.addAttribute("overdueSize", overdue.size());
			model.addAttribute("todo",todo);
			model.addAttribute("todoSize", todo.size());
			model.addAttribute("changelog",changelog);
			model.addAttribute("changelogSize", changelog.size());

			return "Nexus";
		} else {
			return "login";
		}
	}
}