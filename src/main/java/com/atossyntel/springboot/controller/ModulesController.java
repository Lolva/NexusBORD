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
		model.addAttribute("modulesI", moduledao.getModulesI(session.getAttribute("username").toString()));
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

	@RequestMapping(value = "/deleteAssignment/{id}", method = RequestMethod.GET)
	public String deleteAssignment(Model model,
			@PathVariable("id") int id) {
		System.out.println(id);
		Map<String, Object> res = moduledao.getDeleteAssignment(id);
		storageService.deleteFile(res.get("file_name").toString() + "." + res.get("file_type").toString(), "/" + res.get("stream_id").toString() + "/" + res.get("module_id").toString() + "/assignmentFiles/");
		
		System.out.println(moduledao.deleteAssignment(id));
		
		// System.out.println(moduledao.insertStream(module.getStream_id()));
		// assignment.setModule_id(result.getParameter("module"));
		// model.addAttribute("module_id", module.getCourse_id());
		// model.addAttribute("module_name", module.getModule_name());

		return "redirect:/Modules";
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

	@RequestMapping(value = "/deleteModuleFile/{id}", method = RequestMethod.GET)
	public String deleteModuleFile(Model model, @PathVariable("id") int id) {
		Map<String, Object> res = moduledao.getDeleteModuleFile(id);
		storageService.deleteFile(res.get("file_name").toString() + "." + res.get("file_type").toString(), "/" + res.get("stream_id").toString() + "/" + res.get("module_id").toString() + "/moduleFiles/");
		
		System.out.println(moduledao.deleteModuleFile(id));
		// System.out.println(moduledao.insertStream(module.getStream_id()));
		// assignment.setModule_id(result.getParameter("module"));
		// model.addAttribute("module_id", module.getCourse_id());
		// model.addAttribute("module_name", module.getModule_name());

		return "redirect:/Modules";
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
	public String newModuleFile(Model model, HttpServletRequest request, @RequestParam("module_id") String module_id,
			@RequestParam("class_id") int class_id, @RequestParam("stream_id") int stream_id,
			@RequestParam("fileName") MultipartFile file, @RequestParam("name") String name, @RequestParam("desc") String desc) {
		
		System.out.println(request.getParameter("module_id"));
		System.out.println(request.getParameter("stream_id"));
		System.out.println(request.getParameter("class_id"));
		System.out.println(moduledao.insertModuleFile(module_id, file, name, desc));
		storageService.store(file, "/" + stream_id +  "/" + module_id + "/moduleFiles/");
		return "redirect:Modules";

	}
	@GetMapping("/downloadModule/{streamid}/{moduleid}/{modulefile}/{filetype}")
	public ResponseEntity<Resource> submitModule(Model model, @PathVariable("streamid") String streamid, @PathVariable("moduleid") String moduleid, @PathVariable("modulefile") String filename, @PathVariable("filetype") String type) throws MessagingException {
		System.out.println(streamid +  " " + moduleid + " " + filename);
		System.out.println("Download is starting...");
		StringBuilder folder = new StringBuilder("/" + streamid +  "/" + moduleid + "/moduleFiles/");
		Resource file = storageService.loadAsResource(filename + "." + type,folder.toString());
		System.out.println("Downloading done");
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
		
		//System.out.print("going to new page");
		//smtpMailSender.send("umezaki.tatsuya@gmail.com,alfabenojar@yahoo.com,jacob-gp@hotmail.com", 999);
	}
	@GetMapping("/downloadAssign/{streamid}/{classid}/{moduleid}/{modulefile}/{filetype}")
	public ResponseEntity<Resource> submitAssignment(Model model, @PathVariable("streamid") String streamid, @PathVariable("classid") String classid, @PathVariable("moduleid") String moduleid, @PathVariable("modulefile") String filename, @PathVariable("filetype") String type) throws MessagingException {
		System.out.println(streamid + " " + classid + " " + moduleid + " " + filename);
		System.out.println("Download is starting...");
		StringBuilder folder = new StringBuilder("/" + streamid + "/" + moduleid + "/assignmentFiles/");
		Resource file = storageService.loadAsResource(filename + "." + type,folder.toString());
		System.out.println("Downloading done");
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
		
		//System.out.print("going to new page");
		//smtpMailSender.send("umezaki.tatsuya@gmail.com,alfabenojar@yahoo.com,jacob-gp@hotmail.com", 999);
	}
	//String name, MultipartFile file, String dueDate, String moduleId, String classId, String desc, String status
	@RequestMapping(value = "/addAssignmentFile", method = RequestMethod.POST)
	public String newAssignmentFile(Model model, HttpServletRequest request, @RequestParam("name") String name, @RequestParam("module_id") String module_id,
			@RequestParam("class_id") String class_id, @RequestParam("stream_id") int stream_id,
			@RequestParam("fileName") MultipartFile file, @RequestParam("due_date") String due_date, @RequestParam("desc") String desc, @RequestParam("status") String status) {
		
		//System.out.println(name + " " + file.toString() + " " + module_id + " " + class_id + " " + due_date + " " + desc + " " + status);
		System.out.println(moduledao.newAssignment(name, file, due_date, module_id, class_id, desc, status));
		if(!file.isEmpty()) {
		storageService.store(file, "/" + stream_id + "/"  + module_id + "/assignmentFiles/");
		}
		return "redirect:Modules";

	}
	/*<input type="text" name="assignment_name" placeholder="Enter name" />
	<br> <br> <input type="text" name="desc"
			placeholder="Enter description" /> <br> <br> <select
			name="status">
			<option>active</option>
			<option>inactive</option>
			<option>completed</option>
		</select> <br> <br> <input type="date" name="due_date" />
		<br> <br> <select><c:forEach items="${modules}" var="mo"><option value="${mo.module_id}">${mo.module_name}</option></c:forEach></select> <input type="hidden" name="assignment_id"
			value="${k.assignment_id}" /><input type="hidden"
			name="class_id" value="${c.class_id }" /> <input
			type="hidden" name="stream_id" value="${c.stream_id }" />
		<input type="file" name="fileName" /><span><input>
		ASSIGNMENT_ID
        ASSIGNMENT_NAME
        MODULE_ID
        DESCRIPTION
        DUE_DATE
        STATUS
        FILE_NAME
        FILE_TYPE*/
	@RequestMapping(value="/editAssignmentFile", method = RequestMethod.POST)
	public String editAssignmentFile(Model model, @RequestParam("assignment_id") String assignment_id, @RequestParam("assignment_name") String assignment_name, @RequestParam("module_id") String module_id,
			@RequestParam("stream_id") int stream_id,
			@RequestParam("fileName") MultipartFile file, @RequestParam("due_date") String due_date, @RequestParam("desc") String desc, @RequestParam("status") String status, @RequestParam("class_id") String class_id) {
		System.out.println(assignment_name + " " + file.toString() + " " + module_id + " "  + due_date + " " + desc + " " + status + " " + assignment_id + " " + " " + stream_id + " " + class_id);
		System.out.println(moduledao.editAssignmentFile(assignment_name, file, due_date, module_id, desc, status, assignment_id));
		if(!file.isEmpty()) {
		storageService.store(file, "/" + stream_id + "/" + module_id + "/assignmentFiles/");
		}
		return "redirect:Modules";
	}
	//module_id, name, description, module_file_id, fileName, fileType
	@RequestMapping(value="/editModuleFile", method = RequestMethod.POST)
	public String editModuleFile(Model model, @RequestParam("module_id") String module_id, @RequestParam("name") String name, @RequestParam("desc") String desc, @RequestParam("module_file_id") String module_file_id, @RequestParam("file") MultipartFile file, @RequestParam("stream_id") String stream_id) {
		System.out.println(moduledao.editModuleFile(module_file_id, file, module_id, name, desc));
		if(!file.isEmpty()) {
			storageService.store(file, "/" + stream_id +  "/" + module_id + "/moduleFiles/");
		}
		return "redirect:Modules";
	}

}