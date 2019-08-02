INSERT INTO Courses Values(1234,'Java for beginners','Intro Java Class','beginner');
INSERT INTO Courses Values(4567,'Java for not new people','mid Java Class','intermediate');
INSERT INTO Courses Values(7890,'Java for pros!','best Java Class','advanced');
INSERT INTO Courses Values(7777,'Python for the best','Python Things','intermediate');

INSERT INTO Classes Values(4444,1234,5);
INSERT INTO Classes Values(5555,1234,10);
INSERT INTO Classes Values(6666,1234,25);
INSERT INTO Classes Values(7777,4567,25);
INSERT INTO Classes Values(8888,4567,15);
INSERT INTO Classes Values(7890,7890,10);
INSERT INTO Classes Values(1111,7777,25);

INSERT INTO EMPLOYEE Values('DG5061505',0,4444,'Dominic','Gianatassio','domgianatassio@gmail.com',TO_DATE('2019/06/12', 'yyyy/mm/dd'),null,'Password');
INSERT INTO EMPLOYEE Values('HK5061507',0,4444,'Hunter','Kliebert','Hunter_Klieber@syntelinc.com',TO_DATE('2019/06/12', 'yyyy/mm/dd'),null,'12345678');
INSERT INTO EMPLOYEE Values('BJ0123456',0,4444,'Bob','Joe','Bob_Joe@syntel.com',TO_DATE('2017/06/12', 'yyyy/mm/dd'),SYSDATE,'Password');
INSERT INTO EMPLOYEE Values('MS0123456',0,4444,'Mary','Smith','Mary_Smith@syntelinc.com',TO_DATE('2018/06/14', 'yyyy/mm/dd'),null,'Password');
INSERT INTO EMPLOYEE Values('BR1111111',1,4444,'Bob','Ross','Bob_Ross@syntelinc.com',TO_DATE('1988/11/12', 'yyyy/mm/dd'),null,'HappyLittleAccidents');
INSERT INTO EMPLOYEE Values('BW2222222',1,5555,'Betty','White','Betty_White@syntelinc.com',TO_DATE('1940/11/12', 'yyyy/mm/dd'),null,'BestCakes');
INSERT INTO EMPLOYEE Values('MS5555555',0,5555,'Mary','Smith','Mary_Smith@syntelinc.com',TO_DATE('2018/06/18', 'yyyy/mm/dd'),null,'Password');

INSERT INTO MODULES Values(12346,1234);
INSERT INTO MODULES Values(99999,1234);
INSERT INTO MODULES Values(44444,1234);
INSERT INTO MODULES Values(99876,7777);
INSERT INTO MODULES Values(44445,7890);

INSERT INTO MODULE_FILES VALUES('That_File.pdf',123456);
INSERT INTO MODULE_FILES VALUES('premadeThing.zip',123456);
INSERT INTO MODULE_FILES VALUES('greatResource.txt',444444);
INSERT INTO MODULE_FILES VALUES('whyIsThisEvenHere.java',99876);

INSERT INTO ASSIGNMENTS VALUES(01134,'Java Test 1',4444,12346,'TEST TIME!!!!!',TO_DATE('2019/11/12', 'yyyy/mm/dd'),100,null);
INSERT INTO ASSIGNMENTS VALUES(55556,'Java Assignment 1',4444,12346,'Why do I do this to myself!',TO_DATE('2019/06/12', 'yyyy/mm/dd'),100,'theMostImportantSheet.txt');
INSERT INTO ASSIGNMENTS VALUES(66667,'Java Informational',4444,999999,'Here We Go, Here we go Agin!',TO_DATE('2019/08/23', 'yyyy/mm/dd'),250,'theMostImportantSheet.txt');
INSERT INTO ASSIGNMENTS VALUES(13347,'Stuff And Things',5555,12346,'Wake Me Up! Wake me Up INSIDE!',TO_DATE('2019/07/23', 'yyyy/mm/dd'),50,'CantWakeUp.pdf');
INSERT INTO ASSIGNMENTS VALUES(78888,'Last Test',5555,999999,'Doesnt really matter',TO_DATE('2019/12/25', 'yyyy/mm/dd'),10,null);

INSERT INTO STUDENT_SUBMISSIONS VALUES(12345,01134,'DG5061505',null,null,null);
INSERT INTO STUDENT_SUBMISSIONS VALUES(33333,55556,'DG5061505',TO_DATE('2019/06/11', 'yyyy/mm/dd'),75,'answer.txt');
INSERT INTO STUDENT_SUBMISSIONS VALUES(44444,66667,'DG5061505',TO_DATE('2019/06/11', 'yyyy/mm/dd'),0,'answerThis.txt');
INSERT INTO STUDENT_SUBMISSIONS VALUES(44443,55556,'HK5061507',null,null,null);
INSERT INTO STUDENT_SUBMISSIONS VALUES(13347,13347,'BJ0123456',null,null,null);