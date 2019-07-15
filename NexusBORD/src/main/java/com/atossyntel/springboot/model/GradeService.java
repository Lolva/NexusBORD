package com.atossyntel.springboot.model;

import java.util.List;


/**
 *
 * @author syntel
 */
public interface GradeService {
    public void add(Student student);
    public void edit(Student student);
    public void delete(int studentId);
    public Student getStudent(int studentId);
    public List getAllStudent();
    
}

