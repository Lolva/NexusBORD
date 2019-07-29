<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Oops</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="/resources/css/nexusbord.css">
<script type="text/javascript" src="/resources/js/nexusbord.js"></script>

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

<body onload="navBar(this, '', 'student')">
	<header><div id="navDiv" class="navigation"></div></header>
	<div class="d-flex justify-content-center">
		<div class="w-50">
			<div class="jumbotron text-white" style="margin-top: 10%; background-color: #323639; opacity: 0.85;">
				<h1 class="display-4">Oops! An error occurred</h1>
				<p class="lead">
					You can use the navigation bar above or select one of the buttons below, 
					or just wait for a few seconds and we'll take you back...
				</p>
				<div class="d-flex justify-content-center">
					<div class="spinner-grow" role="status" style="color: white">
				  		<span class="sr-only">Loading...</span> 	
					</div>
				</div>
				
				<hr class="my-4" style="border-color: #4b5157;">
				
				<div class="row justify-content-center">
					<div class="col">
						<div class="d-flex justify-content-end">
							<a class="inactiveButtons" style="box-shadow: 0px 0px 0px 0px #3f4447;" onclick="window.history.back()" role="button">Go back</a>
						</div>
					</div>
					<div class="col">
						<div class="d-flex justify-content-left">
							<a class="submissionButtons" style="box-shadow: 0px 0px 0px 0px #3f4447;" onclick="window.location.href='/Nexus'" role="button">Home</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		setTimeout(function () {   // using setTimeout to execute a function after 5 seconds,
	   		window.history.back(); //   return to previous page
		}, 10000);
	</script>
</body>
</html>