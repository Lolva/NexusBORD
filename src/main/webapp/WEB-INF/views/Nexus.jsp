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

<!-- Icons -->
<script src="https://kit.fontawesome.com/b1cf46027b.js"></script>
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
		style="width: 90%; margin: auto; height: 100%; background-color: white; margin-bottom: 5%; margin-top:20px;">
		<div class="jumbotron jumbotron-fluid" style=" -webkit-gradient (linear, left top, left bottom, color-stop(0.05, #04abd0), color-stop(1, #0493b3)); background: -moz-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -webkit-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -o-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -ms-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: linear-gradient(to bottom, #04abd0 5%, #0493b3 100%); padding: 5px;">
		  <div class="container">
		    <h1 class="display-5" style="color: white; margin: 1%;">Welcome to Nexus<i><b>BORD</b></i></h1>
		  </div>
		</div>
		
		<!--  
		<div style="background-color: #2E2E7F; padding: 2px;">
			<h2 style="color: white; margin: 10px; margin-top: 1%;">Welcome
				to NexusBORD</h2>
		</div>
		-->
		
		<div class="container-fluid">
		
			<!-- Overdue Assignment Cards -->
			<div class="row" style="padding-left: 10px; color: #0168aa;"><h4>Overdue Assignments</h4></div>
			<div class="row">
				<c:choose>
					<c:when test="${overdueSize > 0}">
						<c:forEach items="${overdue}" var="obj">
							<div class="col-sm-3 mb-4">
								<div class="card">
									<div class="card-body">
										<p class="card-text" style="font-size: 10pt;">
											<i class="fas fa-exclamation-triangle" style="color: gold;"></i> ${obj.DUE_DATE}
										</p>
										<div class="card-header">
											<h5 class="card-title">${obj.STREAM_NAME}</h5>
											<h6 class="card-subtitle mb-2 text-muted">${obj.ASSIGNMENT_NAME}</h6>
										</div>
										<p class="card-text">
											${obj.DESCRIPTION}
										</p>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="row" style="padding-left: 35px">
							<p>No overdue assignments!</p>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			
			<!-- Todo (within a week) Assignment Cards --><hr>
			<div class="row" style="padding-left: 10px; color: #0168aa;"><h4>To Do This Week</h4></div>
			<div class="row">
				<c:choose>
					<c:when test="${todoSize > 0}">
						<c:forEach items="${todo}" var="obj">
							<div class="col-sm-3 mb-4">
								<div class="card">
									<div class="card-body">
										<p class="card-text" style="font-size: 10pt;">
											${obj.DUE_DATE}
										</p>
										<div class="card-header">
											<h5 class="card-title">${obj.stream_name} </h5>
											<h6 class="card-subtitle mb-2 text-muted">${obj.assignment_name}</h6>
										</div>
										<p class="card-text">
											${obj.description}
										</p>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="row" style="padding-left: 35px">
							<p>No assignments due this week!</p>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			
			<!-- Changelog --><hr>
			<div class="row" style="padding-left: 10px; color: #0168aa;"><h4>Changelog</h4></div>
			<c:choose>
				<c:when test="${changelogSize > 0}">
					<c:forEach items="${changelog}" var="obj">
						<div class="row" style="padding-left: 20px">
						<p>Assignment <span style="color: orange;">${obj.assignment_name}</span> added to your class ${obj.stream_name}. See the Assignment <a href="/Assignments#class${obj.class_id}#${obj.stream_name}#toDo${obj.class_id}">Here</a>.
						</p>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="row" style="padding-left: 35px">
						<p>No recent changes</p>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</fieldset>
	
	<!-- Container for logout modal -->	
	<div id="LogoutModalDiv"></div>
</body>
</html>