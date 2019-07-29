<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/resources/css/nexusbord.css">
    <script type="text/javascript" src="/resources/js/nexusbord.js"></script>
    <!-- Bootstrap Dependencies -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	    crossorigin="anonymous"></script>
	<script
	    src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	    crossorigin="anonymous"></script>
</head>


<!-- Dynamically create nav bar based on current page and role -->
<body onload="navBar(this, 'classes', 'instructor')">
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
    
     <div class="container" style = "color:black;background:white;margin-top:40px;'width:100%;padding-bottom:20px;height:100% ">
  	<fieldset style="background:white;height:100%;margin-top:40px; padding-bottom:30%;">
  	<br>
<div class="tabbable boxed parentTabs ">
 <ul class="nav nav-tabs">
    <li class="nav-item"><a class="nav-link active" data-toggle="tab" href="#viewclass">Home</a></li>
    <li class="nav-item" ><a class="nav-link" data-toggle="tab" href="#AddEmployee">Add Employee</a></li>
    <li class="nav-item"><a class="nav-link" data-toggle="tab" href="#Delete">Delete Class</a></li>
    <li class="nav-item"><a class="nav-link" data-toggle="tab" href="#createclass">Create A Class</a></li>
    <li class="nav-item"><a class="nav-link" data-toggle="tab" href="#editclass">Edit Class</a></li>
  </ul>

  <div class="tab-content">
    <div id="viewclass" class="tab-pane fade show active">
    <br>
    <ul class="nav nav-tabs">
    <li class="nav-item"><a class="nav-link active" data-toggle="tab" href="#activeClass">Active Classes <span class="badge badge-info">${fn:length(activeInstructorClasses)}</span></a></li>
    <li class="nav-item"><a class="nav-link" data-toggle="tab" href="#inactiveClass">Inactive Classes <span class="badge badge-info">${fn:length(inactiveInstructorClasses)}</span></a></li> 
    </ul>
    <div class="tab-content">
    <div class="tab-pane fade show active" id="activeClass">
    <br>

    <!-- ${activeClassIds} -->
     <c:forEach items="${activeInstructorClasses}" var="o">
			<button value="button" class="accordion"> Class ${o.class_id}: ${o.start_date} - ${o.end_date} </button>
			<div class="panel">
		<table style ="border-collapse:collaspe; padding:5px;width:100%;padding-bottom:10px;padding-top:10px">
				<tr>
				    <th> Employee ID </th>				    
				    <th> First Name </th>
				    <th> Last Name </th>
				    <th> Email </th>
				    <th> Delete </th>
			   	</tr>
			<c:forEach items="${activeStudents}" var="j">
				<c:choose>
		    		<c:when test="${o.class_id==j.class_id}">
							<tr >
								<td style="color:black;padding:5px">${j.employee_id} </td>
								<td style="color:black;padding:5px">${j.first_name} </td>
								<td style="color:black;padding:5px">${j.last_name}  </td>
								<td style="color:black;padding:5px"> ${j.email}   </td>
								<td>
								<form name="deleteform" action="/deleteEmployee" method="POST">
								<input type ="hidden" name="Class_ID" value="${j.class_id }">
								<input type ="hidden" name="Employee_ID" value="${j.employee_id}">
								<!-- Button trigger modal -->
								<Button type = "button" class= "btn btn-basic btn-xs" data-toggle="modal" data-target="#deleteEmpModal">
								<ion-icon name="trash"></ion-icon></Button>
								
 								 <!-- Modal -->
							<div class="modal fade" id="deleteEmpModal" tabindex="-1" role="dialog" aria-labelledby="deleteEmpModalLabel" aria-hidden="true">
							  <div class="modal-dialog" role="document">
   								 <div class="modal-content">
   								   <div class="modal-header">
    							    <h5 class="modal-title" id="deleteEmpModalLabel">Delete Employee</h5>
   								     <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		   						     <span aria-hidden="true">&times;</span>
		        					 </button>
      								</div>
     							 <div class="modal-body">
    						    Are you sure you want to delete this employee?
   								   </div>
   							   <div class="modal-footer">
    					    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
   	 				    <button type="submit" class="btn btn-primary">Delete</button>
    				  </div>
   					</div>
 				</div>
				</div>			
							

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
		<div class="tab-pane fade" id="inactiveClass">
		<br>
		<c:forEach items="${inactiveInstructorClasses}" var="o">
			<button value="button" class="accordion"> Class ${o.class_id}: ${o.start_date} - ${o.end_date} </button>
			<div class="panel">
		<table style ="border-collapse:collaspe; padding:5px;width:100%;padding-bottom:10px;padding-top:10px">
				<tr>
				    <th> Employee ID </th>				    
				    <th> First Name </th>
				    <th> Last Name </th>
				    <th> Email </th>
				    <th> Delete </th>
			   	</tr>
			<c:forEach items="${activeStudents}" var="j">
				<c:choose>
		    		<c:when test="${o.class_id==j.class_id}">
							<tr >
								<td style="color:black;padding:5px">${j.employee_id} </td>
								<td style="color:black;padding:5px">${j.first_name} </td>
								<td style="color:black;padding:5px">${j.last_name}  </td>
								<td style="color:black;padding:5px"> ${j.email}   </td>
								<td>
								<form name="deleteform" action="/deleteEmployee" method="POST">
								<input type ="hidden" name="Class_ID" value="${j.class_id }">
								<input type ="hidden" name="Employee_ID" value="${j.employee_id}">
								
								<!-- Button trigger modal -->
								<Button type = "button" class= "btn btn-basic btn-xs" data-toggle="modal" data-target="#deleteEmpModal">
								<ion-icon name="trash"></ion-icon></Button>
								
 								 <!-- Modal -->
							<div class="modal fade" id="deleteEmpModal" tabindex="-1" role="dialog" aria-labelledby="deleteEmpModalLabel" aria-hidden="true">
							  <div class="modal-dialog" role="document">
   								 <div class="modal-content">
   								   <div class="modal-header">
    							    <h5 class="modal-title" id="deleteEmpModalLabel">Delete Employee</h5>
   								     <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		   						     <span aria-hidden="true">&times;</span>
		        					 </button>
      								</div>
     							 <div class="modal-body">
    						    Are you sure you want to delete this employee?
   								   </div>
   							   <div class="modal-footer">
    					    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
   	 				    <button type="submit" class="btn btn-primary">Delete</button>
    				  </div>
   					</div>
 				</div>
				</div>			
							

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
    </div>
    </div>
    
    <div id="AddEmployee" class="tab-pane fade"class="row">
	<form action="/changeClass" style="color: black;" method=POST>
	<br>
		<h4>Add Employee to Class</h4>
		<label for="Employee_Id">Choose Employee ID</label>
		<div class="dropdown">
			<select name="Employee_ID" class="form-control">
				<c:forEach items="${allStudents}" var="e">
					<option class="dropdown-item" id="Employee_ID" value="${e.employee_id}">${e.employee_id}</option>
				</c:forEach>
			 </select>
		</div>
			<br>
			<label for="Class_id">Choose Class ID</label>
		   	<div class="dropdown">
			  <select name="Class_ID" class="form-control">
				  <c:forEach items="${allClassIds}" var="j">
				  	 <option class="dropdown-item" id="Class_id" value="${j.class_id}">${j.class_id}</option>
				  </c:forEach>
			  </select>
			</div>
			<br>
			<h5> If the employee is already in a class:</h5>
			<label for="Class_id">Choose Old Class ID</label>
		   	<div class="dropdown">
			  <select name="old_Class_ID" class="form-control">
			  		 <option value="null"> None</option>
				  <c:forEach items="${allClassIds}" var="j">
				  	 <option class="dropdown-item" value="${j.class_id}">${j.class_id}</option>
				  </c:forEach>
			  </select>
			</div>
			<br>
			<input type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#addModal" value="Add Employee"/>
		 <!-- add employee Modal -->
							<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
							  <div class="modal-dialog" role="document">
   								 <div class="modal-content">
   								   <div class="modal-header">
    							    <h5 class="modal-title" id="addModalLabel">Add Employee</h5>
   								     <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		   						     <span aria-hidden="true">&times;</span>
		        					 </button>
      								</div>
     							 <div class="modal-body">
    						    Are you sure you want to add this employee?
   								   </div>
   							   <div class="modal-footer">
    					    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
   	 				    <button type="submit" class="btn btn-primary">Add</button>
    						  </div>
    						  </div>
    						</div>
    		</div>
		</form>
		<hr>
		<h4>Add Employees with a File</h4>
		<br><br>
   		<form action="/giveFile" method="GET">
   			Example Excel File: <button class="btn btn-secondary btn-sm" type="submit">Download</button>
   		</form>
		<form action="/upload" method = POST enctype="multipart/form-data">
   		<br>
   		<label for="class_id">Choose Class ID</label>
   		<div class="dropdown">
			  <select name="class_id" class="form-control">
				  <c:forEach items="${allClassIds}" var="j">
				  	 <option class="dropdown-item" id="class_id" value="${j.class_id}">${j.class_id}</option>
				  </c:forEach>
			  </select>
		</div>
   		<br><br>
   		<label for="file">Select an Excel File</label>
   		<input type="file" name="file" class="btn btn-default btn-md">
   		<br><br>
   		<input type="submit" class="btn btn-primary btn-md" value="Submit">
   	</form>
   	</div>
   	
    <div id="Delete" class="tab-pane fade">

      <h3>Delete Class</h3>
      <br>
 		<form action="/deleteClass" method="POST">
 		<label for="class_id">Choose Class ID</label>
 				   	<div class="dropdown">
			  <select name="class_id" class="form-control">
				  <c:forEach items="${allClassIds}" var="j">
				  	 <option class="dropdown-item" id="Class_id" value="${j.class_id}">${j.class_id}</option>
				  </c:forEach>
			  </select>
			</div>
   		<br>
   		<button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#exampleModalCenter" >
   			Delete Class
   		</button>
   		<input class="btn btn-primary btn-md" type="reset">
   		<!-- Button trigger modal -->
		
		<!-- Delete Modal -->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		 <div class="modal-dialog" role="document">
   			<div class="modal-content">
   		     <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLongTitle">Confirm Delete</h5>
		    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		   						     <span aria-hidden="true">&times;</span>
		        					 </button>
		        					 </div>
		      <div class="modal-body" style="border: none;">
		        Are you sure you want to delete this class?
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
		        <button type="submit" class="btn btn-primary" >Delete</button>
		      </div>
		    </div>
		  </div>
		</div>
   		${error}
   	</form>
    </div>
    <div id="createclass" class="tab-pane fade">
