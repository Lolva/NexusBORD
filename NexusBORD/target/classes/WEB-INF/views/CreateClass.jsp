<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Class</title>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/nexusbord.css">
    
</head>
<body>
  <header>
        <div class="navigation">
            <ul class="topnavbar">
	            <li><a class="logout" onclick="confirm('Logout?'); location.href = '/logout.htm';">Logout</a></li>
                <li><a href="Nexus.html">Home</a></li>
                <li><a href="Modules.html">Modules</a></li>
                <li><a href="InstructorAssignments.html">Assignments</a></li>
                <li><a href="Grades.html">Grades</a></li>
                <li><a class="active" href="Classes.html">Classes</a></li>
                <li class="left"><a class="nexus"><b>Nexus<font color="#04aad0">BORD</font></b></a></li>
            </ul>
        </div>
    </header>
    <fieldset style="width: 90%; margin:auto; height: 520px; background-color: white;">
   	<a href="Classes.html">Back to Classes</a>
   	<form action="Classes.html">
   		Class ID:<input type="text" id="classid" placeholder="Enter Class ID">
   		<br>
   		Course ID:<input type="text" id="courseid" placeholder="Enter Course ID">
   		<br>
   		Capacity:<input type="text" id="capacity" placeholder="Enter Capacity">
   		<br>
   		<button id="addclassbtn" type="submit" >Submit</button>
   		<button type="reset">Clear Form</button>
   	
	
   	</form>
   	</fieldset>

</body>
</html>