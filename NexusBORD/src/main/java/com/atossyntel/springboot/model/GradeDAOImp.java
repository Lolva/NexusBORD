package com.atossyntel.springboot.model;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author syntel
 */
@Transactional
@Repository
public class GradeDAOImp implements GradeDAO{
	private JdbcTemplate jTemplate;
    
   //private SessionFactory session;
   
   public void updateGrade(GradeBean gradeBean){
    	String SQLQuery = "UPDATE Student_Submissions SET grade = sub_grade WHERE Submission_ID = sub_id ";
        this.jTemplate.update(SQLQuery, gradeBean.getSub_grade(), gradeBean.getSub_id());
       //session.getCurrentSession().save(student);
   } 
   public int getGrade(GradeBean gradeBean){
	   String SQLQuery = "SELECT Grade FROM Student_Submissions WHERE Submission_ID= sub_id";
       int grade = this.jTemplate.queryForObject(SQLQuery, new Object[] {gradeBean.getSub_id()}, Integer.class);
       return grade;
       //session.getCurrentSession().update(student);
   }
   public void deleteGrade(GradeBean gradeBean){
	   String SQLQuery = "UPDATE Student_Submissions SET grade = null WHERE Submission_ID = sub_id ";
       this.jTemplate.update(SQLQuery, gradeBean.getSub_id());
       //session.getCurrentSession().delete(getStudent(studentId));
   }
   
   @Override
   public void addGrade(GradeBean gradeBean) {
	   String SQLQuery = "INSERT INTO Student_Submissions Values(subID,assID,stuID,subDate,subGrade,files)";
	   this.jTemplate.update(SQLQuery,gradeBean.getSub_id(), gradeBean.getAssignment_id(),gradeBean.getStudent_id(), gradeBean.getSubmission_date(), gradeBean.getSub_grade(), gradeBean.getAttached_files());
   }
    
   /*
    @Override
    public Student getStudent(int studentId) {
       return (Student)session.getCurrentSession().get(Student.class,studentId);
    }

    @Override
    public List getAllStudent() {
       return session.getCurrentSession().createQuery("from Student").list();
    }
  */
   
    
    }
