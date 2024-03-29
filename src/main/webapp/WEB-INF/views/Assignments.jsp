<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>Instructor Assignments</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
<link rel="stylesheet" href="/resources/css/nexusbord.css">
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
		<div id="navDiv" class="navigation"></div>
	</header>
	<fieldset class="container">
		<div class="tabbable boxed parentTabs p-4">
			<ul class="nav nav-tabs" id="classTabs">
				<!--  change #instructor to #classID, update JS classID, inject className  -->
				<c:forEach items="${classes}" var="cl">
					<li><a href="#class${cl.CLASS_ID}" id="${cl.role_id}"
						class="nav-link">${cl.stream_name}</a></li>
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
						<div class="modal" id="af${cl.class_id }">
									<div class="modal-dialog">
										<div class="modal-content">

											<!-- Modal Header -->
											<div class="modal-header">
												<h4 class="modal-title">Add new assignment file: </h4>
												<button type="button" class="close" data-dismiss="modal">&times;</button>
											</div>

											<!-- Modal body -->
											<div class="modal-body">
												<form action="/addAssignmentsFile" method="POST" class="form-group" enctype="multipart/form-data">
													<input type="text" name="name" placeholder="Enter name"/>
													<br>
													<br>
													<input type="text" name="desc" placeholder="Enter description"/>
													<br>
													<br>
													<select name="status">
														<option>active</option>
														<option>inactive</option>
														<option>completed</option>
													</select>
													<br>
													<br>
													<input type="date" name="due_date"/>
													<br>
													<br>													
													<select name="module_id">
																	<c:forEach items="${modules}" var ="module">
																		<option value="${module.module_id}">${module.module_name }</option>
																	</c:forEach>
																	</select>
																	<input type="hidden" name="class_id" value="${cl.class_id }"/>
														<br>
														<br>
														<input type="hidden" name="stream_id" value="${cl.stream_id }" />
													<input type="file" name="fileName" />
													<br>
													<br>
													<input class="submissionButtons" type="submit" value="submit" /></span>
												</form>
											</div>

											<!-- Modal footer -->
											<div class="modal-footer">
												<button type="button" class="submissionButtons"
													data-dismiss="modal">Close</button>
											</div>

										</div>
									</div>
								</div>
							<div class="tab-pane fade" id="class${cl.class_id}">
								<div class="tabbable">
									<ul class="nav nav-tabs" id="${cl.stream_name}">
										<li class="active"><a href="#sub${count }"
											class="nav-link">All Assignments </a></li>
										<li><a href="#sub${count +1 }" class="nav-link">Assignments
												OverDue <span class="badge badge-danger">${fn:length(olist)}</span>
										</a></li>
										<li><a href="#sub${count + 2 }" class="nav-link">Assignments
												To Grade <span class="badge badge-danger">${fn:length(tgList)}</span>
										</a></li>
										<li>
										<c:choose>
												<c:when test="${cl.role_id == 1}">
													<button type="button" class="submissionButtons"
														data-toggle="modal" data-target="#af${cl.class_id }">New Assignment
													</button>
													</c:when>
											</c:choose>
										
										</li>
									</ul>
									<div class="tab-content">
										<div class="tab-pane fade" id="sub${count }">
											<div>
												<table class="table">
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
										<div class="tab-pane fade" id="sub${count +1 }">
											<div>
												<table class="table">
													<tr>
														<th>Employee</th>
														<th>Assignment Name</th>
														<th>Due Date</th>
													</tr>
													<c:forEach items="${olist}" var="in">
														<tr>
															<td>${in.employee_id}</td>
															<td>${in.assignment_name}</td>
															<td>${in.due_date}</td>
														</tr>
													</c:forEach>
												</table>
											</div>
										</div>
										<div class="tab-pane fade" id="sub${count + 2 }">
											<div>
												<table class="table">
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
															<td>
																<form name="grades" action="?grades" method="POST">
																	<input type="hidden" name="employee_id"
																		value="${in.employee_id }" /> <input type="hidden"
																		name="assignment_id" value="${in.assignment_id }" />
																	<input type="text" name="grade"
																		placeholder="${in.grade}" /> <input
																		class="submissionButtons" type="submit" value="submit" />
																</form>
															</td>
														</tr>
													</c:forEach>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="tab-pane fade" id="class${cl.class_id}">
								<div class="tabbable">
									<ul class="nav nav-tabs" id="${cl.stream_name}">
										<li class="active"><a href="#sub${count +3}"
											class="nav-link"> All Assignments</a></li>
										<li><a href="#sub${count+4 }" class="nav-link">Graded
												Assignments</a></li>
										<li><a href="#sub${count+5}" class="nav-link">Assignments
												To Do <span class="badge badge-danger">${fn:length(todoAssignments)}</span>
										</a></li>
									</ul>
									<div class="tab-content">
										<div class="tab-pane fade" id="sub${count+3}">
											<div>
												<table class="table">
													<tr>
														<th>Assignment Name</th>
														<th>Due Date</th>
														<th>Submission Date</th>
													</tr>
													<c:forEach items="${asList}" var="dl">
														<c:forEach items="${dl}" var="in">
															<tr>
																<td>${in.assignment_name}</td>
																<td>${in.due_date}</td>
																<td>${in.submission_date}</td>
															</tr>
														</c:forEach>
													</c:forEach>
												</table>
											</div>
										</div>
										<div class="tab-pane fade" id="sub${count+4}">
											<div>
												<table class="table">
													<tr>
														<th>Assignment Name</th>
														<th>Due Date</th>
														<th>Submission Date</th>
														<th>File Name</th>
														<th>Grade</th>
													</tr>
													<c:forEach items="${sgList}" var="dl">
														<c:forEach items="${dl}" var="in">
															<tr>
																<td>${in.assignment_name}</td>
																<td>${in.due_date}</td>
																<td>${in.submission_date}</td>
																<td>${in.file_name }</td>
																<td>${in.grade }</td>
															</tr>
														</c:forEach>
													</c:forEach>
												</table>
											</div>
										</div>
										<div class="tab-pane fade" id="sub${count+5}">
											<div>
												<table class="table">
													<tr>
														<th>Assignment Name</th>
														<th>Due Date</th>
														<th>Submit Assignment</th>
													</tr>
													<c:forEach items="${todoAssignments}" var="in">
														<tr>
															<td>${in.assignment_name}</td>
															<td>${in.due_date}</td>
															<!--  assignment_id, stream_id, module_id, and class_id -->
															<td>
																<form name="assignment" action="?assignment"
																	method="POST" enctype="multipart/form-data">
																	<input type="hidden" name="employee_id"
																		value="${in.employee_id }" /> <input type="hidden"
																		name="assignment_id" value="${in.assignment_id }" />
																	<input type="hidden" name="stream_id"
																		value="${cl.stream_id}" /> <input type="hidden"
																		name="module_id" value="${in.module_id}" /> <input
																		type="hidden" name="class_id" value="${cl.class_id}" />
																	<input class="submissionButtons" type="submit"
																		value="submit" />
																</form>
															</td>
														</tr>
													</c:forEach>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
					<c:set var="count" value="${count + 6}" scope="page" />
				</c:forEach>
			</div>
		</div>
	</fieldset>
	<script js>
		$("ul.nav-tabs a").click(function(e) {
			e.preventDefault();
			$(this).tab('show');
		});
		$(document).ready(() => {
			  let url = location.href.replace(/\/$/, "");
			  if (location.hash) {
			    const hash = url.split("#");
			    $('#classTabs a[href="#'+hash[1]+'"]').tab("show");
			    $('#' + hash[2] + ' a[href="#'+hash[3]+'"]').tab("show");
			    url = location.href.replace(/\/#/, "#");
			    history.replaceState(null, null, url);
			    setTimeout(() => {
			      $(window).scrollTop(0);
			    }, 400);
			  } 
			   
			});
	</script>
	<!-- Container for logout modal -->	
	<div id="LogoutModalDiv"></div>
</body>
</html>