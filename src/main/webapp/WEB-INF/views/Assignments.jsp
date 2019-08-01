<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
									<div class="modal-content" style="width: 471px;">

										<!-- Modal Header -->
										<div class="modal-header"
											style="padding-bottom: 8px; padding-left: 24px; padding-top: 8px; padding-right: 15px; -webkit-gradient (linear, left top, left bottom, color-stop(0.05, #04abd0), color-stop(1, #0493b3)); background: -moz-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -webkit-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -o-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -ms-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: linear-gradient(to bottom, #04abd0 5%, #0493b3 100%);">
											<h4 class="modal-title">
												<font color="white"> New Assignment </font>
											</h4>
											<button type="button" class="close" aria-label="Close"
												data-dismiss="modal" style="padding-top: -14px;">
												<span style="text-shadow: 0 0px 0 #fff; color: #fff;">&times;</span>
											</button>
										</div>

										<!-- Modal body -->
										<div class="modal-body">
											<form action="/addAssignmentsFile" method="POST"
												class="form-group" enctype="multipart/form-data"
												style="margin-bottom: 0px; padding-top: 4px;">
												<table>
													<tbody>
														<tr>
															<th scope="row"><input type="text" name="name"
																placeholder="Assignment Name"
																title="Please enter an assignment name."
																style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px;" /></th>
															<td><input type="text" name="desc"
																placeholder="Assignment Description"
																title="Please enter an assignment description."
																style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px;" /></td>
														</tr>
														<tr>
															<th scope="row"><span
																class="custom-dropdown custom-dropdown--white"> <select
																	name="status"
																	title="Please select an assignment status."
																	class="custom-dropdown__select custom-dropdown__select--white"
																	style="padding-left: 0px; padding-right: 114px;">
																		<option>active</option>
																		<option>inactive</option>
																		<option>completed</option>
																</select>
															</span></th>
															<td><input title="Please enter a due date."
																type="date" name="due_date"
																style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px;" /></td>
														</tr>
														<tr>
															<th scope="row"><span
																class="custom-dropdown custom-dropdown--white"> <select
																	name="module_id" title="Please select a module."
																	class="custom-dropdown__select custom-dropdown__select--white"
																	style="padding-left: 0px;">
																		<c:forEach items="${modules}" var="module">
																			<option value="${module.module_id}">${module.module_name }</option>
																		</c:forEach>
																</select>
															</span></th>
															<td><div class="custom-file">
																	<input title="Upload an assignment file." type="file"
																		class="custom-file-input" id="fileName"
																		name="fileName"> <label
																		class="custom-file-label" for="customFile">
																		Choose file </label>
																</div></td>
														</tr>
													</tbody>
												</table>
												<input type="hidden" name="class_id" value="${cl.class_id }" />
												<input type="hidden" name="stream_id"
													value="${cl.stream_id }" /> <input
													class="submissionButtons" type="submit" value="submit"
													style="margin-top: 10px; margin-left: 7px; margin-bottom: 2px;" />
												<input class="inactiveButtons" type="reset" value="clear"
													style="margin-top: 10px; margin-left: 236px; margin-bottom: 2px;" />
											</form>
										</div>
									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="class${cl.class_id}">
								<div class="tabbable">
									<ul class="nav nav-tabs" id="${cl.stream_name}">
										<li class="active"><a href="#all${cl.class_id}"
											class="nav-link">All Assignments </a></li>

										<li><a href="#overdue${cl.class_id}" class="nav-link">Assignments
												OverDue <span class="badge badge-primary">${fn:length(olist)}</span>
										</a></li>
										<li><a href="#toGrade${cl.class_id}" class="nav-link">Assignments
												To Grade <span class="badge badge-primary">${fn:length(tgList)}</span>
										</a></li>
										<li><c:choose>
												<c:when test="${cl.role_id == 1}">
													<button type="button" class="submissionButtons"
														style="margin-top: 4px; margin-left: 180px;"
														data-toggle="modal" data-target="#af${cl.class_id }">New
														Assignment</button>
												</c:when>
											</c:choose></li>
									</ul>
									<div class="tab-content">
										<div class="tab-pane fade" id="all${cl.class_id}">
											<div>
												<table class="table table-striped">
													<tr>
														<th>Edit Assignment</th>
														<th>Status</th>
														<th>Assignment Name</th>
														<th>Due Date</th>
													</tr>
													<c:forEach items="${daList}" var="dl">
														<c:forEach items="${dl}" var="in">
															<div class="modal" id="edit${cl.class_id}_${in.assignment_id}">
																<div class="modal-dialog">
																	<div class="modal-content">
																		<div class="modal-header" style="-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #04abd0), color-stop(1, #0493b3)); background: -moz-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -webkit-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -o-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -ms-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: linear-gradient(to bottom, #04abd0 5%, #0493b3 100%);">
																			<h4 class="modal-title">Edit An Assignment</h4>
																			<button type="button" class="close" data-dismiss="modal">&times;</button>
																		</div>
																		<div class="modal-body">
																			<form action="/editAssignmentsFile" method="POST" class="form-group" enctype="multipart/form-data">
																				<input type="text" name="name" placeholder="Enter name" value="${ in.assignment_name}"/>
																				<input type="text" name="desc" placeholder="Enter description" value="${ in.description}"/>
																				<select name="status">
																					<c:choose>
																						<c:when test="${in.status == 'active'}">
																							<option selected>active</option>
																						</c:when>
																						<c:otherwise>
																							<option>active</option>
																						</c:otherwise>
																					</c:choose>
																					<c:choose>
																						<c:when test="${in.status == 'inactive'}">
																							<option selected>inactive</option>
																						</c:when>
																						<c:otherwise>
																							<option>inactive</option>
																						</c:otherwise>
																					</c:choose>
																					<c:choose>
																						<c:when test="${in.status == 'completed'}">
																							<option selected>completed</option>
																						</c:when>
																						<c:otherwise>
																							<option>completed</option>
																						</c:otherwise>
																					</c:choose>
																				</select>
																				<input type="date" name="due_date" value="${in.formattedDate}"/>												
																				<select name="module_id">
																								<c:forEach items="${modules}" var ="module">
																								<c:choose>
																									<c:when test="${in.module_id == module.module_id}">
																										<option selected value="${module.module_id}">${module.module_name }</option>
																									</c:when>
																									<c:otherwise>
																										<option value="${module.module_id}">${module.module_name }</option>
																									</c:otherwise>
																								</c:choose>
																								</c:forEach>
																								</select>
																								<input type="hidden" name="class_id" value="${cl.class_id }"/>
																					<input type="hidden" name="stream_name" value = "${cl.stream_name}"/>
																					<input type="hidden" name="stream_id" value="${cl.stream_id }" />
																					<input type="hidden" name="assignment_id" value="${in.assignment_id}"/>
																				<input type="file" name="fileName" value="${in.file_name}"/>
																				<input class="submissionButtons" type="submit" value="submit" />
																			</form>
																									</div>
																		<div class="modal-footer">
																			<button type="button" class="inactiveButtons" data-dismiss="modal">Close</button>
																			<form action="/deleteAssignments" method="POST" class="form-group">
																				<input type="hidden" name="assignmentID" value="${in.assignment_id}"/>
																				<input type="hidden" name="classID" value = "${cl.class_id }"/>
																				<input type="hidden" name="stream_name" value = "${cl.stream_name}"/>
																				<input class="dangerButtons" type="submit" value="Delete"/>
																			</form>
																		</div>
																								
																	</div>
																</div>
															</div>
															<tr>
																<td>
																	<button type="button" class="submissionButtons" data-toggle="modal" data-target="#edit${cl.class_id}_${in.assignment_id}">Edit </button>
																</td>
																<td>${in.STATUS}</td>
																<td>${in.assignment_name}</td>
																<td>${in.due_date}</td>
															</tr>
														</c:forEach>
													</c:forEach>
												</table>
											</div>
										</div>
										<div class="tab-pane fade" id="overdue${cl.class_id}">
											<div>
												<table class="table table-striped">
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
										<div class="tab-pane fade" id="toGrade${cl.class_id}">
											<div>
												<table class="table table-striped">
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
																	<input type ="hidden" name="class_id" value="${cl.class_id}"/>
																	<input type ="hidden" name="stream_name" value="${cl.stream_name}"/>
																	<input style="width:20%; margin-left:10px; margin-right: 10px;" type="text" name="grade"
																		placeholder="${in.grade}" /><span> <input style="padding: 0px 0px; font-size: 16px; width: 26px; height: 26px"
																		class="submissionButtons" type="submit" value="+" /></span>
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
										<li class="active"><a href="#all${cl.class_id}"
											class="nav-link"> All Assignments</a></li>
										<li><a href="#graded${cl.class_id}" class="nav-link">Graded
												Assignments</a></li>

										<li><a href="#toDo${cl.class_id}" class="nav-link">Assignments
												To Do <span class="badge badge-primary">${fn:length(todoAssignments)}</span>
										</a></li>
									</ul>
									<div class="tab-content">
										<div class="tab-pane fade" id="all${cl.class_id}">
											<div>
												<table class="table table-striped">
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
										<div class="tab-pane fade" id="graded${cl.class_id}">
											<div>
												<table class="table table-striped">
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
										<div class="tab-pane fade" id="toDo${cl.class_id}">
											<div>
												<table class="table table-striped">
													<tr>
														<th>Assignment Name</th>
														<th>Due Date</th>
														<th>Submit Assignment</th>
													</tr>
													<c:forEach items="${todoAssignments}" var="in">
														<div class="modal" id="submit${cl.class_id}_${in.assignment_id}">
															<div class="modal-dialog">
																<div class="modal-content">
																	<div class="modal-header" style="-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #04abd0), color-stop(1, #0493b3)); background: -moz-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -webkit-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -o-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -ms-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: linear-gradient(to bottom, #04abd0 5%, #0493b3 100%);">
																		<h4 class="modal-title">Upload a File for the Assignment </h4>
																		<button type="button" class="close" data-dismiss="modal">&times;</button>
																	</div>
																	<div class="modal-body">
																	<form action="/submitAssignment" method="POST" class="form-group" enctype="multipart/form-data">
																		<input type="hidden" name="employee_id" value="${in.employee_id }" /> 
																		<input type="hidden" name="assignment_id" value="${in.assignment_id }" />
																		<input type="hidden" name="stream_id" value="${cl.stream_id}" /> 
																		<input type="hidden" name="module_id" value="${in.module_id}" /> 
																		<input type="hidden" name="class_id" value="${cl.class_id}" />
																		<input type="hidden" name="stream_name" value="${cl.stream_name}" />
																		<input type="file" id="uploadFile" name="fileName"/>
																		<input class="btn btn-primary" type="submit" value="submit" />
																	</form>
																	</div>
																<!-- Modal footer -->
																	<div class="modal-footer">
																		<button type="button" class="inactiveButtons" data-dismiss="modal">Close</button>
																	</div>
																							
																</div>
															</div>
														</div>
														<tr>
															<td>${in.assignment_name}</td>
															<td>${in.due_date}</td>
															<td>
																<button type="button" class="submissionButtons" data-toggle="modal" data-target="#submit${cl.class_id}_${in.assignment_id}">Submit </button>
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
	<script>
		$(".custom-file-input").on("change", function() {
 			var fileName = $(this).val().split("\\").pop();
  			$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
		});
	</script>
	<!-- Container for logout modal -->
	<div id="LogoutModalDiv"></div>
</body>
</html>