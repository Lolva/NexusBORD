package com.atossyntel.springboot.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.atossyntel.springboot.controller.SmtpMailSender;
import com.atossyntel.springboot.model.EnrollmentBean;

@Repository
@Transactional
public class ClassesDAOService implements ClassesDAO {
	@Autowired
    private JdbcTemplate jTemplate;
	
	@Autowired
    private SmtpMailSender sms;
    @Autowired
    private EmailDAOService emailDAO; 
    private EnrollmentBean enroll;
    
	
	
	@Override
	public List<Map<String,Object>> getStudents(String classId) {
		String sql = "Select e.first_name, e.last_name, e.email From Employees e, Enrollments s WHERE e.employee_id = s.employee_id AND s.class_ID = ? ORDER BY s.role_id";

		List<Map<String,Object>> results;
		results = jTemplate.queryForList(sql, classId);
		 return results;
		
	}
	
	@Override
	public List<Map<String,Object>> getEmployeeIds() {
		String sql = "Select employee_id From Employees";

		List<Map<String,Object>> results;
		results = jTemplate.queryForList(sql);
		 return results;
		
	}

	@Override
	public List<Map<String, Object>> getActiveClasses() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");  
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime begin = now.plusDays(7);
		String date = dtf.format(now);
		String start = dtf.format(begin);
		String sql = "Select class_id, to_char(start_date, 'Month dd yyyy') AS start_date, to_char(end_date, 'Month dd yyyy') AS end_date From Classes WHERE start_date<=? AND end_date>=?";		
		List<Map<String,Object>> results;
		results = jTemplate.queryForList(sql, start, date);
		return results;
		
	}
	@Override
	public List<Map<String, Object>> getInactiveClasses() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");  
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime begin = now.plusDays(7);
		String date = dtf.format(now);
		String start = dtf.format(begin);
		String sql = "Select class_id, to_char(start_date, 'Month dd yyyy') AS start_date, to_char(end_date, 'Month dd yyyy') AS end_date From Classes WHERE start_date>? OR end_date<?";		
		List<Map<String,Object>> results;
		results = jTemplate.queryForList(sql, start, date);
		return results;
		
	}
	@Override
	public List<Map<String,Object>> getActiveInstructorClasses(String username) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");  
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime begin = now.plusDays(7);
		String date = dtf.format(now);
		String start = dtf.format(begin);
		String sql = "SELECT s.class_id, to_char(c.start_date, 'Month dd yyyy') AS start_date, to_char(c.end_date, 'Month dd yyyy') AS end_date "
				+ "FROM enrollments s, Classes c "
				+ "WHERE s.class_id = c.class_id AND s.employee_id = ? AND s.role_id = 1 AND c.start_date<=? AND c.end_date>=?";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, username, start, date);
		return results;
	}
	
	@Override
	public List<Map<String,Object>> getInactiveInstructorClasses(String username) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");  
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime begin = now.plusDays(7);
		String start = dtf.format(begin);
		String sql = "SELECT s.class_id, to_char(c.start_date, 'Month dd yyyy') AS start_date, to_char(c.end_date, 'Month dd yyyy') AS end_date "
				+ "FROM enrollments s, Classes c "
				+ "WHERE s.class_id = c.class_id AND s.employee_id = ? AND s.role_id = 1 AND c.start_date>?";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql, username, start);
		return results;
	}
	
	
	@Override
	public List<Map<String, Object>> getAllClasses(String empId) {
//		String sqlQuery = "SELECT class_id FROM Classes WHERE employee_id = ?";
		String sqlQuery = "SELECT s.class_id FROM Enrollments s, Classes c WHERE s.class_id = c.class_id AND s.employee_id = ? AND s.role_id = 1";
		List<Map<String,Object>> results;
		results = jTemplate.queryForList(sqlQuery, empId);
		return results;
	}
	public void addClasses(String employee_id, String stream_Id, Date start_date, Date end_date) {
		String sql= "INSERT INTO CLASSES(STREAM_ID,START_DATE,END_DATE) VALUES(?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jTemplate.update(
	              connection -> {
	                  PreparedStatement ps = connection.prepareStatement(sql, new String[]{"class_id"});
	                  ps.setString(1, stream_Id);
	                  ps.setDate(2, start_date);
	                  ps.setDate(3, end_date);
	                  return ps;
	              }, keyHolder);
		String key = (String) keyHolder.getKeys().get("class_id");
		String addInstructor = "INSERT INTO Enrollments(employee_id, class_id, role_id) VALUES(?,?,?)";
		this.jTemplate.update(addInstructor, employee_id, key, 1);
	}
	
	@Override
	public List<Map<String, Object>> getStream(){
		String sql = "Select stream_name, stream_id From Streams";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql);
		return results;
		
	}
	
	@Override
	public List<Map<String, Object>> getModules(){
		String sql = "SELECT m.module_name, l.module_id, l.stream_id FROM Lessons l, Modules m WHERE l.module_id = m.module_id";
		List<Map<String, Object>> results;
		results = jTemplate.queryForList(sql);
		return results;
		
	}

	@Override
	public List<Map<String, Object>> getActiveStudents() {
		String sql = "SELECT UNIQUE s.class_id, s.employee_id, e.first_name, e.last_name, e.email, s.role_id FROM Employees e, Enrollments s WHERE e.employee_id = s.employee_id ORDER BY s.role_id";
		List<Map<String,Object>> results;
		results = jTemplate.queryForList(sql);
		return results;
	}
	
	@Override
	public List<Map<String, Object>> getAllStudents() {
		String sql = "SELECT employee_id, first_name, last_name, email FROM Employees";
		List<Map<String,Object>> results;
		results = jTemplate.queryForList(sql);
		return results;
	}


	@Override
	public void changeClassId(String EmpId, String classId, String oldId) {
		String checkquery = "SELECT Count(*) FROM Enrollments WHERE employee_id=?";
		String sqlUpdateQuery = "UPDATE Enrollments SET class_id=? WHERE employee_id=? AND class_id=?";
		System.out.println("EI: " + EmpId + " CI: " + classId + " OI: " + oldId);
		String sqlInsertQuery = "INSERT INTO Enrollments(employee_id, class_id, role_id) VALUES(?,?,?)";
		Object results = this.jTemplate.queryForObject(checkquery, new Object[]{EmpId}, Integer.class);
		if ( ((Number) results).intValue() > 0) {
			if (oldId.equals(null)) {
				this.jTemplate.update(sqlUpdateQuery, classId, EmpId, oldId);
			} else {
				this.jTemplate.update(sqlInsertQuery, EmpId, classId, 2);
			}
		} else {
			this.jTemplate.update(sqlInsertQuery, EmpId, classId, 2);
		}
		
	}
	@Override
	public void deleteEmployee(String class_Id, String employee_id) {
		String sqlQuery = "Delete FROM Enrollments WHERE class_id=? AND employee_id=?";	
		this.jTemplate.update(sqlQuery, class_Id, employee_id);
	}
	
	@Override
	public void deleteClass(String class_Id) {
		String sqlQuery1 = "DELETE FROM Enrollments WHERE class_id=?";
		String sqlQuery2 = "Delete FROM Classes WHERE class_id=?";
		String sqlQuery3 = "SELECT Count(*) FROM Enrollments WHERE class_id=?";
		Object results = this.jTemplate.queryForObject(sqlQuery3, new Object[]{class_Id}, Integer.class);
		
		if ( ((Number) results).intValue() > 0 ) {
			this.jTemplate.update(sqlQuery1, class_Id);
		}
		
		this.jTemplate.update(sqlQuery2, class_Id);
	}
	
	@Override
	public void editClass(String class_id, Date start_date, Date end_date) {
		String sqlQuery1 = "Update Classes SET start_Date=?, end_date=? WHERE class_id=?";
		String sqlQuery2 = "Update Classes SET start_Date=? WHERE class_id=?";
		String sqlQuery3 = "Update Classes SET end_date=? WHERE class_id=?";
		if (start_date != null && end_date != null) {
			this.jTemplate.update(sqlQuery1, start_date, end_date, class_id);
		} else if (start_date != null) {
			this.jTemplate.update(sqlQuery2, start_date, class_id);
		} else {
			this.jTemplate.update(sqlQuery3, end_date, class_id);
		}
		
	}
	
	@Override
	public void addEmployees(MultipartFile multipart, String fileName, String class_id) throws IOException, MessagingException {
		File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
	    multipart.transferTo(convFile);
        FileInputStream fis = new FileInputStream(convFile);

        // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
       
        // Return first sheet from the XLSX workbook
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
       
        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = mySheet.iterator();
       
        // SQLQuery
        String checkquery = "SELECT Count(*) FROM Enrollments WHERE employee_id=?";
		String sqlUpdateQuery = "UPDATE Enrollments SET class_id=? WHERE employee_id=?";
		String sqlInsertQuery = "INSERT INTO Enrollments(employee_id, class_id, role_id) VALUES(?,?,?)";
		String emailQuery= "SELECT email FROM employees WHERE employee_id=?";
		String checkClassquery = "SELECT COUNT(*) FROM Enrollments WHERE employee_id=? AND class_id=?";
        
        // Traversing over each row of XLSX file
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    String employee_id = cell.getStringCellValue();
                    Object results = this.jTemplate.queryForObject(checkquery, new Object[]{employee_id}, Integer.class);
                    Object inClass = this.jTemplate.queryForObject(checkClassquery, new Object[]{employee_id, class_id}, Integer.class);
                    if (((Number) inClass).intValue() < 1) {
	                    if ( ((Number) results).intValue() == 1) {
	            			this.jTemplate.update(sqlInsertQuery, employee_id, class_id, 2);
	            			String emailee = emailDAO.getEmailEnrollments(employee_id, class_id);
	            			String className = emailDAO.getEmailClassName(class_id);
	            			String fullName = emailDAO.getEmailEmpName(employee_id);
	            			
	            			sms.setEmpId(fullName);
	            			sms.setClassId(className);
	            			sms.send(emailee, 3);
	            			
	            		} else if (((Number) results).intValue() == 1) {
	            			this.jTemplate.update(sqlUpdateQuery, class_id, employee_id);           			
	            			
	            			String emailee = emailDAO.getEmailEnrollments(employee_id, class_id);
	            			String className = emailDAO.getEmailClassName(class_id);
	            			String fullName = emailDAO.getEmailEmpName(employee_id);
	            			
	            			sms.setEmpId(fullName);
	            			sms.setClassId(className);
	            			sms.send(emailee, 3);
	            		} else {
	            			this.jTemplate.update(sqlInsertQuery, employee_id, class_id, 2);
	            			
	            			String emailee = emailDAO.getEmailEnrollments(employee_id, class_id);
	            			String className = emailDAO.getEmailClassName(class_id);
	            			String fullName = emailDAO.getEmailEmpName(employee_id);
	            			
	            			sms.setEmpId(fullName);
	            			sms.setClassId(className);
	            			sms.send(emailee, 3);
	
	            		}
        			}
                    break;
                default :
             
                }
            }
            System.out.println("");
        }
	  
	}
}
