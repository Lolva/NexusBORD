package com.atossyntel.springboot.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Types;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

@Repository
@Transactional
public class ClassesDAOService implements ClassesDAO {
	@Autowired
    private JdbcTemplate jTemplate;
	
	
	@Override
	public List<Map<String,Object>> getStudents(String classId) {
		String sql = "Select e.first_name, e.last_name, e.email From Employees e, Enrollments s WHERE e.employee_id = s.employee_id AND s.class_ID = ?";
		List<Map<String,Object>> results;
		results = jTemplate.queryForList(sql, classId);
		 return results;
		
	}
	
	public void addClasses(String class_Id,String stream_Id, Date start_date, Date end_date) {
		String sql= "INSERT INTO CLASSES(CLASS_ID,STREAM_ID,START_DATE,END_DATE) VALUES(?, ?, ?, ?)";
		Object[] params = new Object[] {class_Id , stream_Id, start_date, end_date};
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP };
		this.jTemplate.update(sql, params, types);
	
	}

	@Override
	public List<Map<String, Object>> getClasses() {
		String sql = "Select class_id From Classes";		
		List<Map<String,Object>> results;
		results = jTemplate.queryForList(sql);
		return results;
		
	}
	

	@Override
	public List<Map<String, Object>> getAllStudents() {
		String sql = "SELECT s.class_id, s.employee_id, e.first_name, e.last_name, e.email FROM Employees e, Enrollments s WHERE e.employee_id = s.employee_id";
		List<Map<String,Object>> results;
		results = jTemplate.queryForList(sql);
		return results;
	}


	@Override
	public void changeClassId(String EmpId, String classId) {
		String checkquery = "SELECT Count(*) FROM Enrollments WHERE employee_id=?";
		String sqlUpdateQuery = "UPDATE Enrollments SET class_id=? WHERE employee_id=?";
		String sqlInsertQuery = "INSERT INTO Enrollments(employee_id, class_id, role_id) VALUES(?,?,?)";
		Object results = this.jTemplate.queryForObject(checkquery, new Object[]{EmpId}, Integer.class);
		if ( ((Number) results).intValue() == 1) {
			this.jTemplate.update(sqlUpdateQuery, classId, EmpId);
		} else if ( ((Number) results).intValue() > 1) {
			
		} else {
			this.jTemplate.update(sqlInsertQuery, EmpId, classId, 2);
		}
		
		
	}
	@Override
	public void deleteEmployee(String class_Id, String employee_id) {
//		System.out.println("Deleting employee");
		String sqlQuery = "Delete FROM Enrollments WHERE class_id=? AND employee_id=?";	
//		System.out.println(class_Id + " " + employee_id);
		this.jTemplate.update(sqlQuery, class_Id, employee_id);
	}
	
	@Override
	public void deleteClass(String class_Id) {
//		System.out.println("Deleting class");
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
	public void addEmployees(MultipartFile multipart, String fileName, String class_id) throws IOException {
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
            		if ( ((Number) results).intValue() == 1) {
            			System.out.println(((Number) results).intValue());
            			this.jTemplate.update(sqlUpdateQuery, class_id, employee_id);
            		} else {
            			this.jTemplate.update(sqlInsertQuery, employee_id, class_id, 2);
            		}
                    break;
                default :
             
                }
            }
            System.out.println("");
        }
	  
	}
}