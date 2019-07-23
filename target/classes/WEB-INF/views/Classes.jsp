<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Classes</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/nexusbord.css">
    <script type="text/javascript" src="/resources/js/nexusbord.js"></script>
    
</head>


<!-- Dynamically create nav bar based on current page and role -->
<body onload="navBar(this, 'classes', 'student')">
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
        <div class="navigation">
            <ul class="topnavbar">
				<li><a href="logout" onclick="return confirm('Logout?');">Logout</a></li>
                <li><a href="Nexus.html">Home</a></li>
                <li><a href="Modules.html">Modules</a></li>
                <li><a href="assignments">Assignments</a></li>
                <li><a href="Grades.html">Grades</a></li>
                <li><a class="active" href="Classes.html">Classes</a></li>
                <li class="left"><a class="nexus"><b>Nexus<font color="#04aad0">BORD</font></b></a></li>
            </ul>
        </div>
    </header>
    
     <div class="container" style = "color:black;background:white;margin-top:40px;'width:100%;padding-bottom:20px;height:100% ">
  	<fieldset style="background:white;height:100%;margin-top:40px; padding-bottom:30%;">
 <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#viewclass">Home</a></li>
    <li><a data-toggle="tab" href="#AddEmployee">Add Employee</a></li>
    <li><a data-toggle="tab" href="#Delete">Delete Class</a></li>
    <li><a data-toggle="tab" href="#createclass">Create A Class</a></li>
  </ul>

  <div class="tab-content">
    <div id="viewclass" class="tab-pane fade in active">
    
     <c:forEach items="${classIds}" var="o">
			<button value="button" class="accordion"> Class ${o.class_id} </button>
			<div class="panel">
			<table style ="border-spacing:10px; padding:5px;width:100%">
				<tr>
				    <th> Class Id </th>				    
				    <th> First Name </th>
				    <th> Last Name </th>
				    <th> Email </th>
			   	</tr>
			<c:forEach items="${allStudents}" var="j">
				<c:choose>
		    		<c:when test="${o.class_id==j.class_id}">
							<tr >
								<td style="color:black;">${j.class_id} </td>
								<td style="color:black;">${j.first_name} </td>
								<td style="color:black;">${j.last_name}  </td>
								<td style="color:black;"> ${j.email}   </td>
								<td>
								<form name="deleteform" action="/deleteEmployee" method="POST" onsubmit="return confirm('Do you really want to delete the employee?')">
								<input type ="hidden" name="Class_ID" value="${j.class_id }">
								<input type ="hidden" name="Employee_ID" value="${j.employee_id}">
								<input type = "submit" value="Delete Employee" class = "btn btn-primary btn-sm">
								${error}
								</form>
								</td>
							</tr>
		    		</c:when>    
				</c:choose>
			</c:forEach>
			</table>
			</div>
		</c:forEach>
    </div>
    <div id="AddEmployee" class="tab-pane fade"class="row">
	<form action="/changeClass" style="color: black;" method=POST>
		<h4>Add Employee to Class:</h4>
			<label for="Employee_Id">Enter Employee ID</label> 
			<input type="text" name="Employee_ID" placeholder="Employee ID"/>
			<label for="Class_id">Enter Class ID</label>
			<input type="text" name="Class_ID" placeholder="Enter Class ID"/>
			<br><br>
			<input type="submit" class="btn btn-primary btn-md" value="Add Employee"/>
		</form>
	<br><br>
		<h4>Add Employee with File</h4>
		<form action="/upload" method = POST enctype="multipart/form-data">
   		<br>
   		<label for="class_id">Enter Class ID</label>
   		<input type="text" name="class_id" placeholder="Class ID" class="form-control">
   		<br>
   		<label for="file">Select an Excel File</label>
   		<input type="file" name="file" class="btn btn-default btn-md">
   		<br><br>
   		<input type="submit" class="btn btn-primary btn-md" value="Submit">
  
   	</form>
   	</div>
   	
    <div id="Delete" class="tab-pane fade">

      <h3>Delete Class</h3>
      <br>
 		<form action="/deleteClass" method="POST" onsubmit="return confirm('Do you really want to delete the class?')">
 		<label for="class_id">Enter Class ID</label>
 		<input type="text" name="class_id" placeholder="Class ID" class="form-control">
   		<br>
   		<input class="btn btn-primary btn-md" type="submit" id="addclassbtn" >
   		<input class="btn btn-primary btn-md" type="reset">
   		${error}
   	</form>
    </div>
    <div id="createclass" class="tab-pane fade">

      <h3>Create New Class</h3>
      <form action="/addClass" method="POST" class="form-group">
    <label for="class_id" >Enter Class ID</label>
   	<input type="text" name="class_Id" placeholder="Class ID" class="form-control">
   	
   	<label for="stream_id">Enter Stream ID</label>
   	<input type="text" name="stream_Id" placeholder="Stream ID" class="form-control">
   	
   	 <label for="start_date" >Enter Start Date</label>
   	<input type="date" name="start_date" placeholder="Start Date" class="form-control">
   	
   	<label for="end_date">Enter End Date</label>
   	<input type="date" name="end_date" placeholder="End Date" class="form-control">
   	
   		<br>
   		<input class="btn btn-primary btn-md" id="addclassbtn" type="submit" >
   		<input class="btn btn-primary btn-md" type="reset">
   	
	
   	</form>
    </div>
  </div>
  </fieldset>
</div>
<script>
	$(document).ready(function(){
		  $(".nav-tabs a").click(function(){
		    $(this).tab('show');
		  });
		});
</script>
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
	
    
 
	
</body>
</html>