<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Grade Assignment: </title>
<style>
td, th {
	border: 1px solid black;
	text-align: center;
	padding: 8px;
	color: black;
}
</style>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/nexusbord.css">
</head>

<body>
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
		<div class="navigation">
			<ul class="topnavbar">
				<li><a href="logout" onclick="return confirm('Logout?');">Logout</a></li>
				<li><a href="Nexus.html">Home</a></li>
				<li><a href="Modules.html">Modules</a></li>
				<li><a href="assignments">Assignments</a></li>
				<li><a class="active" href="Grades.html">Grades</a></li>
				<li><a href="Classes.html">Classes</a></li>
				<li class="left"><a class="nexus"><b>Nexus<font
							color="#04aad0">BORD</font></b></a></li>
			</ul>
		</div>
	</header>
	<div id="grades">
		<fieldset
			style="width: 90%; margin: auto; height: 520px; background-color: white;">
			<div style="background-color: #2E2E7F; padding: 2px;">
				<h2 style="color: white; margin: 10px; margin-top: 1%;">Grade Assignment: </h2>
			</div>
			<table width="100%" class="gradeTable">
				<tr>
					<th>Student Name</th>
					<th>Submission_Date</th>
					<th>File Name</th>
					<th>Grade</th>
				</tr>
				<c:forEach items="${igrades}" var="obj">
					<tr>
						<td id=studentName>%{obj.student_name}</td>
						<c:choose>
							<c:when test="${empty obj.submission_date}">
								<!-- Submission date is null -->
								<td style="color:red;" id="submissionDate">Not Submitted</td>
							</c:when>
							<c:otherwise>
								<td style="color:green;" id="submissionDate">%{obj.submission_date}</td>
							</c:otherwise>
						</c:choose>
						<td id=fileName>%{obj.file_name}</td>
						<td id=grade><div contenteditable=true>%{obj.grade}</div>%</td>
					</tr>
				</c:forEach>
			</table>
			<button type="button">Submit!</button>
		</fieldset>
	</div>

	<footer>
		<p>Footer</p>
	</footer>
</body>
</html>


