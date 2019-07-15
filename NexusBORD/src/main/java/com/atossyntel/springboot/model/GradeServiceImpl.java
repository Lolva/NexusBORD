package com.atossyntel.springboot.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author syntel
 */
@Service        
public class GradeServiceImpl implements GradeService {
    
    @Autowired
    private GradeDAO gradeDAO;

    @Transactional
    public void add(Student student) {
         gradeDAO.add(student);
    }

    @Transactional
    public void edit(Student student) {
        gradeDAO.edit(student);
    }

    @Transactional
    public void delete(int studentId) {
        gradeDAO.delete(studentId);
    }

    @Override
    public Student getStudent(int studentId) {
        return gradeDAO.getStudent(studentId);
    }

    @Override
    public List getAllStudent() {
       return gradeDAO.getAllStudent();
    }

  
    
}
