package com.atossyntel.springboot.model;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.List;

/**
 *
 * @author syntel
 */
public interface GradeDAO {
    public void add(Student student);
    public void edit(Student student);
    public void delete(int studentId);
    public Student getStudent(int studentId);
    public List getAllStudent();

 
    
}
