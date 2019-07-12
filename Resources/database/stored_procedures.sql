
-- Access procedures for class table
CREATE OR REPLACE PROCEDURE insertClass(Cl_ID IN NUMBER, Co_ID IN Number, Cap IN Number)
IS
BEGIN
INSERT INTO classes VALUES(Cl_ID, Co_ID, Cap);
END insertClass;
/

CREATE OR REPLACE PROCEDURE updateClass(Cl_ID IN Number, Co_ID IN Number, Cap IN Number)
IS
BEGIN
UPDATE classes SET Course_ID = Co_ID, Capacity = Cap WHERE Class_ID = Cl_ID;
COMMIT;
END updateClass;
/

CREATE OR REPLACE PROCEDURE deleteClass(Cl_ID IN NUMBER)
IS
BEGIN
DELETE FROM classes WHERE Class_ID = Cl_ID;
END deleteClass;
/

-- Access procedures for course table
CREATE OR REPLACE PROCEDURE insertCourse(Co_ID IN NUMBER, Co_Name IN VARCHAR, Co_Description IN VARCHAR, Co_Level IN VARCHAR)
IS
BEGIN
INSERT INTO courses VALUES (Co_ID, Co_Name, Co_Description, Co_Level);
END insertCourse;
/

CREATE OR REPLACE PROCEDURE updateCourse(Co_ID IN Number, Co_Name IN VARCHAR2, Co_Description IN VARCHAR2, Co_Level IN VARCHAR2)
IS
BEGIN
UPDATE courses SET Course_Name = Co_Name, Course_Description = Co_Description, Course_Level = Co_Level WHERE Course_ID = Co_ID;
COMMIT;
END updateCourse;
/

CREATE OR REPLACE PROCEDURE deleteCourse(Co_ID IN Number)
IS
BEGIN
DELETE FROM courses WHERE Course_ID = Co_ID;
END deleteCourse;
/

-- Access procedures for employee table
CREATE OR REPLACE PROCEDURE insertEmp(Emp_Id IN NUMBER, Is_Ins IN NUMBER, Cl_ID IN NUMBER, F_Name IN VARCHAR, L_Name IN VARCHAR, Email_Addr IN VARCHAR, Enrl_D IN DATE, End_D IN DATE, pswrd IN VARCHAR)
IS
BEGIN
INSERT INTO employee VALUES(Emp_Id, Is_Ins, Cl_ID, F_Name, L_Name, Email_Addr, Enrl_D, End_D, pswrd);
END insertEmp;
/

CREATE OR REPLACE PROCEDURE deleteEmployee(Emp_ID IN Number)
IS
BEGIN
DELETE FROM employee WHERE Employee_ID = Emp_ID;
END deleteEmployee;
/

-- Access procedures for assignments table
CREATE OR REPLACE PROCEDURE INSERT_ASSIGNMENT( aID in Number, aName in varchar2, cID in Number, mID in Number, descrip in varchar2, dateDue in date, mPoints in number, files in varchar2)
IS
BEGIN
  INSERT INTO ASSIGNMENTS
  VALUES(aID,aName,cID,mID,descrip,dateDue,mPoints,files);
END;
/
CREATE OR REPLACE PROCEDURE UPDATE_ASSIGNMENT( aID in Number, aName in varchar2, cID in Number,mID in Number, descrip in varchar2, dateDue in date, mPoints in number, files in varchar2)
IS
BEGIN
  UPDATE ASSIGNMENTS
  SET Assignment_Name = aName, Class_ID = cID, Module_id = mID,Description = descrip, Due_Date = dateDue, Max_Points = mPoints, attached_files = files
  WHERE Assignment_id = aID;
END;

CREATE OR REPLACE PROCEDURE DELETE_ASSIGNMENT(aID in Number)
IS
BEGIN
  DELETE 
  FROM ASSIGNMENTS
  WHERE Assignment_ID = aID;
END;
/

-- Access procedures for student_submissions table
CREATE OR REPLACE PROCEDURE INSERT_SUBMISSION(subID in number, aID in Number, stuID in Number, subDate in Date, newGrade in number, files in varchar2)
IS
BEGIN
  INSERT INTO STUDENT_SUBMISSIONS
  VALUES(subID,aID,stuID,subDate,newGrade,files); 
END;
/

CREATE OR REPLACE PROCEDURE UPDATE_SUBMISSION(subID in number, aID in Number, stuID in Number, subDate in Date, newGrade in number, files in varchar2)
IS
BEGIN
  UPDATE Student_Submissions
  SET Assignment_ID = aID, Student_ID = stuID, submission_date = subDate, grade = grade, attached_files = files
  WHERE Submission_ID = subID;
