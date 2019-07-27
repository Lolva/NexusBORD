package com.atossyntel.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.util.List;
import java.util.Map;


import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.util.FileCopyUtils;

import com.atossyntel.springboot.model.ClassBean;
import com.atossyntel.springboot.model.EmployeeBean;
import com.atossyntel.springboot.model.EnrollmentBean;
import com.atossyntel.springboot.service.ClassesDAO;
import com.atossyntel.springboot.storage.FileSystemStorageService;

@Controller
public class ClassesController {
	@Autowired
	ClassesDAO classdao;
	
	@Autowired
	FileSystemStorageService storageService;
	
	@RequestMapping(value = "/Classes", method = {RequestMethod.GET, RequestMethod.POST})
	public String init(Model model,  HttpSession session) {
		List<Map<String, Object>> allStudents = classdao.getAllStudents();
		model.addAttribute("allStudents", allStudents);
		//In progress
		List<Map<String,Object>> activeInstructorClasses = classdao.getActiveInstructorClasses((String) session.getAttribute("username"));	
		model.addAttribute("activeInstructorClasses", activeInstructorClasses);
		
		List<Map<String,Object>> inactiveInstructorClasses = classdao.getInactiveInstructorClasses((String) session.getAttribute("username"));
		model.addAttribute("inactiveInstructorClasses", inactiveInstructorClasses);
		
		List<Map<String, Object>> activeStudents = classdao.getActiveStudents();
		model.addAttribute("activeStudents", activeStudents);
		
		List<Map<String, Object>> getAllClasses = classdao.getAllClasses();
		model.addAttribute("allClassIds", getAllClasses);
		
		List<Map<String, Object>> stream=classdao.getStream();
		model.addAttribute("stream",stream);
		
		List<Map<String, Object>> activeClassIds = classdao.getActiveClasses();
		List<Map<String, Object>> inactiveClassIds = classdao.getInactiveClasses();
		
		model.addAttribute("activeClassIds", activeClassIds);
		model.addAttribute("inactiveClassIds", inactiveClassIds);
	    return "Classes";
	}
	//C:\Users\syntel\Desktop\NexusBORD
	//C:/NexusBORD-classes-view6
		private static final String FILE_PATH =  "src/main/resources/";
		
		@RequestMapping("resources/{fileName:.+}")
	public ResponseEntity<Resource> download(HttpServletRequest request,HttpServletResponse response,@PathVariable("fileName")String filename) throws IOException {
//		File file=new File(file_path+filename);
//		if(file.exists()) {
//			String mimeType=URLConnection.guessContentTypeFromName(file.getName());
//			if(mimeType==null) {
//				mimeType = "application/octet-stream";
//			}
//			response.setContentType(mimeType);
//			response.setHeader("Content-Disposition",String.format("inline; filename=\""+file.getName()+ "\""));
//			//response.setHeader("Content-Disposition",String.format("attachment; filename=\""+file.getName()+ "\""));
//			response.setContentLength((int) file.length());
//			InputStream inputStream=new BufferedInputStream(new FileInputStream(file));
//			FileCopyUtils.copy(inputStream, response.getOutputStream());
//		}
		System.out.println("Downloading excel file...");
		Resource file = storageService.loadExcelAsResource(filename,FILE_PATH);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
		
	  }
	

	 @RequestMapping(value = "/changeClass", method = RequestMethod.POST)
	    public String submit(Model model, @ModelAttribute("enrollmentBean") EnrollmentBean EnrollmentBean) {
	        if (EnrollmentBean != null) {
//	        	System.out.println("Change Class");
//	        	System.out.println(EnrollmentBean.getEmployee_ID() + " " + EnrollmentBean.getClass_ID());
	        	 classdao.changeClassId(EnrollmentBean.getEmployee_ID(), EnrollmentBean.getClass_ID(), EnrollmentBean.getOld_Class_ID()); 

	                return "redirect:Classes.html";
	        
	        } else {
	        	return "Classes";
	        }
	       
	        	
	   }
	 
	 @RequestMapping(value = "/deleteClass", method = RequestMethod.POST)
	 public String submit1(Model model, @ModelAttribute("employeeBean") EmployeeBean EmployeeBean) {
	     if (EmployeeBean != null) {
	        classdao.deleteClass(EmployeeBean.getClass_id());
	           return "redirect:Classes.html";	
	        } else {
	        	return "/Classes";
	        }
	       
	        	
	   }
	 @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	 public String submit2(Model model, @ModelAttribute("enrollementBean") EnrollmentBean EnrollmentBean) {
	     if (EnrollmentBean != null) {
	        classdao.deleteEmployee(EnrollmentBean.getClass_ID(), EnrollmentBean.getEmployee_ID()); 
	           return "redirect:Classes.html";	
	        } else {
	        	return "Classes";
	        }
	       
	        	
	   }
	 @RequestMapping(value = "/addClass", method = RequestMethod.POST)
	   public String submit(Model model, @ModelAttribute("classBean") ClassBean ClassBean,  HttpSession session) {
		   if (ClassBean != null) {
			   classdao.addClasses((String) session.getAttribute("username"), ClassBean.getStream_Id(),ClassBean.getStart_date(),ClassBean.getEnd_date());
		   return "redirect:Classes.html";
	   } else {
	   	return "Classes";
	   }

	}
	 
	 @RequestMapping(value="/editClass", method = RequestMethod.POST)
	 public String submit1(Model model, @ModelAttribute("classBean") ClassBean ClassBean) {
		 if(ClassBean != null) {
			 classdao.editClass(ClassBean.getClass_Id(), ClassBean.getStart_date(), ClassBean.getEnd_date());
			 return "redirect:Classes";
		 } else {
			 return "redirect:Classes";
		 }
	 }
	 @RequestMapping(value="/upload", method = RequestMethod.POST)
	   public String submit(@RequestParam("file") MultipartFile file, Model model, @ModelAttribute("employeeBean") EmployeeBean EmployeeBean) throws IOException {
		   if(EmployeeBean != null) {
			  classdao.addEmployees(file, file.getName(), EmployeeBean.getClass_id());
			  return "redirect:Classes";
		   } else {
			   return "redirect:Classes";
		   }
		   
	   }
}
