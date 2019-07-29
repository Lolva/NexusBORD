<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Grades</title>
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
				<h2 style="color: white; margin: 10px; margin-top: 1%;">Grades</h2>
			</div>
			<table rows="5" columns="3" noborder="true" style="color: black;">
				<th><h1>Assignment Name</h1></th>
				<tr>
					<td>Student 1</td>
					<td>Grade: 0/100</td>
					<td style="padding: 40px;"><a href="">Download files</a></td>
				</tr>
			</table>
		</fieldset>
	</div>

	<footer>
		<p>Footer</p>
	</footer>
</body>
</html>