END;
/

CREATE OR REPLACE PROCEDURE DELETE_SUBMISSION(subID in number)
IS
BEGIN
  DELETE
  FROM Student_submissions
  WHERE Submission_ID = subID;
END;
/

-- Access procedures for module_files table
CREATE OR REPLACE PROCEDURE add_module_file(fName IN VARCHAR2, mId IN NUMBER)
IS
BEGIN
  INSERT INTO module_files(file_name, module_id)
    VALUES(fName, mId);
END add_module_file;
/

CREATE OR REPLACE PROCEDURE delete_module_file(fName IN VARCHAR2)
IS
BEGIN
  DELETE FROM module_files WHERE file_name=fName;
END delete_module_file;
/

CREATE OR REPLACE PROCEDURE update_module_file(fName IN VARCHAR2, mId IN NUMBER)
IS
BEGIN
  UPDATE module_files SET module_id=mId WHERE file_name = fName;
END update_module_file;
/

-- Access procedures for modules table
CREATE OR REPLACE PROCEDURE link_module(mId IN NUMBER, cId IN NUMBER)
IS
BEGIN
  INSERT INTO modules(module_id, course_id)
    VALUES(mId, cId);
END link_module;
/

CREATE OR REPLACE PROCEDURE unlink_module(mId IN NUMBER, cId IN NUMBER)
IS
BEGIN
  DELETE FROM modules WHERE module_id=mId AND course_id=cId;
END unlink_module;
/

-- SPECIAL QUERIES
-- Returns VARCHAR2 as 'TRUE' or 'FALSE' depending on whether or not the given employee_id is an instructor
CREATE OR REPLACE FUNCTION isInstructor(emp_id IN NUMBER)
RETURN VARCHAR2
IS
  instructor NUMBER(1);
BEGIN
  SELECT is_instructor INTO instructor FROM employee WHERE employee_id=emp_id;
  IF instructor = 1 THEN
    RETURN 'TRUE';
  ELSE
    RETURN 'FALSE';
  END IF;
END isInstructor;
/

CREATE OR REPLACE FUNCTION GET_GRADE(aID in Number, stuID in Number) return number
IS
  maxPoints number;
  actualGrade number;
BEGIN
  SELECT Max_Points INTO maxPoints
  FROM Assignments
  WHERE Assignment_ID = aID;
  
  SELECT grade INTO actualGrade
  FROM STUDENT_SUBMISSIONS
  WHERE Assignment_ID = aID and Student_ID = stuID;
  
  return actualGrade * 100 / maxPoints;
END;
/
CREATE OR REPLACE FUNCTION GET_TOTAL_GRADE(stuID in Number) return number
IS
  totalAssignments number;
  sumOfGrades number := 0;
  
  CURSOR All_Assignments IS 
  SELECT * 
  FROM Student_Submissions
  WHERE Student_Id = stuID and grade is not null;
BEGIN
    
    SELECT Count(*) INTO totalAssignments
    FROM Student_Submissions
    WHERE Student_Id = stuID and grade is not null;
    
    IF totalAssignments <= 0 THEN
      return 100;
    ELSE
      
      FOR R IN All_Assignments
      LOOP
        sumOfGrades := sumOfGrades + GET_GRADE(R.Assignment_ID,stuID);
      END LOOP;
      
      return sumOfGrades / totalAssignments;
    END IF;
    
    
END;
/

--list all the students in a class given the class ID
CREATE OR REPLACE FUNCTION listAllStudents(Cl_ID IN NUMBER)
RETURN sys_refcursor
IS
l_rc sys_refcursor;
BEGIN
OPEN l_rc FOR
SELECT First_Name||' '||Last_Name, Employee_ID FROM employee WHERE Class_ID = CL_ID;
RETURN l_rc;
END listAllStudents;
/


--add a student to a class
CREATE OR REPLACE PROCEDURE addStudentToClass(Emp_ID IN NUMBER, Cl_ID IN NUMBER)
IS
BEGIN
UPDATE employees2 SET Class_ID = Cl_ID WHERE Employee_ID = Emp_ID ;
END addStudentToClass;
/
CREATE OR REPLACE FUNCTION buildEmail (empId IN NUMBER)
RETURN VARCHAR2
AS
  emp employee%ROWTYPE;
BEGIN
  SELECT * INTO emp FROM employee WHERE employee_id=empId;
  RETURN emp.first_name || '_' || emp.last_name || '@syntelinc.com';
END buildEmail;
/