CREATE TABLE courses (
    Course_ID integer not null,
    Course_Name VARCHAR2(30) not null, 
    Course_Description VARCHAR2(30) not null,
    Course_Level VARCHAR2(30) not null,
    CONSTRAINT course_pk PRIMARY KEY(course_id),
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
                                 
CREATE TABLE modules {
  module_id NUMBER(4),
  course_id NUMBER
};

CREATE TABLE module_files {
  file_name VARCHAR2(50) PRIMARY KEY,
  module_id NUMBER(4) NOT NULL
};
