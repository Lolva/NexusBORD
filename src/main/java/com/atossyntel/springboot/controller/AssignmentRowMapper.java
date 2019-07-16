package com.atossyntel.springboot.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author syntel
 */
public class AssignmentRowMapper implements RowMapper<AssignmentBean>{

    @Override
    public AssignmentBean mapRow(ResultSet rs, int i) throws SQLException {
        AssignmentBean emp1 = new AssignmentBean();
        
        emp1.setAssignmentName(rs.getString("assignment_name"));
        emp1.setDue_date(rs.getString("due_date"));
        String submitted = rs.getString("submission_date");
        if(submitted != null) {
        	 emp1.setSubmitted(true);
        } else {
        	 emp1.setSubmitted(false);
        }
       
        return emp1;
    }
    
}