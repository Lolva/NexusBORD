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
<script type="text/javascript" src="/resources/js/nexusbord.js"></script>
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
	<fieldset class="container"
		style="width: 90%; margin: auto; background-color: white;">
		<div class="tabbable boxed parentTabs p-4">
			<ul class="nav nav-tabs">
				<!--  change #instructor to #classID, update JS classID, inject className  -->
				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${classes}" var="cl">
					<li class="active"><a href="#d${cl.CLASS_ID}"
						id="${cl.role_id}" class="nav-link">${cl.stream_name}
							${cl.role_id}</a></li>
					<!--  change href to #classID, inject className. update classID in JS  -->
					<c:set var="count" value="${count + 1}" scope="page" />
				</c:forEach>
			</ul>
			<div class="tab-content">
				<c:set var="county" value="0" scope="page" />
				<c:forEach items="${modules}" var="md">
					<div class="tab-pane fade" id="d${md.key}">
						<c:forEach items="${md.value}" var="poo">
							<h4 class="mt-2">${poo.module_name }</h4>
							<p>Aliquip placeat salvia cillum iphone. Seitan aliquip quis
								cardigan american apparel, butcher voluptate nisi qui. Raw denim
								you probably haven't heard of them jean shorts Austin. Nesciunt
								tofu stumptown aliqua, retro synth master cleanse. Mustache
								cliche tempor, williamsburg carles vegan helvetica.
								Reprehenderit butcher retro keffiyeh dreamcatcher synth.</p>
						</c:forEach>
					</div>
				</c:forEach>
				<c:set var="county" value="${county + 1}" scope="page" />
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
</body>
</html>
