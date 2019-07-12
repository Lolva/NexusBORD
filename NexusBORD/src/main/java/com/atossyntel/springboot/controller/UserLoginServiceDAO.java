/*package com.atossyntel.springboot.controller;

import java.util.ArrayList;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserLoginServiceDAO implements UserLoginDAO{    
    private DataSource dataSource;
   // private JdbcTemplate jTemplate;

    public UserLoginServiceDAO() {
    }

    public UserLoginServiceDAO(DataSource dataSource, JdbcTemplate jTemplate) {
        this.dataSource = dataSource;
        this.jTemplate = jTemplate;
    }
    

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds; 
       jTemplate = new JdbcTemplate(ds);
    }

    @Override
    public boolean checkPassword(UserLogin e) {
        //Take in the userlogin object and bring back the password stored in database
        boolean tf;
        int result;
        String sqlQuery = "SELECT COUNT(password) FROM userlogins WHERE username = ? AND password = ?"; 
        result = jTemplate.update(sqlQuery, e.getUsername(), e.getPassword());
        if(result > 0)
            tf = true;
        else
            tf = false;
        return tf;
    }
    
   
}
*/
