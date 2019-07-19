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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
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
		<div id="navDiv" class="navigation"></div>
	</header>


	<fieldset
		style="width: 90%; margin: auto; height: 520px; background-color: white;">
		<div class="tabbable boxed parentTabs p-4">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#instructor" class="nav-link">My Class</a></li>
				<li><a href="#class1" class="nav-link">Enrolled In Class1</a></li>
				<li><a href="#class2" class="nav-link">Enrolled In Class2</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane fade active in" id="instructor">
					<div class="tabbable">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#sub11" class="nav-link">To Grade</a></li>
							<li><a href="#sub12" class="nav-link">OverDue</a></li>
							<li><a href="#sub13" class="nav-link">All Assignments</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane fade active in" id="sub11">
								<p>list of assignments submitted with grade = null</p>
							</div>
							<div class="tab-pane fade" id="sub12">
								<p>list of employees with overdue assignments</p>
							</div>
							<div class="tab-pane fade" id="sub13">
								<p>all assignments grouped by current status</p>
							</div>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="class1">
					<div class="tabbable">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#sub21" class="nav-link">To Do</a></li>
							<li><a href="#sub22" class="nav-link">All Assignments</a></li>
							<li><a href="#sub23" class="nav-link">Grades</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane fade active in" id="sub21">
								<p>active assignments currently not submitted</p>
							</div>
							<div class="tab-pane fade" id="sub22">
								<p>all assignments including already submitted ones</p>
							</div>
							<div class="tab-pane fade" id="sub23">
								<p>all submitted assignments with their grade value displayed</p>
							</div>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="class2">
					<div class="tabbable">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#sub31" class="nav-link">To Do</a></li>
							<li><a href="#sub32" class="nav-link">All Assignments</a></li>
							<li><a href="#sub33" class="nav-link">Grades</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane fade active in" id="sub31">
								<p>active assignments currently not submitted - 2</p>
							</div>
							<div class="tab-pane fade" id="sub32">
								<p>all assignments including already submitted ones - 2</p>
							</div>
							<div class="tab-pane fade" id="sub33">
								<p>all submitted assignments with their grade value displayed - 2</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</fieldset>
	<script js>
		$("ul.nav-tabs a").click(function(e) {
			e.preventDefault();
			$(this).tab('show');
		});
	</script>


</body>
</html>