<br>
	    <h3>Create New Class</h3>
	    <form action="/addClass" method="POST"  >
		   	<label for="stream_id">Choose Stream</label>
   	        <select name="stream_Id" class="form-control">
   	            <c:forEach items="${stream}" var="j">
	            	<option value="${j.stream_id}" title="${stream_name}">${j.stream_name} ( Modules Included:
					<c:forEach items="${allModules}" var="i">
						<c:choose>
		    				<c:when test="${j.stream_id==i.stream_id}">
								 - ${i.module_name} 
							</c:when>
						</c:choose>
					</c:forEach>
					)</option>
	            </c:forEach>
            </select>
            <br>
		   	
		   	<label for="start_date" >Enter Start Date</label>
		   	<input type="date" name="start_date" placeholder="Start Date" class="form-control">
		   	
		   	<label for="end_date">Enter End Date</label>
		   	<input type="date" name="end_date" placeholder="End Date" class="form-control">
		   	
	   		<br>
	   		
	   		<!-- Button trigger modal -->
	   		<button type = "button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#classModal">Create Class</button>
	   		
	   		<!-- Modal -->
<div class="modal fade" id="classModal" tabindex="-1" role="dialog" aria-labelledby="classModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="classModalLabel">Create Class</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Are you sure you want to create a new class?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Create Class</button>
      </div>
    </div>
  </div>
