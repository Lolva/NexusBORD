package com.atossyntel.springboot.controller;

//import com.atossyntel.springboot.DataSourceBean;
import javax.sql.DataSource;

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

    public UserLoginServiceDAO() {
    }
    @Override
    public boolean checkPassword(UserLogin e) {
        //Take in the userlogin object and check if the username/password combination returns atleast 1 result
        boolean tf;
        int result;
        String sqlQuery = "SELECT COUNT(*) FROM userlogins WHERE username = ? AND password = ?"; 
        List<Map<String, Object>> results = this.jTemplate.queryForList(sqlQuery, e.getUsername(), e.getPassword());
        return Integer.parseInt(results.get(0).get("COUNT(*)").toString()) > 0;
    }
	
    
   
}

