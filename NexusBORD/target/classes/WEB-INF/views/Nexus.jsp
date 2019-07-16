<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/nexusbord.css">
</head>
	<body>
	<%
	System.out.println(session.getAttribute("username"));
	System.out.println(session.getAttribute("instructor"));
	%>
		<!-- TODO: Redirect in JS -->
	   	<header>
	        <div class="navigation">
	            <ul class="topnavbar">
	                <li><a class="logout" onclick="confirm('Logout?'); location.href = '/logout.htm';">Logout</a></li>
	                <li><a class="active" href="Nexus.html">Home</a></li>
	                <li><a href="Modules.html">Modules</a></li>
	                <li><a href="InstructorAssignments.html">Assignments</a></li>
	                <li><a href="Grades.html">Grades</a></li>
	                <li><a href="Classes.html">Classes</a></li>
	                <li class="left"><a class="nexus"><b>Nexus<font color="#04aad0">BORD</font></b></a></li>
	            </ul>
	        </div>
	    </header>
		<fieldset style="width: 90%; margin:auto; height: 520px; background-color: white;">
     	<div style ="background-color:#2E2E7F; padding: 2px;">
       		<h2 style="color:white; margin: 10px; margin-top: 1%;"> Welcome to NexusBORD</h2>
     	</div>
     	</fieldset>
	</body>
</html>