<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/nexusbord.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"> 
<script type="text/javascript" src="/resources/js/nexusbord.js"></script>
</head>

<!-- Dynamically create nav bar based on current page and role -->
<body onload="navBar(this, 'home', 'student')">
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
		style="width: 90%; margin: auto; height: 100%; background-color: white; margin-bottom: 5%">
		<div style="background-color: #2E2E7F; padding: 2px;">
			<h2 style="color: white; margin: 10px; margin-top: 1%;">Welcome
				to NexusBORD</h2>
		</div>
		<div class="container-fluid">
		
			<!-- Overdue Assignment Cards -->
			<div class="row" style="padding-left: 10px"><h4>Overdue Assignments</h4></div>
			<div class="row">
				<c:forEach items="${overdue}" var="obj">
					<div class="col-sm">
						<div class="card">
							<div class="card-body">
								<div class="card-header">
									<h5 class="card-title">${obj.STREAM_NAME}</h5>
									<h6 class="card-subtitle mb-2 text-muted">${obj.ASSIGNMENT_NAME}</h6>
								</div>
								<p class="card-text">
									${obj.DESCRIPTION}
								</p>
								<p class="card-footer text-white bg-danger">
									${obj.DUE_DATE}
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			
			<!-- Todo (within a week) Assignment Cards --><hr>
			<div class="row" style="padding-left: 10px"><h4>To Do This Week</h4></div>
			<div class="row">
				<c:forEach items="${todo}" var="obj">
					<div class="col-sm">
						<div class="card">
							<div class="card-body">
								<div class="card-header">
									<h5 class="card-title">${obj.stream_name} </h5>
									<h6 class="card-subtitle mb-2 text-muted">${obj.assignment_name}</h6>
								</div>
								<p class="card-text">
									${obj.description}
								</p>
								<p class="card-footer text-white bg-warning">
									${obj.due_date}
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			
			<!-- Changelog --><hr>
			<div class="row" style="padding-left: 10px"><h4>Changelog</h4></div>
			<div class="row" style="padding-left: 20px">
				<c:forEach items="${changelog}" var="obj">
				<p>${obj.assignment_name} to your ${obj.session_name}. See the Assignment <a href="/"> Here.</a></p><br>
				</c:forEach>
			</div>
		</div>
	</fieldset>
</body>
</html>