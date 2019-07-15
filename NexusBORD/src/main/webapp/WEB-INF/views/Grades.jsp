<%-- 
    Document   : Grades
    Created on : Jul 14, 2019, 4:20:57 PM
    Author     : syntel
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/includes.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Student Management</title>
        <
    </head>
    <body>
        <h1>Data</h1>
        <form:form action=""student.do" method="POST" commandName="student">
                   <table>
                       <tr>
                           <td>StudentId</td>
                           <td><form:input path="studentId"/></td>
                           
                           </tr>
                           <tr>
                           <td>FirstName</td>
                           <td><form:input path="firstname"/> </td>
                           </tr>
                           <tr>
                           <td>LastName</td>
                           <td><form:input path="lastname"/> </td>
</tr>
<tr>
                           <td>Grade</td>
                       <td><form:input path="grade"/> </td>

</tr>
                     <tr>
    <td colspan="2">
        <input type="submit" name="action" value="Add"/>
        <input type="submit" name="action" value="Edit"/>
        <input type="submit" name="action" value="Delete"/>
    </td>
</tr>
                       
            </table>
                   
                   
                   
</form:form>
    <br>
    <table border="1">
        <tr>Id</tr>
        <tr>FirstName</tr>
        <tr>LastName</tr>
        <tr>Grade</tr>
    </table>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>$(student.employeeid}</td>
            <td>$(student.firstname}</td>
            <td>$(student.lastname}</td>
            <td>$(student.grade}</td>
            
            
        </tr>
    
    
    
    </c:forEach>
               
        
        
        
        
        
        
    </body>
</html>

