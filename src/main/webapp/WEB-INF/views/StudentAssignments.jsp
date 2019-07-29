<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Assignments</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/nexusbord.css">
<script type="text/javascript" src="/resources/js/nexusbord.js"></script>
<!-- Bootstrap Dependencies -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
<script
    src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
    
<style>
td, th {
	border: 1px solid black;
	text-align: center;
	padding: 8px;
	color: black;
}
</style>
</head>
<!-- Dynamically create nav bar based on current page and role -->
<body onload="navBar(this, 'assignments', '<%=session.getAttribute("role").toString()%>')">
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
	<fieldset
		style="width: 90%; margin: auto; height: 520px; background-color: white;">
		<div style="background-color: #2E2E7F; padding: 2px;">
			<h2 style="color: white; margin: 10px; margin-top: 1%;">Trainee
				Assignments</h2>
		</div>
		<table width="100%" class="assignmentTable">
			<tr>
				<th>Assignment</th>
				<th>Due Date</th>
				<th>Submission Status</th>
				<th>File Name</th>
				<th>Options</th>
			</tr>
			<c:forEach items="${sassigns}" var="obj">
				<tr>
					<td id=assignmentName>${obj.assignment_name}</td>
					<td id=dueDate>${obj.due_date}</td>
					<!-- If statement to determine if assignment has been turned in -->
					<c:choose>
						<c:when test="${empty obj.submission_date}">
							<!-- submission date is null -->
							<td style="color: red;" id="submissionStatus">Not Submitted</td>
						</c:when>
						<c:otherwise>
							<td style="color: green;" id="submissionStatus">Submitted</td>
						</c:otherwise>
					</c:choose>
					<td id="fileName">${obj.attached_files}</td>
					<td><a href="SubmitAssignment.html">Upload</a></td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
	<footer> </footer>
	
	<!-- Container for logout modal -->	
	<div id="LogoutModalDiv"></div>
</body>
</html>
