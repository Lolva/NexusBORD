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
			<div class="row" style="padding-left: 10px"><h4>Overdue Assignments</h4></div>
			<div class="row">
				<div class="col-sm">
					<div class="card">
						<div class="card-body">
							<div class="card-header">
								<h5 class="card-title">Class Name</h5>
								<h6 class="card-subtitle mb-2 text-muted">Assignment Name</h6>
							</div>
							<p class="card-text">
								Description
							</p>
							<p class="card-footer text-white bg-danger">
								Due Date
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm">
					<div class="card">
						<div class="card-body">
							<div class="card-header">
								<h5 class="card-title">Class Name</h5>
								<h6 class="card-subtitle mb-2 text-muted">Assignment Name</h6>
							</div>
							<p class="card-text">
								Description
							</p>
							<p class="card-footer text-white bg-danger">
								Due Date
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm">
					<div class="card">
						<div class="card-body">
							<div class="card-header">
								<h5 class="card-title">Class Name</h5>
								<h6 class="card-subtitle mb-2 text-muted">Assignment Name</h6>
							</div>
							<p class="card-text">
								Description
							</p>
							<p class="card-footer text-white bg-danger">
								Due Date
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm">
					<div class="card">
						<div class="card-body">
							<div class="card-header">
								<h5 class="card-title">Class Name</h5>
								<h6 class="card-subtitle mb-2 text-muted">Assignment Name</h6>
							</div>
							<p class="card-text">
								Description
							</p>
							<p class="card-footer text-white bg-danger">
								Due Date
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm">
					<div class="card">
						<div class="card-body">
							<div class="card-header">
								<h5 class="card-title">Class Name</h5>
								<h6 class="card-subtitle mb-2 text-muted">Assignment Name</h6>
							</div>
							<p class="card-text">
								Description
							</p>
							<p class="card-footer text-white bg-danger">
								Due Date
							</p>
						</div>
					</div>
				</div>
			</div>
			<hr>
			<div class="row" style="padding-left: 10px"><h4>To Do This Week</h4></div>
			<div class="row">
				<div class="col-sm">
					<div class="card">
						<div class="card-body">
							<div class="card-header">
								<h5 class="card-title">Class Name</h5>
								<h6 class="card-subtitle mb-2 text-muted">Assignment Name</h6>
							</div>
							<p class="card-text">
								Description
							</p>
							<p class="card-footer text-white bg-warning">
								Due Date
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm">
					<div class="card">
						<div class="card-body">
							<div class="card-header">
								<h5 class="card-title">Class Name</h5>
								<h6 class="card-subtitle mb-2 text-muted">Assignment Name</h6>
							</div>
							<p class="card-text">
								Description
							</p>
							<p class="card-footer text-white bg-warning">
								Due Date
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm">
					<div class="card">
						<div class="card-body">
							<div class="card-header">
								<h5 class="card-title">Class Name</h5>
								<h6 class="card-subtitle mb-2 text-muted">Assignment Name</h6>
							</div>
							<p class="card-text">
								Description
							</p>
							<p class="card-footer text-white bg-warning">
								Due Date
							</p>
						</div>
					</div>
				</div>
			</div>
			<hr>
			<div class="row" style="padding-left: 10px"><h4>Changelog</h4></div>
			<div class="row" style="padding-left: 20px">
				<p>(Instructor Name) added (Assignment/File Name) to your (Class Name). See the Assignment <a href="/"> Here.</a></p><br>
				<p>(Instructor Name) added (Assignment/File Name) to your (Class Name). See the Assignment <a href="/"> Here.</a></p><br>
				<p>(Instructor Name) added (Assignment/File Name) to your (Class Name). See the Assignment <a href="/"> Here.</a></p><br>
			</div>
		</div>
	</fieldset>
</body>
</html>