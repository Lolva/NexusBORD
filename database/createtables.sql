TRUNCATE TABLE student_submissions;
DROP TABLE student_submissions;

TRUNCATE TABLE assignments;
DROP TABLE assignments;

TRUNCATE TABLE module_files;
DROP TABLE module_files;

TRUNCATE TABLE modules;
DROP TABLE modules;

TRUNCATE TABLE classes;
DROP TABLE classes;

TRUNCATE TABLE courses;
DROP TABLE courses;

TRUNCATE TABLE employee;
DROP TABLE employee;

CREATE TABLE courses (
    Course_ID NUMBER not null,
    Course_Name VARCHAR2(30) not null, 
    Course_Description VARCHAR2(30) not null,
    Course_Level VARCHAR2(30) not null,
    CONSTRAINT course_pk PRIMARY KEY(Course_ID),
    CONSTRAINT check_level CHECK(Course_level IN ('beginner', 'intermediate', 'advanced'))
);
                                 
CREATE TABLE classes (
    Class_ID NUMBER(4) not null,
    Course_ID NUMBER not null,
    Capacity NUMBER,
    CONSTRAINT class_pk PRIMARY KEY(class_id),
    CONSTRAINT class_fk FOREIGN KEY(Course_ID) REFERENCES courses(Course_ID),
    CONSTRAINT check_cap CHECK(Capacity > 30)
);

CREATE TABLE employee ( 
    Employee_Id NUMBER not null,
    Class_ID NUMBER(4) not null,
    First_Name VARCHAR2(30) not null,
    Last_Name VARCHAR2(30) not null,
    Email VARCHAR2(30) not null,
    Enrollment_Date DATE,
    End_Date DATE,
    Password VARCHAR2(30) not null,
    CONSTRAINT emp_pk PRIMARY KEY(Employee_ID),
    CONSTRAINT emp_fk FOREIGN KEY(Class_ID) REFERENCES classes(Class_ID)
);
                                 
CREATE TABLE modules(
  module_id NUMBER(4) NOT NULL,
  course_id NUMBER(4) NOT NULL,
  CONSTRAINT modules_fk FOREIGN KEY(course_id) REFERENCES courses(course_id)
);

CREATE TABLE module_files(
  file_name VARCHAR2(50),
  module_id NUMBER(4) NOT NULL,
  CONSTRAINT module_files_pk PRIMARY KEY(file_name)                               
);

CREATE TABLE assignments(
  Assignment_ID Number not null,
  Class_ID Number not null,
  description varchar2(500),
  Due_Date date not null, 
  Max_Points Number not null,
  attached_files varchar2(50),
  CONSTRAINT ass_pk PRIMARY KEY(Assignment_ID),
  CONSTRAINT ass_fk FOREIGN KEY(Class_ID) REFERENCES classes(Class_ID)
);

CREATE TABLE student_submissions(
  Submission_ID number not null,
  Assignment_ID number not null,
  Student_ID number not null,
  submission_date date,
  grade number,
  attached_files varchar2(50),
  CONSTRAINT ss_pk PRIMARY KEY(Submission_ID),
  CONSTRAINT ss_fk1 FOREIGN KEY(Assignment_ID) REFERENCES assignments(Assignment_ID),
  CONSTRAINT ss_fk2 FOREIGN KEY(Student_ID) REFERENCES employee(Employee_Id)
);
