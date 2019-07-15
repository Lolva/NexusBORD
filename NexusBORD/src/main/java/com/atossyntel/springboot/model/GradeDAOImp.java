package com.atossyntel.springboot.model;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author syntel
 */

@Repository
public abstract class GradeDAOImp implements GradeDAO{
    @Autowired
    private SessionFactory session;
   
   public void add(Student student){
       session.getCurrentSession().save(student);
   } 
   public void edit(Student student){
       session.getCurrentSession().update(student);
   }
   public void delete(int studentId){
       session.getCurrentSession().delete(getStudent(studentId));
   }

    @Override
    public Student getStudent(int studentId) {
       return (Student)session.getCurrentSession().get(Student.class,studentId);
    }

    @Override
    public List getAllStudent() {
       return session.getCurrentSession().createQuery("from Student").list();
    }

   
    
    }
