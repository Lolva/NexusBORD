<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Instructor Assignments</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/nexusbord.css">
<script type="text/javascript" src="/resources/js/nexusbord.js"></script>
</head>

<!-- Dynamically create nav bar based on current page and role -->
<body onload="navBar(this, 'assignments', 'student')">
	<%
	//User is not logged in
		if (session.getAttribute("username") == null) {
	%>
	<script>
		window.location.href = "/login";
	</script>
	<%
		}
	%>
	<header>
		<!-- div for nav bar to be created in 
        <div id="navDiv" class="navigation">
        </div>-->
	</header>
	<fieldset
		style="width: 90%; margin: auto; height: 500px; background-color: white;">
		<div
			style="background-color: #2E2E7F; padding: 2px; margin-bottom: 15px;">
			<h2 style="color: white; margin: 10px; margin-top: 1%;">Create
				Assignment</h2>
		</div>
		<form style="color: black;" enctype="multipart/form-data" action="/NewAssignmentUpload" method="post">
			Title: <input type="text" name="assignmentName"
				placeholder="Enter Name of Assignment"> 
			<br>
			<br> 
			File: <input type="file" name="fileName"> 
			<br>
			<br> 
			Due Date: <input type="date" name="due_date"
				placeholder="Enter Due Date"> 	
			<br>
			<br> 
			Stream: <input type="text" name="streamInput" placeholder="Stream ID">
			<br>
			<br> 
			Module: <input type="text" name="moduleInput" placeholder="Module ID">
			<br>
			<br> 
			Class: <input type="text" name="classInput" placeholder="Class ID">
			<br>
			<br> 
			Description:
			<br>
			<textarea rows="2" cols="30" name="desc"></textarea>
			<input type="submit" value="Upload">
			<div style="color: red">${error}</div>
		</form>
	</fieldset>
</body>
</html>