</div>
	   		
	   	</form>
    </div>
    <div id="editclass" class="tab-pane fade">
    	<h4> Edit Classes</h4>
	    <form action="/editClass" method="POST">
	    <label for="class_id" >Choose Class ID</label>
	   	<div class="dropdown">
		  <select name="class_Id" class="form-control">
			  <c:forEach items="${allClassIds}" var="j">
			  	 <option class="dropdown-item" id="class_Id" value="${j.class_id}">${j.class_id}</option>
			  </c:forEach>
		  </select>
		</div>
	    <label for="start_date" >Change Start Date</label>
	   	<input type="date" name="start_date" placeholder="Start Date" class="form-control">
	   	
	   	<label for="end_date">Change End Date</label>
	   	<input type="date" name="end_date" placeholder="End Date" class="form-control">
	   	
	   		<br>
	   		<!-- Button to Open the Modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editModal">
		  Edit Class
		</button>
	   		
	   		<!-- The Modal -->
		<div class="modal" id="editModal">
  		<div class="modal-dialog">
    	<div class="modal-content">
	   		
	   		<!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Edit Class</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      
      <!-- Modal body -->
      <div class="modal-body">
       Are you sure you want to edit this class?
      </div>
      
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Edit</button>
      </div>

    </div>
  </div>
</div>
      
      
	   		
	   	</form>
    </div>
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
	<!-- JavaScript for icons -->
	<script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>

	<!-- Container for logout modal -->	
	<div id="LogoutModalDiv"></div>

</body>
</html>
