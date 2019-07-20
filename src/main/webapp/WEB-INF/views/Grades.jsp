<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<script type="text/javascript" src="/resources/js/nexusbord.js"></script>

</head>

<!-- Dynamically create nav bar based on current page and role -->
<body onload="navBar(this, 'grades', 'student')">
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
		<div id="navDiv" class="navigation"></div>
	</header>
	<div id="grades">
		<fieldset
			style="width: 90%; margin: auto; height: 520px; background-color: white;">
			<div style="background-color: #2E2E7F; padding: 2px;">
				<h2 style="color: white; margin: 10px; margin-top: 1%;">Grade Assignment: </h2>
			</div>
			<form:form method="POST" modelAttribute="finishedGrades">
			<table width="100%" class="gradeTable">

				<tr>
					<th>Student Name</th>
					<th>Submission_Date</th>
					<th>File Name</th>
					<th>Grade</th>
				</tr>
				<c:forEach items="${grades.submissions}" var="obj" varStatus="gradeIndex">
					<tr>
						<td id=studentName >${obj.studentName}</td>
						<c:choose>
							<c:when test="${empty obj.submission_date}">
								<!-- Submission date is null -->
								<td style="color:red;" id="submissionDate">Not Submitted</td>
							</c:when>
							<c:otherwise>
								<td style="color:green;" id="submissionDate">${obj.submission_date}</td>
							</c:otherwise>
						</c:choose>
						<td id=fileName>${obj.file_name}</td>
						<form:hidden path="submissions[${gradeIndex.count}].studentName" value="${obj.studentName}"/>
						<form:hidden path="submissions[${gradeIndex.count}].submission_date" value="${obj.submission_date}"/>
						<form:hidden path="submissions[${gradeIndex.count}].employee_id" value="${obj.employee_id}"/>
						<form:hidden path="submissions[${gradeIndex.count}].file_name" value="${obj.file_name}"/>
						<td id=grade><form:input path="submissions[${gradeIndex.count}].grade" type="number" name="grade" value="${obj.grade}" min="0" max="100"/>%</td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" name="submit">
			</form:form>
			
		</fieldset>
	</div>

	<footer>
		<p>Footer</p>
	</footer>
</body>
</html>


