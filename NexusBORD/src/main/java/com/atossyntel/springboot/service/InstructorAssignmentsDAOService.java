package com.atossyntel.springboot.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atossyntel.springboot.model.StudentAssignmentsBean;

@Repository
@Transactional
public class InstructorAssignmentsDAOService implements InstructorAssignmentsDAO {
	@Autowired
	private JdbcTemplate jTemplate;

	@Override
	public List<Map<String, Object>> getAssignment() {
		String sql = "SELECT ASSIGNMENT_NAME, DUE_DATE, MAX_POINTS, ATTACHED_FILES From Assignments";

		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql);
		List<StudentAssignmentsBean> list;
		for (Map<String, Object> m : results) {
			// System.out.println(m.toString());
		}
		return results;

	} /*
		 * public List<AssignmentBean> getAssignment(){ List<AssignmentBean>
		 * employeeslist = jTemplate.query("SELECT * FROM assignments", new
		 * AssignmentRowMapper()); for(AssignmentBean r: employeeslist) {
		 * System.out.println(r.toString()); } return employeeslist; }
		 */
	@Override
	public int sendAssignment() {
		final String insert = "insert into assignments values (?,?,?,?)";

		int insertedRows = jTemplate.update(insert, new PreparedStatementSetter() {
			 public void setValues(PreparedStatement preparedStatement) throws SQLException {
		            preparedStatement.setInt(1, 1);
		         }
		});
		//List<Map<String, Object>> results;
		//results = jTemplate.queryForList(sql);
		//List<StudentAssignmentsBean> list;
//		for (Map<String, Object> m : results) {
//			// System.out.println(m.toString());
//		}
		return insertedRows;

	}
}
