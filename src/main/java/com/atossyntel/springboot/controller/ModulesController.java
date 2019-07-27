package com.atossyntel.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atossyntel.springboot.model.InstructorAssignmentsBean;
import com.atossyntel.springboot.model.ModuleBean;
import com.atossyntel.springboot.service.ModuleDAO;
import com.atossyntel.springboot.storage.StorageService;

@Controller
public class ModulesController {

	@Autowired
	ModuleDAO moduledao;
	@Autowired
	 StorageService storageService;

	@RequestMapping(value = "/Modules", method = RequestMethod.GET)
	public String init(Model model, HttpSession session) {
		List<Map<String, Object>> classes = moduledao.getClasses(session.getAttribute("username").toString());

		model.addAttribute("classes", classes);
		model.addAttribute("modules", moduledao.getModuleList(session.getAttribute("username").toString()));
		model.addAttribute("modulefiles", moduledao.getModuleFiles(session.getAttribute("username").toString()));
		model.addAttribute("moduleassigns", moduledao.getAssignments(session.getAttribute("username").toString()));
		/*
		 * Map<String, Object> mom = new HashMap<String, Object>(); for (Map<String,
		 * Object> m : classes) { String classid =m.get("class_id").toString();
		 * List<List<Map<String, Object>>> modules = new ArrayList<List<Map<String,
		 * Object>>>(); //List<Map<String, Object>> res = new ArrayList<Map<String,
		 * Object>>();
		 * modules.add(moduledao.getModuleList(m.get("class_id").toString()));
		 * Map<String, Object> modulemap = new HashMap<String, Object>();
		 * for(List<Map<String,Object>> a : modules) { //List<List<List<Map<String,
		 * Object>>>> assigns= new ArrayList<List<List<Map<String,Object>>>>();
		 * for(Map<String, Object> z: a) { List<List<Map<String, Object>>> assigns = new
		 * ArrayList<List<Map<String, Object>>>(); String moduleid =
		 * z.get("module_id").toString(); System.out.println(moduleid);
		 * assigns.add(moduledao.getModuleName(moduleid));
		 * assigns.add(moduledao.getModuleFiles(moduleid));
		 * assigns.add(moduledao.getAssignments(moduleid));
		 * 
		 * modulemap.put(moduleid, assigns); } } mom.put(classid, modulemap); }
		 * 
		 * 
		 * 
		 * System.out.println(mom.toString());
		 * 
		 * model.addAttribute("modules", mom);
		 */
		return "Modules";
	}

	@RequestMapping(value = "/addModule", method = RequestMethod.POST)
	public String newModule(Model model, @ModelAttribute("newmodule") ModuleBean module) {
		System.out.println(module.toString());
		System.out.println(moduledao.insertModule(module.getModule_name(), module.getStream_id()));
		// assignment.setModule_id(result.getParameter("module"));
		// model.addAttribute("module_id", module.getCourse_id());
		// model.addAttribute("module_name", module.getModule_name());

		return "redirect:Modules";
	}

	@RequestMapping(value = "/deleteAssignment", method = RequestMethod.POST)
	public String deleteAssignment(Model model,
			@ModelAttribute("deleteassignment") InstructorAssignmentsBean assignment) {
		System.out.println(assignment.toString());
		System.out.println(moduledao.deleteAssignment(assignment.getAssignment_id()));
		// System.out.println(moduledao.insertStream(module.getStream_id()));
		// assignment.setModule_id(result.getParameter("module"));
		// model.addAttribute("module_id", module.getCourse_id());
		// model.addAttribute("module_name", module.getModule_name());

		return "redirect:Modules";
	}

	@RequestMapping(value = "/deleteModule", method = RequestMethod.POST)
	public String deleteModule(Model model, @ModelAttribute("module") ModuleBean module) {
		System.out.println(module.toString());
		System.out.println(moduledao.deleteModule(module.getModule_id()));
		// System.out.println(moduledao.insertStream(module.getStream_id()));
		// assignment.setModule_id(result.getParameter("module"));
		// model.addAttribute("module_id", module.getCourse_id());
		// model.addAttribute("module_name", module.getModule_name());

		return "redirect:Modules";
	}

	@RequestMapping(value = "/deleteModuleFile", method = RequestMethod.POST)
	public String deleteModuleFile(Model model, @ModelAttribute("module") ModuleBean module) {
		System.out.println(module.toString());
		System.out.println(moduledao.deleteModuleFile(module.getModule_file_id()));
		// System.out.println(moduledao.insertStream(module.getStream_id()));
		// assignment.setModule_id(result.getParameter("module"));
		// model.addAttribute("module_id", module.getCourse_id());
		// model.addAttribute("module_name", module.getModule_name());

		return "redirect:Modules";
	}

	@RequestMapping(value = "/updateModule", method = RequestMethod.POST)
	public String updateModule(Model model, @ModelAttribute("module") ModuleBean module) {
		System.out.println(module.toString());
		System.out.println(moduledao.updateModule(module.getModule_name(), module.getModule_id()));
		// System.out.println(moduledao.insertStream(module.getStream_id()));
		// assignment.setModule_id(result.getParameter("module"));
		// model.addAttribute("module_id", module.getCourse_id());
		// model.addAttribute("module_name", module.getModule_name());

		return "redirect:Modules";
	}

	@RequestMapping(value = "/addModuleFile", method = RequestMethod.POST)
	public String newModuleFile(Model model, HttpServletRequest request, @RequestParam("module_id") int module_id,
			@RequestParam("class_id") int class_id, @RequestParam("stream_id") int stream_id,
			@RequestParam("fileName") MultipartFile file) {
		
		System.out.println(request.getParameter("module_id"));
		System.out.println(request.getParameter("stream_id"));
		System.out.println(request.getParameter("class_id"));
		System.out.println(moduledao.insertModuleFile(request.getParameter("module_id"), file));
		return "redirect:Modules";

	}
	@GetMapping("/download/{streamid}/{classid}/{moduleid}/{modulefile}")
	public ResponseEntity<Resource> submit(Model model, @PathVariable("streamid") String streamid, @PathVariable("classid") String classid, @PathVariable("moduleid") String moduleid, @PathVariable("modulefile") String filename) throws MessagingException {
		System.out.println("Download is starting...");
		StringBuilder folder = new StringBuilder("/" + streamid + "/" + classid + "/" + moduleid + "/");
		Resource file = storageService.loadAsResource(filename,folder.toString());
		System.out.println("Downloading done");
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
		
		//System.out.print("going to new page");
		//smtpMailSender.send("umezaki.tatsuya@gmail.com,alfabenojar@yahoo.com,jacob-gp@hotmail.com", 999);
	}
}