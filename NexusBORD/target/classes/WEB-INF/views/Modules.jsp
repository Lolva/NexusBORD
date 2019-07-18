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
				<%
					//User is not logged in
					if (session.getAttribute("username") == null) {
				%>
				<script>
					window.location.href = "/login";
				</script>
				<%
					} if ((Boolean) session.getAttribute("instructor")){
				%>
					<li><a class="active" href="Classes.html">Classes</a></li>
				<%
					}
				%>
				<li class="left"><a class="nexus"><b>Nexus<font
							color="#04aad0">BORD</font></b></a></li>
			</ul>
		</div>
	</header>
	<fieldset
		style="width: 90%; margin: auto; height: 660px; background-color: white;">
		<div style="background-color: #2E2E7F; padding: 2px;">
			<h2 style="color: white; margin: 10px; margin-top: 1%;">Modules</h2>
		</div>
		<c:forEach items="${moduleIds}" var="o">
			<button value="button" class="accordion">Module
				${o.module_id}</button>
			<div class="panel">
				<table>
					<tr>
						<th>Assignment Name</th>
						<th>Due Date</th>
						<th>Submission Date</th>
					</tr>

					<c:forEach items="${assignments}" var="j">
						<c:choose>
							<c:when test="${o.module_id==j.module_id}">
								<tr>
									<td></td>
									<td style="color: black;">${j.assignment_name}</td>
									<td style="color: black;">${j.due_date}</td>
									<c:choose>
										<c:when test="${empty j.submission_date}">
											<!-- submission date is null -->
											<td style="color: red;" id="submissionStatus">Not
												Submitted</td>
										</c:when>
										<c:otherwise>
											<td style="color: green;" id="submissionStatus">${j.submission_date }</td>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:when>
						</c:choose>
					</c:forEach>
				</table>
			</div>
		</c:forEach>


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
