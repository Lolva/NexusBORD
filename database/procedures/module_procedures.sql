CREATE OR REPLACE PROCEDURE add_module_file(fName IN VARCHAR2, mId IN NUMBER)
IS
BEGIN
  INSERT INTO module_files(file_name, module_id)
    VALUES(fName, mId);
END add_module_file;

CREATE OR REPLACE PROCEDURE delete_module_file(fName IN VARCHAR2)
IS
BEGIN
  DELETE FROM module_files WHERE file_name=fName;
END delete_module_file;

CREATE OR REPLACE PROCEDURE update_module_file(fName IN VARCHAR2, mId IN NUMBER)
IS
BEGIN
  UPDATE module_files SET module_id=mId WHERE file_name = fName;
END update_module_file;

CREATE OR REPLACE PROCEDURE link_module(mId IN NUMBER, cId IN NUMBER)
IS
BEGIN
  INSERT INTO modules(module_id, course_id)
    VALUES(mId, cId);
END link_module;

CREATE OR REPLACE PROCEDURE unlink_module(mId IN NUMBER, cId IN NUMBER)
IS
BEGIN
  DELETE FROM modules WHERE module_id=mId AND course_id=cId;
END unlink_module;
