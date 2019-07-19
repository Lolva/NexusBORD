<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
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
   	
   	<form:form modelAttribute="newProduct" method="post">
   		Class ID:<form:input type="text" name="class_Id" path="class_Id" placeholder="Class ID"/>
   		<br>
   		Start Date:<form:input type="text" name="start_date" path="start_date" placeholder="Enter start_date"/>
   		<br>
   		End Date:<form:input type="text" name="end_date" path="end_date" placeholder="Enter end_date"/>
   		<br>
   		<button id="addclassbtn" path="submit" type="submit" value="Add" >Add</button>
   		<button type="reset">Clear Form</button>
   	
	
   	</form:form>
   	
   	</fieldset>

</body>
</html>