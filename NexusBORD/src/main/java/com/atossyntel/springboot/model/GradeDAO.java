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
<<<<<<< HEAD
    public Student getStudent(String studentId, int assignmentID);
=======
    public Student getStudent(String studentId);
>>>>>>> 9c905369aaf5b3da1b26a7df3fbd969d4c09a6af
    //public List getAllStudent();
    public List<Student> getAllStudents(int assignmentID);
    
 
    
}
