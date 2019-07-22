<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Submit Assignment</title>
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
		<div style="background-color: #2E2E7F; padding: 2px;">
			<h2 style="color: white; margin: 10px; margin-top: 1%;">Upload
				Assignments</h2>
		</div>

		<form style="color: black;" enctype="multipart/form-data" method="POST">
			<input type="file" id="uploadFile" name="fileName">
			<br>
			<br>
			<button type="submit" id="uploadbtn" onclick="upload">Upload</button>
			<script>
				function upload(uploadFile) {
					var x = document.getElementById("uploadFile");
				}
			</script>
		</form>
	</fieldset>
</body>
</html>