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
													<div class="modal-header"
														style="padding-bottom: 8px; padding-left: 24px; padding-top: 8px; padding-right: 15px; -webkit-gradient (linear, left top, left bottom, color-stop(0.05, #04abd0), color-stop(1, #0493b3)); background: -moz-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -webkit-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -o-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -ms-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: linear-gradient(to bottom, #04abd0 5%, #0493b3 100%);">
														<h4 class="modal-title">
															<font color="white"> Edit Module </font>
														</h4>
														<button type="button" class="close" aria-label="Close"
															data-dismiss="modal" style="padding-top: -14px;">
															<span style="text-shadow: 0 0px 0 #fff; color: #fff;">&times;</span>
														</button>
													</div>
													<!-- Modal body -->
													<div class="modal-body">
														<form action="/updateModule" method="POST"
															class="form-group">
															<input type="text" required
																placeholder="${o.module_name}"title="Please enter a module name." class="borderlessInput" name="module_name" /> <input
																type="hidden" value="${o.module_id }" name="module_id" />
															
															<br><input style="margin-top:20px" class="submissionButtons" type="submit"
																value="Edit" />
																<input style="margin-top:20px; margin-left:302px;"  class="inactiveButtons" type="reset" value="clear" onclick="clearfile()" />
														</form>
														<form action="/deleteModule" method="POST"
															class="form-group">
															<input  style="margin-top:-50px"  type="hidden" name="module_id"
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
											<div class="modal-header"
												style="padding-bottom: 8px; padding-left: 24px; padding-top: 8px; padding-right: 15px; -webkit-gradient (linear, left top, left bottom, color-stop(0.05, #04abd0), color-stop(1, #0493b3)); background: -moz-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -webkit-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -o-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -ms-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: linear-gradient(to bottom, #04abd0 5%, #0493b3 100%);">
												<h4 class="modal-title">
													<font color="white"> New Module File </font>
												</h4>
												<button type="button" class="close" aria-label="Close"
													data-dismiss="modal" style="padding-top: -14px;">
													<span style="text-shadow: 0 0px 0 #fff; color: #fff;">&times;</span>
												</button>
											</div>
											<!-- Modal body -->
											<div class="modal-body" style="padding-bottom: 0px;">
												<form action="/addModuleFile" method="POST"
													class="form-group" enctype="multipart/form-data">
													<table>
														<tbody>
															<tr>
																<td><input class="borderlessInput" type="text"
																	name="name" placeholder="Module File Name"
																	title="Please enter a module file name." /></td>

																<td><input class="borderlessInput" type="text"
																	name="desc" placeholder="Description"
																	title="Please enter a module file description." /></td>
															</tr>
															<tr>
																<td><div class="custom-file">
																		<input title="Upload a module file." type="file"
																			class="custom-file-input" id="fileName"
																			name="fileName"> <label
																			class="custom-file-label" id="fileName2"
																			for="customFile"> Choose file </label>
																	</div></td>
															</tr>
														</tbody>
													</table>

													<input type="hidden" name="module_id"
														value="${o.module_id }" /> <input type="hidden"
														name="class_id" value="${c.class_id }" /> <input
														type="hidden" name="stream_id" value="${c.stream_id }" /><input
														class="submissionButtons" type="submit" value="submit"
														style="margin-top: 10px; margin-left: 7px; margin-bottom: 2px;" />
													<input class="inactiveButtons" type="reset" value="clear"
														style="margin-top: 10px; margin-left: 268px; margin-bottom: 2px;"
														onclick="clearfile()" />
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
													<div class="modal-header"
														style="padding-bottom: 8px; padding-left: 24px; padding-top: 8px; padding-right: 15px; -webkit-gradient (linear, left top, left bottom, color-stop(0.05, #04abd0), color-stop(1, #0493b3)); background: -moz-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -webkit-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -o-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -ms-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: linear-gradient(to bottom, #04abd0 5%, #0493b3 100%);">
														<h4 class="modal-title">
															<font color="white"> Edit Module File </font>
														</h4>
														<button type="button" class="close" aria-label="Close"
															data-dismiss="modal" style="padding-top: -14px;">
															<span style="text-shadow: 0 0px 0 #fff; color: #fff;">&times;</span>
														</button>
													</div>
													<!-- Modal body -->
													<div class="modal-body">
														<form action="/editModuleFile" method="POST"
															class="form-group" enctype="multipart/form-data">
															<input class="borderlessInput" placeholder="Module File Name" title="Please enter a module file name" type="text" name="name" value="${j.name}" />
															<input class="borderlessInput" placeholder="File Description" title="Please enter a module file description." type="text" name="desc"
																value="${j.description}" /><br><br> <select>
																<c:forEach items="${modulesI}" var="mo">
																	<c:choose>
																		<c:when test="${o.module_id eq j.module_id}">
																			<option value="${mo.module_id}" selected>${mo.module_name}</option>
																		</c:when>
																		<c:otherwise>
																			<option value="${mo.module_id}">${mo.module_name}</option>
																		</c:otherwise>
																	</c:choose>
																</c:forEach>
															</select><br><br> <input type="hidden" name="module_id"
																value="${o.module_id }" /> <input type="hidden"
																name="module_file_id" value="${j.module_file_id }" /> <input
																type="hidden" name="stream_id" value="${c.stream_id }" />
															<input type="file" name="file" /> <br> <br>
															<input class="submissionButtons" type="submit"
																value="submit" /> <input style="margin-left: 275px;"class="inactiveButtons"
																type="reset" value="Reset" />
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
															${j.name}</a> <c:choose>
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
														</c:choose></td>
													<td>${j.description }</td>
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
												<form action="/addAssignmentFile" method="POST"
													class="form-group" enctype="multipart/form-data">
													<input class="borderlessInput" type="text" title="Please enter an assignment name."  name="name" placeholder="Assignment Name" />
													<br> <br> <input class="borderlessInput" title="" type="text" name="desc"
														placeholder="Assignment Description" /> <br> <br> <select
														name="status">
														<option>active</option>
														<option>inactive</option>
														<option>completed</option>
													</select> <br> <br> <input type="date" name="due_date" />
													<br> <br> <input type="hidden" name="module_id"
														value="${o.module_id }" /> <input type="hidden"
														name="class_id" value="${c.class_id }" /> <input
														type="hidden" name="stream_id" value="${c.stream_id }" />
													<input type="file" name="fileName" /><br><br><input
														class="submissionButtons" type="submit" value="submit" />
														<input style="margin-left: 281px;"
														class="inactiveButtons" type="reset" value="clear" />
												</form>
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
													<div class="modal-header"
														style="padding-bottom: 8px; padding-left: 24px; padding-top: 8px; padding-right: 15px; -webkit-gradient (linear, left top, left bottom, color-stop(0.05, #04abd0), color-stop(1, #0493b3)); background: -moz-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -webkit-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -o-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -ms-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: linear-gradient(to bottom, #04abd0 5%, #0493b3 100%);">
														<h4 class="modal-title">
															<font color="white"> Edit Assignment </font>
														</h4>
														<button type="button" class="close" aria-label="Close"
															data-dismiss="modal" style="padding-top: -14px;">
															<span style="text-shadow: 0 0px 0 #fff; color: #fff;">&times;</span>
														</button>
													</div>
													<!-- Modal body -->
													<div class="modal-body">
														<form action="/editAssignmentFile" method="POST"
															class="form-group" enctype="multipart/form-data">
															<input class="borderlessInput" type="text"
																name="assignment_name" title="Please enter an assignment name." placeholder="Assignment Name" value="${k.assignment_name }" />
															<input style="margin-left:60px;" class="borderlessInput" placeholder="Assignment Description" type="text"
																name="desc" title="Please enter an assignment description." value="${k.description }" /> <br> <br>
															 <span
																class="custom-dropdown custom-dropdown--white"> <select
																	name="status"
																	title="Please select an assignment status."
																	class="custom-dropdown__select custom-dropdown__select--white"
																	style="padding:0px; margin-top:-15x; padding-right:40px;">
																		<option>active</option>
																		<option>inactive</option>
																		<option>completed</option>
																</select>
															</span><input type="date"
																value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "${k.due_date}" />"
																name="due_date" style="margin-left:114px;" /> <br><select
																name="module_id " style="margin-top:20px;"><c:forEach items="${modulesI}"
																	var="mo">
																	<c:choose>
																		<c:when test="${mo.module_id eq k.module_id}">
																			<option value="${mo.module_id}" selected>${mo.module_name}</option>
																		</c:when>
																		<c:otherwise>
																			<option value="${mo.module_id}">${mo.module_name}</option>
																		</c:otherwise>
																	</c:choose>
																</c:forEach></select> <input type="hidden" name="assignment_id"
																value="${k.assignment_id}" /><input type="hidden"
																name="class_id" value="${c.class_id }" /> <input
																type="hidden" name="stream_id" value="${c.stream_id }" /><br>
															 <input type="file" name="fileName" style="margin-top:20px;"/>
															 <br>
															 <input style="margin-top:20px" class="submissionButtons" type="submit"
																value="Submit" /> <input style="margin-top:20px; margin-left:273px;" class="inactiveButtons"
																type="reset" value="Reset" />
														</form>
													</div>
												</div>
											</div>
										</div>
										<c:choose>
											<c:when test="${o.module_id==k.module_id}">
												<tr>
													<td id="${k.assignment_id}"
														style="color: black; width: 200px"><c:choose>
															<c:when test="${empty k.file_name}">${k.assignment_name}
														</c:when>
															<c:otherwise>
																<a
																	href="/downloadAssign/${c.stream_id}/${c.class_id}/${o.module_id}/${k.file_name}/${k.file_type}">${k.assignment_name}</a>
															</c:otherwise>
														</c:choose> <c:choose>
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
														</c:choose></td>
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
													<div class="modal-header"
														style="padding-bottom: 8px; padding-left: 24px; padding-top: 8px; padding-right: 15px; -webkit-gradient (linear, left top, left bottom, color-stop(0.05, #04abd0), color-stop(1, #0493b3)); background: -moz-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -webkit-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -o-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -ms-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: linear-gradient(to bottom, #04abd0 5%, #0493b3 100%);">
														<h4 class="modal-title">
															<font color="white"> New Module </font>
														</h4>
														<button type="button" class="close" aria-label="Close"
															data-dismiss="modal" style="padding-top: -14px;">
															<span style="text-shadow: 0 0px 0 #fff; color: #fff;">&times;</span>
														</button>
													</div>
												<!-- Modal body -->
												<div class="modal-body">
													<form action="/addModule" method="POST" class="form-group">
														<label for="module_name"></label> <input
															type="text" name="module_name" placeholder="Module Name"
															class="borderlessInput" title="Please enter a module name."  /><br><br> <input type="hidden"
															name="stream_id" value="${c.stream_id }" /> <input
															class="submissionButtons" id="addmodulebtn" type="submit"
															style="margin-top: 10px;" value="submit" /> <input
															class="inactiveButtons" id="addmodulebtn" type="reset"
															style="margin-top: 10px; margin-left:281px;" value="clear" />
													</form>
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
	<script>
		$(".custom-file-input").on("change", function() {
			var fileName = $(this).val().split("\\").pop();
			$(this).siblings(".custom-file-label").html(fileName);
		});
	</script>
	<script>
		function clearfile() {
			var fileName = "Choose file";
			$("#fileName2").html(fileName);
			console.log("ladies and gentlemen, we got him.")
		}
	</script>
</body>
</html>
