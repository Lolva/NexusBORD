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
</head>
<body>
	<%
		if (session.getAttribute("username") == null) {
	%>
	<script>
		window.location.href = "/login";
	</script>
	<%
		}
	%>
	<header>
		<div class="navigation">
			<ul class="topnavbar">
				<li><a href="logout" onclick="return confirm('Logout?');">Logout</a></li>
				<li><a href="Nexus.html">Home</a></li>
				<li><a href="Modules.html">Modules</a></li>
				<li><a class="active" href="assignments">Assignments</a></li>
				<li><a href="Grades.html">Grades</a></li>
				<li><a href="Classes.html">Classes</a></li>
				<li class="left"><a class="nexus"><b>Nexus<font
							color="#04aad0">BORD</font></b></a></li>
			</ul>
		</div>
	</header>
	<fieldset
		style="width: 90%; margin: auto; height: 500px; background-color: white;">
		<div
			style="background-color: #2E2E7F; padding: 2px; margin-bottom: 15px;">
			<h2 style="color: white; margin: 10px; margin-top: 1%;">Create
				Assignment</h2>
		</div>
		<form style="color: black;" action="InstructorAssignments.html">
			Title: <input type="text" name="assignmentName"
				placeholder="Enter Name of Assignment"> <br>
			<br> File: <input type="file" name="fileName"> <br>
			<br> Due Date: <input type="date" name="due_date"
				placeholder="Enter Due Date"> <br>
			<br> Total Points: <input type="number" name="max_points"
				placeholder="Enter Maximum Points"> <br>
			<br> <input type="submit" value="Upload">
			<div style="color: red">${error}</div>
		</form>
	</fieldset>
</body>
</html>