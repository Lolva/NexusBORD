CREATE TABLE employees {
  employee_id VARCHAR2(12),
  
  PRIMARY KEY(employee_id)
};

CREATE TABLE modules {
  module_id NUMBER(4),
  course_id NUMBER
};

CREATE TABLE module_files {
  file_name VARCHAR2(50) PRIMARY KEY,
  module_id NUMBER(4) NOT NULL
};
