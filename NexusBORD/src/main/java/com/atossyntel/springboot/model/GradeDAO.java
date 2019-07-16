package com.atossyntel.springboot.model;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.List;

/**
 *
 * @author syntel
 */
public interface GradeDAO {
	public void addGrade(GradeBean gradeBean);
	//set new grade or alter a grade if needed
    public void updateGrade(GradeBean gradeBean);
    //returns a grade from database
    public int getGrade(GradeBean gradeBean);
    //sets grade to null
    public void deleteGrade(GradeBean gradeBean);
    public Student getStudent(String studentId, int assignmentID);
    //public List getAllStudent();
    public List<Student> getAllStudents(int assignmentID);
    
 
    
}
