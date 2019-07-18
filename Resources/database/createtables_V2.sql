
CREATE TABLE Streams (
    Stream_ID VARCHAR2(30) not null,
    Stream_Name VARCHAR2(30) not null, 
    CONSTRAINT str_pk PRIMARY KEY(Stream_ID)
);
                                 
CREATE TABLE Classes (
    Class_ID VARCHAR2(30) not null,
    Stream_ID VARCHAR(30),
    CONSTRAINT class_pk PRIMARY KEY(Class_ID),
    CONSTRAINT class_fk FOREIGN KEY(Stream_ID) REFERENCES Streams(Stream_ID)
);

CREATE TABLE Employees ( 
    Employee_Id VARCHAR2(10) not null,
    First_Name VARCHAR2(30) not null,
    Last_Name VARCHAR2(30) not null,
    Email VARCHAR2(30) not null,
    Hire_Date DATE,
    Password VARCHAR2(30) not null,
    CONSTRAINT emp_pk PRIMARY KEY(Employee_ID)
);
                                 
CREATE TABLE Modules(
  Module_Name VARCHAR2(30),
  Module_ID VARCHAR2(30) NOT NULL,
 CONSTRAINT module_pk PRIMARY KEY(Module_ID)
);

CREATE TABLE Module_Files(
  Module_File_ID VARCHAR(30),
  File_Name VARCHAR2(50),
  Module_ID VARCHAR2(30) NOT NULL,
  CONSTRAINT module_files_pk PRIMARY KEY(Module_File_ID),
  CONSTRAINT modules_files_fk FOREIGN KEY(Module_ID) REFERENCES Modules(Module_ID)
);

CREATE TABLE Assignments(
  Assignment_ID VARCHAR2(30) not null,
  Module_ID VARCHAR2(30) not null,
  Assignment_Name VARCHAR2(30) not null,
  Description varchar2(500),
  Due_Date date not null, 
  File_Name VARCHAR2(50),
  File_Type VARCHAR2(5),
  CONSTRAINT a_pk PRIMARY KEY(Assignment_ID)
);

CREATE TABLE Submissions(
  Assignment_ID VARCHAR2(30) not null,
  Employee_ID VARCHAR2(10) not null,
  Submission_Date DATE,
  Grade NUMBER,
  CONSTRAINT ss_pk PRIMARY KEY(Employee_ID, Assignment_ID),
  CONSTRAINT ss_fk1 FOREIGN KEY(Assignment_ID) REFERENCES Assignments(Assignment_ID),
  CONSTRAINT ss_fk2 FOREIGN KEY(Employee_ID) REFERENCES Employees(Employee_Id)
);

CREATE TABLE Roles(
   Role_ID VARCHAR2(30),
   Role_Name VARCHAR2(30),
   CONSTRAINT r_pk PRIMARY KEY(Role_ID)
);

CREATE TABLE Enrollments(
     Employee_ID VARCHAR2(10) not null,
     Class_ID VARCHAR2(30) not null,
     Role_ID VARCHAR2(30),
     Enrollment_Date Date,
     CONSTRAINT ic_pk PRIMARY KEY(Employee_ID, Class_ID),
     CONSTRAINT ic_fk FOREIGN KEY(Employee_ID) REFERENCES Employees(Employee_ID),
     CONSTRAINT ic_fk2 FOREIGN KEY(Class_ID) REFERENCES Classes(Class_ID),
     CONSTRAINT ic_fk3 FOREIGN KEY(Role_ID) REFERENCES Roles(Role_ID)
);

CREATE TABLE Lessons(
    Stream_ID VARCHAR2(30) not null,
    Module_ID VARCHAR2(30) not null,
    CONSTRAINT cs_pk PRIMARY KEY(Stream_ID, Module_ID),
    CONSTRAINT cs_fk1 FOREIGN KEY(Stream_ID) REFERENCES Streams(Stream_ID),
    CONSTRAINT cs_fk2 FOREIGN KEY(Module_ID) REFERENCES Modules(Module_ID)
);




