package com.atossyntel.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atossyntel.springboot.model.UserLogin;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@Service
public class LoginDAOService implements LoginDAO {
	@Autowired
	private JdbcTemplate jTemplate;

	@Override
	public boolean checkPassword(UserLogin e) {
		// Using UserLogin object, check username+password against employee table
		String sqlQuery = "SELECT COUNT(*) FROM employees WHERE employee_id=? AND password=?";
		if(jTemplate.queryForObject(sqlQuery, new Object[]{e.getUsername(), e.getPassword()}, Integer.class) > 0) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override // Returns whether or not the given UserLogin's username corresponds to an entry in the Enrollments table
    public boolean isEnrolled(UserLogin e) {
		String sqlQuery = "SELECT COUNT(*) FROM enrollments WHERE employee_id=?";
		return (jTemplate.queryForObject(sqlQuery, new Object[]{e.getUsername()}, Integer.class) > 0);
	}
}
