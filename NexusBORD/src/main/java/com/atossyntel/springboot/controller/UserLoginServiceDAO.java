package com.atossyntel.springboot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class UserLoginServiceDAO implements UserLoginDAO{    
	@Autowired
    private JdbcTemplate jTemplate;
    
    @Override
    public boolean checkPassword(UserLogin e) {
    	// Using UserLogin object, check username + password against employee table
        String sqlQuery = "SELECT COUNT(*) FROM employee WHERE employee_id=? AND password=?";
        List<Map<String, Object>> results = this.jTemplate.queryForList(sqlQuery, e.getUsername(), e.getPassword());
        return Integer.parseInt(results.get(0).get("COUNT(*)").toString()) > 0;
    }  
}