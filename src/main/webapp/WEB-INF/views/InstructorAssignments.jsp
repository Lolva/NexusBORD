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
<style>
td, th {
	border: 1px solid black;
	text-align: left;
	padding: 8px;
	color: black;
}
</style>
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
		<!-- div for nav bar to be created in -->
        <div id="navDiv" class="navigation">
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
