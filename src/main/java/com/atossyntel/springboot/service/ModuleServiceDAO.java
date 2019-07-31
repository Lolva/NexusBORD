package com.atossyntel.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.atossyntel.springboot.model.ModuleBean;

@Service
public class ModuleServiceDAO implements ModuleDAO {

	@Autowired
	private JdbcTemplate jTemplate;

	@Override
	public List<Map<String, Object>> getClasses(String username) {
		String sql = "SELECT e.class_id, e.role_id, s.stream_name, s.stream_id from enrollments e, classes c, streams s WHERE e.CLASS_ID = c.CLASS_ID AND c.STREAM_ID = s.STREAM_ID AND e.employee_id = ? order by e.role_id ";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, username);

		return results;
	}

	@Override
	public List<Map<String, Object>> getAssignments(String employee_id) {
		String sql = "SELECT * From  enrollments e, classes c, streams s, lessons l, modules m, assignments f WHERE e.CLASS_ID = c.CLASS_ID AND c.STREAM_ID=s.STREAM_ID AND l.STREAM_ID=s.STREAM_ID AND m.MODULE_ID=l.MODULE_ID AND f.MODULE_ID = m.MODULE_ID AND e.employee_id= ? AND f.status != 'inactive'";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, employee_id);
		return results;
	}

	@Override
	public List<Map<String, Object>> getModuleList(String employee_id) {
		String sql = "SELECT * From  enrollments e, classes c, streams s, lessons l, modules m WHERE e.CLASS_ID = c.CLASS_ID AND c.STREAM_ID=s.STREAM_ID AND l.STREAM_ID=s.STREAM_ID AND m.MODULE_ID=l.MODULE_ID AND e.employee_id= ?";
		List<Map<String, Object>> results;

		results = jTemplate.queryForList(sql, employee_id);
		for (Map<String, Object> r : results) {
			System.out.println(r.get("module_id").toString() + " " + r.get("class_id"));
		}
		return results;
	}

	@Override
	public List<Map<String, Object>> getModuleFiles(String employee_id) {
		String sql = "SELECT * From  enrollments e, classes c, streams s, lessons l, modules m, MODULE_FILES f WHERE e.CLASS_ID = c.CLASS_ID AND c.STREAM_ID=s.STREAM_ID AND l.STREAM_ID=s.STREAM_ID AND m.MODULE_ID=l.MODULE_ID AND f.MODULE_ID = m.MODULE_ID AND e.employee_id= ?";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, employee_id);
		return results;
	}

	@Override
	public List<Map<String, Object>> getModuleName(String module_id) {
		String sql = "Select module_name from modules where module_id =?";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, module_id);
		return results;
	}

	@Override
	public int insertModule(String modulename, int streamid) {
		String sql = "INSERT INTO modules (module_name) VALUES (?)";
		jTemplate.update(sql, modulename);
		String sql2 = "INSERT INTO lessons (stream_id, module_id) VALUES (?, (SELECT module_id FROM modules WHERE module_name = ?))";
		return jTemplate.update(sql2, streamid, modulename);
	}

	@Override
	public int deleteModule(int module_id) {
		String sql = "DELETE FROM lessons where module_id = ?";

		return jTemplate.update(sql, module_id);
	}

	@Override
	public int deleteAssignment(int assignment_id) {
		String sql = "update assignments SET module_id= '00000' where assignment_id = ?";

		return jTemplate.update(sql, assignment_id);
	}

	@Override
	public int deleteModuleFile(int module_file_id) {
		String sql = "DELETE FROM module_files where module_file_id = ?";

		return jTemplate.update(sql, module_file_id);
	}

	@Override
	public int updateModule(String module_name, int module_id) {
		String sql = "UPDATE modules SET module_name = ? WHERE module_id = ?";

		return jTemplate.update(sql, module_name, module_id);
	}

	@Override
	public int insertModuleFile(String module_id, MultipartFile file, String name, String desc) {
		String fullFile = file.getOriginalFilename();
		int index = fullFile.lastIndexOf(".");
		String fileName = fullFile.substring(0, index);
		String fileType = fullFile.substring(index + 1, fullFile.length());

		String sql = "Insert INTO module_Files(module_id, name, description, file_name, file_type) values (?, ?, ?, ?, ?)";
		return jTemplate.update(sql, module_id, name, desc, fileName, fileType);
	}

	@Override
	public int newAssignment(String name, MultipartFile file, String dueDate, String moduleId, String classId,
			String desc, String status) {
		String fullFile = file.getOriginalFilename();
		int index = fullFile.lastIndexOf(".");
		String fileName = fullFile.substring(0, index);
		String fileType = fullFile.substring(index + 1, fullFile.length());
		// String sql1 = "SELECT assignment_id FROM assignments where assignment_id = (
		// select max(assignment_id) from assignments) ";
		// int assignment_id = jTemplate.queryForObject(sql1, Integer.class);
		// assignment_id += 1;
		// String assignmentIdPlaceholder = number; // change this as needed until
		// function can be updated to match auto-increment funtionality

		String sqlQuery = "INSERT INTO assignments(assignment_name, module_id, "
				+ "description, due_date, status, file_name, file_type) "
				+ "VALUES( ?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?,?)";
		return jTemplate.update(sqlQuery, name, moduleId, desc, dueDate, status, fileName, fileType);
	}

	@Override
	public int editAssignmentFile(String name, MultipartFile file, String dueDate, String moduleId, String desc,
			String status, String assignment_id) {

		if (file.isEmpty()) {
			System.out.println("file null " + name + " " + dueDate + " " + desc + " " + status + " " + assignment_id);
			String sqlQuery = "Update assignments Set assignment_name = ?, module_id = ?, description = ?, due_date = TO_DATE(?,'YYYY-MM-DD'), status = ? WHERE assignment_id = ?";
			return jTemplate.update(sqlQuery, name, moduleId, desc, dueDate, status, assignment_id);
		} else {
			System.out.println("file not null " + name + " " + file.toString() + " " + dueDate + " " + desc + " "
					+ status + " " + assignment_id);
			String fullFile = file.getOriginalFilename();
			int index = fullFile.lastIndexOf(".");
			String fileName = fullFile.substring(0, index);
			String fileType = fullFile.substring(index + 1, fullFile.length());
			String sqlQuery = "Update assignments Set assignment_name = ?, module_id = ?, description = ?, due_date = TO_DATE(?,'YYYY-MM-DD'), status = ?, file_name =?, file_type=? WHERE assignment_id = ?";
			return jTemplate.update(sqlQuery, name, moduleId, desc, dueDate, status, fileName, fileType, assignment_id);
		}
	}

	/*
	 * FILE_NAME MODULE_ID DESCRIPTION
	 */
	@Override
	public int editModuleFile(String module_file_id, MultipartFile file, String module_id, String name,
			String description) {
		if (file.isEmpty()) {
			String sql = "Update module_files Set module_id = ?, name = ?, description = ? WHERE module_file_id = ?";
			return jTemplate.update(sql, module_id, name, description, module_file_id);
		} else {
			String fullFile = file.getOriginalFilename();
			int index = fullFile.lastIndexOf(".");
			String fileName = fullFile.substring(0, index);
			String fileType = fullFile.substring(index + 1, fullFile.length());
			String sql = "Update module_files Set module_id = ?, name = ?, description = ?, file_name = ?, file_type = ? WHERE module_file_id = ?";
			return jTemplate.update(sql, module_id, name, description, fileName, fileType, module_file_id);
		}
	}
}
