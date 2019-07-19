package com.atossyntel.springboot.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.atossyntel.springboot.model.UserLogin;

@Service
public class LoginDAOService implements LoginDAO {
	@Autowired
	private JdbcTemplate jTemplate;

	@Override // Returns whether or not the given UserLogin's username and password are both in the database as one row
	public boolean checkPassword(UserLogin e) {
		String sqlQuery = "SELECT COUNT(*) FROM employees WHERE employee_id=? AND password=?";
		return (jTemplate.queryForObject(sqlQuery, new Object[]{e.getUsername(), e.getPassword()}, Integer.class) > 0);
	}

	@Override // Returns whether or not the given UserLogin's username corresponds to an entry in the Enrollments table
    public boolean isEnrolled(UserLogin e) {
		String sqlQuery = "SELECT COUNT(*) FROM enrollments WHERE employee_id=?";
		return (jTemplate.queryForObject(sqlQuery, new Object[]{e.getUsername()}, Integer.class) > 0);
	}
}
