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
<style>
td, th {
	border: 1px solid black;
	text-align: left;
	padding: 8px;
	color: black;
}
</style>
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
				<li><a class="active" href="assignments">Assignments</a></li>
				<li><a href="Grades.html">Grades</a></li>
				<li><a href="Classes.html">Classes</a></li>
				<li class="left"><a class="nexus"><b>Nexus<font
							color="#04aad0">BORD</font></b></a></li>
			</ul>
		</div>
	</header>


	<div id="teacher">
		<fieldset
			style="width: 90%; margin: auto; height: 500px; background-color: white;">
			<div style="background-color: #2E2E7F; padding: 2px;">
				<h2 style="color: white; margin: 10px; margin-top: 1%;">
					Instructor Assignments</h2>
			</div>
			<table border="1"
				style="column-count: 3; column-fill: auto; border-collapse: collapse; color: black; margin-left: 5%; width: 100%; margin: 10px;">
				<thead style="border-bottom: black;">
					<th>Name</th>
					<th>Due date</th>
					<th>Max Points</th>
					<th>File Name</th>
				</thead>
				<tbody>
					<c:forEach items="${sassigns}" var="obj">
						<tr>
							<td>${obj.assignment_name}</td>
							<td>${obj.due_date}</td>
							<td>${obj.max_points}</td>
							<td>${obj.attached_files}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a style="text-decoration: none; margin-left: 10px;"
				href="NewAssignmentUpload.html">Upload New Assignment</a>
		</fieldset>

	</div>
</body>
</html>
