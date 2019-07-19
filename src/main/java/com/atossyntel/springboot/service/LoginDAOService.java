package com.atossyntel.springboot.service;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.atossyntel.springboot.model.UserLogin;

@Service
public class LoginDAOService implements LoginDAO {
	@Autowired
	private JdbcTemplate jTemplate;

	private String getHashedPassword(UserLogin e) { // helper function for this.checkPassword(UserLogin)
		String sqlQuery = "SELECT password FROM employees WHERE employee_id=?";
		try { // return the employees table's (hashed) password value for the given employee_id
			return (jTemplate.queryForObject(sqlQuery, new Object[]{e.getUsername()}, String.class));
		} catch (EmptyResultDataAccessException ex) { // return null string if employee_id isn't in the database
			return null;
		}
	}
	
	@Override
	public boolean checkPassword(UserLogin e) {
		String hashed = this.getHashedPassword(e);
		if(hashed != null) { // ensures the employee_id was found in the database
			try { // returns whether or not the passwords match (see Encrypter.java)
				return Encrypter.matchPassword(e.getPassword().toCharArray(), hashed);
				
			// errors that can be thrown by the Encrypter:
			// (you may want to log these because they should never ever be thrown)
			} catch (NoSuchAlgorithmException e1) {
				System.out.println(e1.getMessage());
				return false;
			} catch (InvalidKeySpecException e1) {
				System.out.println(e1.getMessage());
				return false;
			}
		} else { // if the employee_id is not in the database:
			return false;
		}
	}

	@Override // Returns whether or not the given UserLogin's username corresponds to an entry in the Enrollments table
    public boolean isEnrolled(UserLogin e) {
		String sqlQuery = "SELECT COUNT(*) FROM enrollments WHERE employee_id=?";
		return (jTemplate.queryForObject(sqlQuery, new Object[]{e.getUsername()}, Integer.class) > 0);
	}
}