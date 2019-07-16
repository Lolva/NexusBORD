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
    public void add(GradeBean gradeBean) {
         gradeDAO.addGrade(gradeBean);
    }

    @Transactional
    public void edit(GradeBean gradeBean) {
        gradeDAO.updateGrade(gradeBean);
    }

    @Transactional
    public void delete(GradeBean gradeBean) {
        gradeDAO.deleteGrade(gradeBean);
    }

    @Override
    public Student getStudent(String studentId) {
        return gradeDAO.getStudent(studentId);
    }

	@Override
	public List<Student> getAllStudent(int assignmentID) {
		return gradeDAO.getAllStudents(assignmentID);
	}
    
    

  
    
}
