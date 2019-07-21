<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Classes</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/nexusbord.css">
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
</head>

<body>
	<header>
		<div class="navigation">
			<ul class="topnavbar">
				<li><a class="logout"
					onclick="confirm('Logout?'); location.href = '/logout.htm';">Logout</a></li>
				<li><a href="Nexus.html">Home</a></li>
				<li><a href="Modules.html">Modules</a></li>
				<li><a href="InstructorAssignments.html">Assignments</a></li>
				<li><a href="Grades.html">Grades</a></li>
				<li><a class="active" href="Classes.html">Classes</a></li>
				<li class="left"><a class="nexus"><b>Nexus<font
							color="#04aad0">BORD</font></b></a></li>
			</ul>
		</div>
	</header>
	<fieldset class="container"
		style="width: 90%; margin: auto; background-color: white;">
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
				<c:forEach items="${classes}" var="o">
					<button value="button" class="accordion">Module
						${o.module_id}</button>
					<div class="panel">
						<table>
							<c:forEach items="${assignments}" var="j">
								<c:choose>
									<c:when test="${o.assignment_id==j.assignment_id}">
										<tr>
											<td></td>
											<td style="color: black;">${j.assignment_name}</td>
											<td style="color: black;">${j.due_date}</td>
											<td style="color: black;">${j.submission_date}</td>
										</tr>
									</c:when>
								</c:choose>
							</c:forEach>
						</table>
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
</body>
</html>
