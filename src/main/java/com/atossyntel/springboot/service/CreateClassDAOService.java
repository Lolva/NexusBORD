package com.atossyntel.springboot.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.Types;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.atossyntel.springboot.model.ClassBean;

@Repository
@Transactional
public class CreateClassDAOService implements CreateClassDAO {
	
	@Autowired
    private JdbcTemplate jTemplate;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.jTemplate = jTemplate;    
	} 
	
	
	
	public void addClasses(String class_Id,String stream_Id, Date start_date, Date end_date) {
		String sql= "INSERT INTO CLASSES(CLASS_ID,STREAM_ID,START_DATE,END_DATE) VALUES(?, ?, ?, ?)";
		 Object[] params = new Object[] {class_Id , stream_Id, new Date(), new Date() };
		 int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP };
			int row = jTemplate.update(sql, params, types);
           //System.out.println(row + " row inserted."); 
		
	
	}
		
	public int update(ClassBean classToBeAdded){    
		    String sql="update classes set class_id='"+classToBeAdded.getClass_Id()+"', start_date="+classToBeAdded.getStart_date()+",end_date='"+classToBeAdded.getEnd_date()+"' where stream_id="+classToBeAdded.getStream_Id()+"";    
		    return jTemplate.update(sql);    
		}   	
	
	public int delete(int class_Id){    
	    String sql="delete from classes where class_id="+class_Id+"";    
	    return jTemplate.update(sql);    
	}  
	
	/*public List<ClassBean> getClasses(){    
	    return jTemplate.query("select * from classes",new RowMapper<ClassBean>() {   
	        public ClassBean mapRow(ResultSet rs, int row) throws SQLException {    
	            ClassBean c=new ClassBean();    
	            c.setClass_Id(rs.getInt(1));    
	            c.setStart_date(rs.getString(2));    
	            c.setEnd_date(rs.getString(3));    
	            c.setStream_Id(rs.getInt(4));    
	            return c;    
	        }    
	    });  
	    */ 
    

	
	}
