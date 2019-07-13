=============================================
|INSERT, UPDATE, DELETE OPERATIONS FOR CLASS|
=============================================

insertClass(Cl_ID IN NUMBER, Co_ID IN Number, Cap IN Number)
--updates Class using Class ID

updateClass(Cl_ID IN Number, Co_ID IN Number, Cap IN Number)

deleteClass(Cl_ID IN NUMBER)

==============================================
|INSERT, UPDATE, DELETE OPERATIONS FOR COURSE|
==============================================

insertCourse(Co_ID IN NUMBER, Co_Name IN VARCHAR, Co_Description IN VARCHAR, Co_Level IN VARCHAR)

--updates Course using Course ID
updateCourse(Co_ID IN Number, Co_Name IN VARCHAR2, Co_Description IN VARCHAR2, Co_Level IN VARCHAR2)

deleteCourse(Co_ID IN Number)

==================================================
|INSERT, UPDATE, DELETE OPERATIONS FOR ASSIGNMENT|
==================================================

INSERT_ASSIGNMENT( aID in Number, aName in varchar2, cID in Number, mID in Number, descrip in varchar2, dateDue in date, mPoints in number, files in varchar2)

--updates Assignment using Assignment ID
UPDATE_ASSIGNMENT( aID in Number, aName in varchar2, cID in Number,mID in Number, descrip in varchar2, dateDue in date, mPoints in number, files in varchar2)

DELETE_ASSIGNMENT(aID in Number)

==================================================
|INSERT, UPDATE, DELETE OPERATIONS FOR SUBMISSION|
==================================================

INSERT_SUBMISSION(subID in number, aID in Number, stuID in Number, subDate in Date, newGrade in number, files in varchar2)

--updates Submission using Submission ID
UPDATE_SUBMISSION(subID in number, aID in Number, stuID in Number, subDate in Date, newGrade in number, files in varchar2)

DELETE_SUBMISSION(subID in number)

==============================================
|INSERT, UPDATE, DELETE OPERATIONS FOR MODULE|
==============================================

add_module_file(fName IN VARCHAR2, mId IN NUMBER)

delete_module_file(fName IN VARCHAR2)

--updates Module using filename
update_module_file(fName IN VARCHAR2, mId IN NUMBER)

link_module(mId IN NUMBER, cId IN NUMBER)

unlink_module(mId IN NUMBER, cId IN NUMBER)

=================
|SPECIAL QUERIES|
=================

-- Returns VARCHAR2 as 'TRUE' or 'FALSE' depending on whether or not the given employee_id is an instructor
isInstructor(emp_id IN NUMBER)

-- Returns the grade for an assignment using assignment ID and Student ID
GET_GRADE(aID in Number, stuID in Number)

-- Returns total grade for a student by using student ID
GET_TOTAL_GRADE(stuID in Number) return number

--Returns a list of all students in a class using Class ID
listAllStudents(Cl_ID IN NUMBER)

--Rdds a student to a class using Student ID and class ID
addStudentToClass(Emp_ID IN NUMBER, Cl_ID IN NUMBER)

--generates email by concatenating first and last name
buildEmail (empId IN NUMBER)
