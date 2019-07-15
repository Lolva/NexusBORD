<%-- 
    Document   : Grades
    Created on : Jul 14, 2019, 4:20:57 PM
    Author     : syntel
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/includes.jsp" %>

<!DOCTYPE html>
<html>
<<<<<<< HEAD
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
=======
<head>
    <title>Grades</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/nexusbord.css">
	<script src="/resources/js/app.js"></script>
</head>

<body>
    <header>
        <div class="navigation">
            <ul class="topnavbar">
                <li><a class="logout" onclick="confirm('Logout?');location.href = 'login.html';">Logout</a></li>
                <li><a href="Nexus.html">Home</a></li>
                <li><a href="Modules.html">Modules</a></li>
                <li><a href="Assignments.html">Assignments</a></li>
                <li><a class="active" href="Grades.html">Grades</a></li>
                <li><a href="Classes.html">Classes</a></li>
                <li class="left" onClick="returnToMain()"><a class="nexus"><b>Nexus<font color="#04aad0">BORD</font></b></a></li>
            </ul>
        </div>
    </header>
    <div id="grades">
        <table rows="5" columns="3" noborder="true">
            <th><h1>Assignment Name</h1></th>
            <tr>
                <td>Student 1</td>
                <td>Grade: 0/100</td>
                <td style="padding: 40px;"><a href="">Download files</a></td>
            </tr>
        </table>
    </div>
    <footer>
        <p>Footer</p>
    </footer>
</body>
>>>>>>> c7ee2cd4a8f916ac98f7b0f6cff78a92d4aa15da
</html>

