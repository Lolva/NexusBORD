<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Classes</title>
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
<script src="https://kit.fontawesome.com/b1cf46027b.js"></script>

</head>

<body onload="navBar(this, 'modules', 'student')">
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
			<ul class="nav nav-tabs">
				<!--  change #instructor to #classID, update JS classID, inject className  -->
				<c:forEach items="${classes}" var="cl">
					<li class="active"><a href="#d${cl.CLASS_ID}"
						id="${cl.role_id}" class="nav-link">${cl.stream_name}</a></li>
					<!--  change href to #classID, inject className. update classID in JS  -->
				</c:forEach>
			</ul>
			<div class="tab-content">
				<c:forEach items="${classes}" var="c">
					<div id="d${c.class_id}" class="tab-pane fade in">
						<c:forEach items="${modules}" var="o">
							<c:choose>
								<c:when test="${o.class_id==c.class_id}">
									<button value="button" class="accordion">${o.module_name}</button>
								</c:when>
							</c:choose>
							<div class="panel">
								<br>
								<c:choose>
									<c:when test="${c.role_id == 1}">
										<button type="button" class="submissionButtons"
											data-toggle="modal" data-target="#m${o.module_id }">Edit
										</button>
										<div class="modal" id="m${o.module_id }">
											<div class="modal-dialog">
												<div class="modal-content">
													<!-- Modal Header -->
													<div class="modal-header">
														<h4 class="modal-title">Edit this module:
															${o.module_name}</h4>
														<button type="button" class="close" data-dismiss="modal">&times;</button>
													</div>
													<!-- Modal body -->
													<div class="modal-body">
														<form action="/updateModule" method="POST"
															class="form-group">
															<input type="text" required
																placeholder="${o.module_name}" name="module_name" /> <input
																type="hidden" value="${o.module_id }" name="module_id" />
															<input class="submissionButtons" type="submit"
																value="Edit" />
														</form>
														<form action="/deleteModule" method="POST"
															class="form-group">
															<input type="hidden" name="module_id"
																value="${o.module_id }" /> <span><input
																class="dangerButtons" type="submit"
																value="Delete module" /></span>
														</form>
													</div>
													
												</div>
											</div>
										</div>
									</c:when>
								</c:choose>
								<div class="modal" id="mf${o.module_id }">
									<div class="modal-dialog">
										<div class="modal-content">

											<!-- Modal Header -->
											<div class="modal-header">
												<h4 class="modal-title">Add new module file:
													${o.module_name}</h4>
												<button type="button" class="close" data-dismiss="modal">&times;</button>
											</div>
											<!-- Modal body -->
											<div class="modal-body">
												<form action="/addModuleFile" method="POST"
													class="form-group" enctype="multipart/form-data">
													Name: <input type="text" name="name" /> Description: <input type="text"
														name="desc" /> <input type="hidden" name="module_id"
														value="${o.module_id }" /> <input type="hidden"
														name="class_id" value="${c.class_id }" /> <input
														type="hidden" name="stream_id" value="${c.stream_id }" />
													File: <input type="file" name="fileName" /> <br> <br>
													<input class="submissionButtons" type="submit"
														value="submit" />
												</form>
											</div>
											
										</div>
									</div>
								</div>
								<table>
									<tr>
										<th>Module Files:</th>
										<td style="padding-bottom: 10px; width: 200px;"><c:choose>
												<c:when test="${c.role_id == 1}">
													<button type="button" class="submissionButtons"
														style="padding: 0px 0px; font-size: 16px; width: 26px; height: 26px"
														data-toggle="modal" data-target="#mf${o.module_id }">+
													</button>
												</c:when>
											</c:choose></td>
									</tr>
									<c:forEach items="${modulefiles}" var="j">
										<div class="modal" id="mfe${j.module_file_id }">
									<div class="modal-dialog">
										<div class="modal-content">

											<!-- Modal Header -->
											<div class="modal-header">
												<h4 class="modal-title">Edit module file:</h4>
												<button type="button" class="close" data-dismiss="modal">&times;</button>
											</div>
											<!-- Modal body -->
											<div class="modal-body">
												<form action="/editModuleFile" method="POST"
													class="form-group" enctype="multipart/form-data">
													Name: <input type="text" name="name" /> Description: <input type="text"
														name="desc" /> <input type="hidden" name="module_id"
														value="${o.module_id }" /> <input type="hidden"
														name="module_file_id" value="${j.module_file_id }" /> <input
														type="hidden" name="stream_id" value="${c.stream_id }" />
													File:<input type="file" name="file" /> <br> <br>
													<input class="submissionButtons" type="submit"
														value="submit" />
												</form>
											</div>
											
										</div>
									</div>
								</div>
										<c:choose>
											<c:when test="${o.module_id==j.module_id}">
												<tr>
												<td id="${k.assignment_id}"
														style="color: black; width: 200px"><a
														href="/downloadModule/${c.stream_id}/${o.module_id}/${j.file_name}/${j.file_type}">
															${j.name}</a>
														<c:choose>
															<c:when test="${c.role_id == 1}">
																<a class=" dropdown-toggle dropdown-toggle-split "
																	data-toggle="dropdown" aria-haspopup="true"
																	aria-expanded="false"> <span class="sr-only">Toggle
																		Dropdown</span>
																</a>
																<div class="dropdown-menu">
																	<a class="dropdown-item" data-toggle="modal"
																		data-target="#mfe${j.module_file_id}">Edit</a> <a
																		class="dropdown-item"
																		href="/deleteModuleFile/${j.module_file_id }">Delete</a>
																</div>
															</c:when>
														</c:choose>
													</td><td>${j.description }</td>
												<!-- 
													<td style="color: black; width: 200px"><a
														href="/downloadModule/${c.stream_id}/${o.module_id}/${j.file_name}/${j.file_type}">
															${j.file_name} </a></td>
													<c:choose>
														<c:when test="${c.role_id == 1}">
															<td style="width: 200px"><form
																	action="/deleteModuleFile" method="POST"
																	class="form-group">
																	<input type="hidden" name="module_file_id"
																		value="${j.module_file_id}" /> <span><input
																		style="color: red; width: 28px; padding-top: 1px; padding-right: 0px; padding-bottom: 2px; padding-left: 0px; font-size: 16px; border-top-width: 2px;"
																		type="submit" value="x" /></span>
																</form></td> 
														</c:when>
													</c:choose> -->
												</tr>
											</c:when>
										</c:choose>
									</c:forEach>
								</table>
								<div class="modal" id="af${o.module_id }">
									<div class="modal-dialog">
										<div class="modal-content">
											<!-- Modal Header -->
											<div class="modal-header">
												<h4 class="modal-title">Add new assignment file:
													${o.module_name}</h4>
												<button type="button" class="close" data-dismiss="modal">&times;</button>
											</div>
											<!-- Modal body -->
											<div class="modal-body">
												<form action="/addAssignmentFile" method="POST"
													class="form-group" enctype="multipart/form-data">
													<input type="text" name="name" placeholder="Enter name" />
													<br> <br> <input type="text" name="desc"
														placeholder="Enter description" /> <br> <br> <select
														name="status">
														<option>active</option>
														<option>inactive</option>
														<option>completed</option>
													</select> <br> <br> <input type="date" name="due_date" />
													<br> <br> <input type="hidden" name="module_id"
														value="${o.module_id }" /> <input type="hidden"
														name="class_id" value="${c.class_id }" /> <input
														type="hidden" name="stream_id" value="${c.stream_id }" />
													<input type="file" name="fileName" /> <span><input
														class="submissionButtons" type="submit" value="submit" /></span>
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

								<table>
									<tr>
										<th>Assignment Files:</th>
										<td style="padding-bottom: 10px; width: 200px;"><c:choose>
												<c:when test="${c.role_id == 1}">
													<button type="button" class="submissionButtons"
														style="padding: 0px 0px; font-size: 16px; width: 26px; height: 26px"
														data-toggle="modal" data-target="#af${o.module_id }">+
													</button>
												</c:when>
											</c:choose></td>
									</tr>
									<c:forEach items="${moduleassigns}" var="k">
										<div class="modal" id="a${k.assignment_id }">
											<div class="modal-dialog">
												<div class="modal-content">
													<!-- Modal Header -->
													<div class="modal-header">
														<h4 class="modal-title">Edit assignment file:</h4>
														<button type="button" class="close" data-dismiss="modal">&times;</button>
													</div>
													<!-- Modal body -->
													<div class="modal-body">
														<form action="/editAssignmentFile" method="POST"
															class="form-group" enctype="multipart/form-data">
															Assignment Name: <input type="text"
																name="assignment_name" value="${k.assignment_name }" />
															<br> <br> Description: <input type="text"
																name="desc" value="${k.description }" /> <br> <br>
															Status: <select name="status">
																<option>active</option>
																<option>inactive</option>
																<option>completed</option>
															</select> <br> <br> Due Date (YYYY-MM-DD): <input
																type="text"
																value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "${k.due_date}" />"
																name="due_date" /> <br> <br> Module: <select
																name="module_id"><c:forEach items="${modules}"
																	var="mo">
																	<option value="${mo.module_id}">${mo.module_name}</option>
																</c:forEach></select> <br> <input type="hidden" name="assignment_id"
																value="${k.assignment_id}" /><input type="hidden"
																name="class_id" value="${c.class_id }" /> <input
																type="hidden" name="stream_id" value="${c.stream_id }" />
															<br> <input type="file" name="fileName" /><br>
															<br>
															<input class="submissionButtons" type="submit"
																value="Submit" /> <input class="submissionButtons"
																type="reset" value="Clear" />
														</form>
													</div>

												</div>
											</div>
										</div>
										<c:choose>
											<c:when test="${o.module_id==k.module_id}">
												<tr>
													<td id="${k.assignment_id}"
														style="color: black; width: 200px"><a
														href="/downloadAssign/${c.stream_id}/${c.class_id}/${o.module_id}/${k.file_name}/${k.file_type}">${k.assignment_name}</a>
														<c:choose>
															<c:when test="${c.role_id == 1}">
																<a class=" dropdown-toggle dropdown-toggle-split "
																	data-toggle="dropdown" aria-haspopup="true"
																	aria-expanded="false"> <span class="sr-only">Toggle
																		Dropdown</span>
																</a>
																<div class="dropdown-menu">
																	<a class="dropdown-item" data-toggle="modal"
																		data-target="#a${k.assignment_id }">Edit</a> <a
																		class="dropdown-item"
																		href="/deleteAssignment/${k.assignment_id }">Delete</a>
																</div>
															</c:when>
														</c:choose>
													</td>
													<td>${k.description }</td>
												</tr>
											</c:when>
										</c:choose>
									</c:forEach>
								</table>
							</div>
						</c:forEach>
						<div>
							<c:choose>
								<c:when test="${c.role_id == 1}">
									<button type="button" class="submissionButtons"
										data-toggle="modal" data-target="#myModal"
										style="margin-top: 10px">Add new</button>
									<div class="modal" id="myModal">
										<div class="modal-dialog">
											<div class="modal-content">
												<!-- Modal Header -->
												<div class="modal-header">
													<h4 class="modal-title">Add new module to class</h4>
													<button type="button" class="close" data-dismiss="modal">&times;</button>
												</div>
												<!-- Modal body -->
												<div class="modal-body">
													<form action="/addModule" method="POST" class="form-group">
														<label for="module_name">Enter Module Name </label> <input
															type="text" name="module_name" placeholder="Module Name"
															class="form-control" /> <input type="hidden"
															name="stream_id" value="${c.stream_id }" /> <input
															class="submissionButtons" id="addmodulebtn" type="submit"
															style="margin-top: 10px;" />
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
								</c:when>
							</c:choose>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</fieldset>
	<script type="text/javascript">
		var acc = document.getElementsByClassName("accordion");
		var i;
		for (i = 0; i < acc.length; i++) {
			acc[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var panel = this.nextElementSibling;
				if (panel.style.maxHeight) {
					panel.style.maxHeight = null;
				} else {
					panel.style.maxHeight = panel.scrollHeight + "px";
				}
			});
		}
	</script>
	<script js>
		$("ul.nav-tabs a").click(function(e) {
			e.preventDefault();
			$(this).tab('show');
		});
	</script>

	<!-- Container for logout modal -->
	<div id="LogoutModalDiv"></div>
</body>
</html>
