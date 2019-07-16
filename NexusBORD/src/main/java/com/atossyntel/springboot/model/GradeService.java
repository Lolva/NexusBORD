package com.atossyntel.springboot.model;

import java.util.List;


/**
 *
 * @author syntel
 */
public interface GradeService {
    public void add(GradeBean gradeBean);
    public void edit(GradeBean gradeBean);
    public void delete(GradeBean gradeBean);
    public Student getStudent(String studentId);
    public List<Student> getAllStudent(int assignmentID);
    
}

