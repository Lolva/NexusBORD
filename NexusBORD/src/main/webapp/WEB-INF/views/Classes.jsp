<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<<<<<<< HEAD
<title>Classes</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/nexusbord.css">
<script type="text/javascript">
	function ex() {
		var vals = document.getElementById("val");
		var win = window.open('', 'window',
				'resizable=yes,scrollbars=no,status=yes');
		win.document.write()
		win.document
				.write("<table id='vals'><tr>Student 1<br></tr><tr>Student 2<br></tr>\n\
                       <tr>Student 3<br></tr></table>");
		win.document.write("<br><br><input type='button' value='Add More'>");
	}
</script>
</head>

<body>
	<%
		if (session.getAttribute("username") == null) {
	%>
	<script>
		window.location.href = "/login";
	</script>
	<%
		}
	%>
	<header>
		<div class="navigation">
			<ul class="topnavbar">
				<li><a href="logout" onclick="return confirm('Logout?');">Logout</a></li>
				<li><a href="Nexus.html">Home</a></li>
				<li><a href="Modules.html">Modules</a></li>
				<li><a href="assignments">Assignments</a></li>
				<li><a href="Grades.html">Grades</a></li>
				<li><a class="active" href="Classes.html">Classes</a></li>
				<li class="left"><a class="nexus"><b>Nexus<font
							color="#04aad0">BORD</font></b></a></li>
			</ul>
		</div>
	</header>
	<fieldset
		style="width: 90%; margin: auto; height: 520px; background-color: white;">
		<div style="background-color: #2E2E7F; padding: 2px;">
			<h2 style="color: white; margin: 10px; margin-top: 1%;">Classes</h2>
		</div>
		<table>
			<tr>
				<input type="button" id="course1" value="Course 1/Name"
					onclick="ex()">
				<br>
				<br>
			</tr>
			<tr>
				<input type="button" id="course2" value="Course 2/Name"
					onclick="ex()">
				<br>
				<br>
			</tr>
			<tr>
				<input type="button" id="course3" value="Course 3/Name"
					onclick="ex()">
				<br>
				<br>
			</tr>
			<tr>
				<input type="button" id="course4" value="Course 4/Name"
					onclick="ex()">
				<br>
				<br>
			</tr>
		</table>
	</fieldset>
=======
    <title>Classes</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/nexusbord.css">

   	</script>
</head>

<body>
    <header>
        <div class="navigation">
            <ul class="topnavbar">
	            <li><a class="logout" onclick="confirm('Logout?'); location.href = '/logout.htm';">Logout</a></li>
                <li><a href="Nexus.html">Home</a></li>
                <li><a href="Modules.html">Modules</a></li>
                <li><a href="InstructorAssignments.html">Assignments</a></li>
                <li><a href="Grades.html">Grades</a></li>
                <li><a class="active" href="Classes.html">Classes</a></li>
                <li class="left"><a class="nexus"><b>Nexus<font color="#04aad0">BORD</font></b></a></li>
            </ul>
        </div>
    </header>
    <fieldset style="width: 90%; margin:auto; height: 520px; background-color: white;">
    	<div style ="background-color:#2E2E7F; padding: 2px;">
     		<h2 style="color:white; margin: 10px; margin-top: 1%;"> Classes</h2>
        </div>
        <button value="button" class="accordion">Section 1: ${classId0}</button>
			<div class="panel">
 			 <p>First Name: ${first_name0}</p>
			</div>

		<button class="accordion">Section 2: ${classId1}</button>
			<div class="panel">
 			 <p>Name 2</p>
			</div>

		<button class="accordion">Section 3</button>
			<div class="panel">
 			 <p>Name 3</p>
			</div>
			
			

   
		<p id="createClassLink"><a href="CreateClass.html">Create New Class</a></p>
   		
    </fieldset>
   <script type ="text/javascript">
	var acc = document.getElementsByClassName("accordion");
	var i;

	for (i = 0; i < acc.length; i++) {
 		 acc[i].addEventListener("click", function() {
   	 this.classList.toggle("active");
   	 var panel = this.nextElementSibling;
   	 	if (panel.style.maxHeight){
   	 	  panel.style.maxHeight = null;
   	 } else {
   		   panel.style.maxHeight = panel.scrollHeight + "px";
   			 } 
 		 });
	}
</script>
>>>>>>> 37884c1abd6c5c298b2c3fe2e8cf4ea03e2d7403
</body>
</html>
