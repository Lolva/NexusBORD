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
				<!--  change #instructor to #classID, update JS classID, inject className  -->
				<c:forEach items="${classes}" var="cl">
					<li><a href="#class${cl.CLASS_ID}" id="${cl.role_id}"
						class="nav-link">${cl.stream_name} ${cl.role_id}</a></li>
					<!--  change href to #classID, inject className. update classID in JS  -->

				</c:forEach>
			</ul>

			<!--  change to class ID from first model -->
			<c:set var="count" value="0" scope="page" />
			<c:set var="county" value="100" scope="page" />

			<div class="tab-content">
				<c:forEach items="${classes}" var="cl">
				<c:choose>
					<c:when test="${cl.role_id == 1}">
					<div class="tab-pane fade active in" id="class${cl.class_id}">
						<div class="tabbable">
							<ul class="nav nav-tabs" id="${cl.stream_name}">
								
									Instructor View
									<li class="active"><a href="#sub0" class="nav-link">All
												Assignments</a></li>
										<li><a href="#sub1" class="nav-link">Assignments
												OverDue</a></li>
										<li><a href="#sub2" class="nav-link">Assignments To
												Grade</a></li>
									</ul>
									<div class="tab-content">
								<div class="tab-pane fade active in" id="sub0">
									<div>
										<table>
											<tr>
												<th>Status</th>
												<th>Assignment Name</th>
												<th>Due Date</th>
											</tr>


											<c:forEach items="${daList}" var="dl">
												<c:forEach items="${dl}" var="in">
													<tr>
														<td>${in.STATUS}</td>
														<td>${in.assignment_name}</td>
														<td>${in.due_date}</td>
													</tr>
												</c:forEach>

											</c:forEach>
										</table>
									</div>
								</div>
								<div class="tab-pane fade" id="sub1">
									<div>
										<table>
											<tr>
												<th>Employee</th>
												<th>Assignment Name</th>
												<th>Due Date</th>
											</tr>

										<c:forEach items="${odList}" var="dl">
											<c:forEach items="${dl}" var="in">

												<tr>
													<td>${in.employee_id}</td>
													<td>${in.assignment_name}</td>
													<td>${in.due_date}</td>
												</tr>
											</c:forEach>
										</c:forEach>

										</table>
									</div>
								</div>
								<div class="tab-pane fade" id="sub2">
									<div>
										<table>
											<tr>
												<th>Assignment Name</th>
												<th>Employee</th>
												<th>Due Date</th>
												<th>Submission Date</th>
												<th>File name</th>
												<th>Enter Grade</th>
											</tr>

											<c:forEach items="${tgList}" var="in">

												<tr>
													<td>${in.assignment_name}</td>
													<td>${in.employee_id}</td>
													<td>${in.due_date}</td>
													<td>${in.submission_date}</td>
													<td>${in.file_name}</td>
													<td><input type="text" placeholder="${in.grade}" /><input
														type="submit" value="submit" /></td>
												</tr>
											</c:forEach>


										</table>
									</div>
								</div>
								</div></div></div>
					</c:when>
					<c:otherwise>
									<div class="tab-pane fade active in" id="class${cl.class_id}">
									<div class="tabbable">
									<ul class="nav nav-tabs" id="${cl.stream_name}">
										<li class="active"><a href="#sub4" class="nav-link">
												All Assignments</a></li>
										<li><a href="#sub5" class="nav-link">Assignments To
												Do</a></li>
										<li><a href="#sub6" class="nav-link">Graded
												Assignments</a></li>
												</ul>
								<div class="tab-content">
								<div class="tab-pane fade" id="sub4">
									<p>to add</p>
								</div>
								<div class="tab-pane fade" id="sub5">
									<p>list of employees with overdue assignments</p>
								</div>
								<div class="tab-pane fade" id="sub6">
									<p>all assignments grouped by current status</p>
								</div>
							</div>
						</div>
					</div>
				</c:otherwise>
											
				</c:choose>
				</c:forEach>
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
