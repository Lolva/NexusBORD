package com.atossyntel.springboot.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atossyntel.springboot.model.GradeService;
import com.atossyntel.springboot.model.Student;

/**
 *
 * @author syntel
 */
@Controller
public class GradesController {
    @Autowired
    private GradeService gradeService;
    
    
    @RequestMapping("/index")
    public String setupForm(Map<String, Object>map){
        Student student= new Student();
        map.put("student",student);
        map.put("studentList",gradeService.getAllStudent());
        return "student";
    }
    
    @RequestMapping(value = "/student.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Student student,BindingResult result,@RequestParam String action,Map<String, Object>map) {
    Student studentResult=new Student();
    switch(action.toLowerCase()){
        case "add":
            gradeService.add(student);
            studentResult=student;
            break;
        case "edit" :
            gradeService.edit(student);
            studentResult=student;
            break;
        case "delete":
            gradeService.delete(student.getStudentId());
            studentResult=new Student();
            break;
            
    }
    map.put("student",studentResult);
    map.put("studentList",gradeService.getAllStudent());
      return "student";
  }
    
}