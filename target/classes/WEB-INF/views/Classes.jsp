<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<!-- Style for Autocomplete -->
<style>
	* { box-sizing: border-box; }
body {
  font: 16px Arial; 
}
.autocomplete {
  /*the container must be positioned relative:*/
  position: relative;
  display: inline-block;
}
input {
  border: 1px solid transparent;
  background-color: #f1f1f1;
  padding: 10px;
  font-size: 16px;
}
input[type=text] {
  background-color: #f1f1f1;
  width: 100%;
}
input[type=submit] {
  background-color: DodgerBlue;
  color: #fff;
}
.autocomplete-items {
  position: absolute;
  border: 1px solid #d4d4d4;
  border-bottom: none;
  border-top: none;
  z-index: 99;
  /*position the autocomplete items to be the same width as the container:*/
  top: 100%;
  left: 0;
  right: 0;
}
.autocomplete-items div {
  padding: 10px;
  cursor: pointer;
  background-color: #fff; 
  border-bottom: 1px solid #d4d4d4; 
}
.autocomplete-items div:hover {
  /*when hovering an item:*/
  background-color: #e9e9e9; 
}
.autocomplete-active {
  /*when navigating through the items using the arrow keys:*/
  background-color: DodgerBlue !important; 
  color: #ffffff; 
}
.modal-header{
padding-bottom:8px;padding-left:24px;padding-top:8px;padding-right:15px; color:white;
   				 -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #04abd0), color-stop(1, #0493b3)); 
   								   background: -moz-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -webkit-linear-gradient(top, #04abd0 5%, #0493b3 100%);
   								    background: -o-linear-gradient(top, #04abd0 5%, #0493b3 100%); background: -ms-linear-gradient(top, #04abd0 5%, #0493b3 100%); 
   								    background: linear-gradient(to bottom, #04abd0 5%, #0493b3 100%)";
}
</style>
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
    <li class="nav-item"><a class="nav-link" data-toggle="tab" href="#addFile">Add Employee with File</a></li>
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
								<!-- Button trigger modal -->
								<Button type = "button" class= "btn btn-basic btn-xs" data-toggle="modal" data-target="#deleteEmpModal${j.employee_id}">
								<ion-icon name="trash"></ion-icon></Button>
								
 								 <!-- Modal -->
							<div class="modal fade" id="deleteEmpModal${j.employee_id}" tabindex="-1" role="dialog" aria-labelledby="deleteEmpModalLabel" aria-hidden="true">
							  <div class="modal-dialog modal-dialog-centered" role="document">
   								 <div class="modal-content">
   								   <div class="modal-header">
    							    <h5 class="modal-title" id="deleteEmpModalLabel">Delete Employee</h5>
   								     <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		   						     <span style="text-shadow: 0 0px 0 #fff; color: #fff;">&times;</span>
		        					 </button>
      								</div>
     							 <div class="modal-body">
    						    Are you sure you want to delete this employee?
   								   </div>
   							   <div class="modal-footer">
    					    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
   	 				    <a href="/deleteEmployee/${j.class_id }/${j.employee_id }" class="btn btn-primary">Delete</a>
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
							  <div class="modal-dialog modal-dialog-centered" role="document">
   								 <div class="modal-content">
   								   <div class="modal-header">
    							    <h5 class="modal-title" id="deleteEmpModalLabel">Delete Employee</h5>
   								     <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		   						     <span style="text-shadow: 0 0px 0 #fff; color: #fff;">&times;</span>
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
    <input type="hidden" id="xyz" value="${employeeIds}"/>
	<form autocomplete="off"action="/changeClass" style="color: black;" method=POST>
	<br>
		<h4>Add Employee to Class</h4>
		<label for="Employee_Id">Choose Employee ID</label>
		<br>
		<div class="autocomplete">
			<input name="Employee_ID" class="form-control" id="Employee_ID"/>
		</div>
			<br>
			<label for="Class_id">Choose Class ID</label>
			<br>
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
							  <div class="modal-dialog modal-dialog-centered" role="document">
   								 <div class="modal-content">
   								   <div class="modal-header">
    							    <h5 class="modal-title" id="addModalLabel">Add Employee</h5>
   								     <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		   						     <span style="text-shadow: 0 0px 0 #fff; color: #fff;">&times;</span>
		        					 </button>
      								</div>
     							 <div class="modal-body">
    						    Are you sure you want to add this employee?
   								   </div>
   							   <div class="modal-footer">
   	 				    <button type="submit" class="btn btn-primary">Add</button>
    						  </div>
    						  </div>
    						</div>
    						</div>
    						</form>
    						</div>
    	<div id="addFile" class="tab-pane fade">
		<br>
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
   		<div class="custom-file">
   		<label class="custom-file-label" for="file">Select an Excel File (.xlsx)</label>
   		<input type="file" name="file" class="custom-file-input" accept=".xlsx">
   		</div>
   		${error}
   		<br><br>
   		<input type="submit" class="btn btn-primary btn-md" value="Submit">
   	</form>
   	</div>
   	
    <div id="Delete" class="tab-pane fade">

	<br>
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
		 <div class="modal-dialog modal-dialog-centered" role="document">
   			<div class="modal-content">
   		     <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLongTitle">Confirm Delete</h5>
		    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		   						     <span style="text-shadow: 0 0px 0 #fff; color: #fff;">&times;</span>
		        					 </button>
		        					 </div>
		      <div class="modal-body" style="border: none;">
		        Are you sure you want to delete this class?
		      </div>
		      <div class="modal-footer">
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
		   	<label for="stream_id">Enter Stream ID</label>
   	        <select name="stream_Id" class="form-control">
   	            <c:forEach items="${stream}" var="j">
	            	<option value="${j.stream_Id}">${j.stream_Id}</option>
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
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="classModalLabel">Create Class</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
           <span style="text-shadow: 0 0px 0 #fff; color: #fff;">&times;</span>
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
		<div class="modal fade" id="editModal">
  		<div class="modal-dialog modal-dialog-centered">
    	<div class="modal-content">
	   		
	   		<!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Edit Class</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		 <span style="text-shadow: 0 0px 0 #fff; color: #fff;">&times;</span>
       </button>
      </div>
      
      <!-- Modal body -->
      <div class="modal-body">
       Are you sure you want to edit this class?
      </div>
      
      <!-- Modal footer -->
      <div class="modal-footer">
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
	
		<script>
$(".custom-file-input").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});
</script>
	<!-- JavaScript for icons -->
	<script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>

	<!-- Container for logout modal -->	
	<div id="LogoutModalDiv"></div>
	
	<script type="text/javascript">
	function autocomplete(inp, arr) {
		  /*the autocomplete function takes two arguments,
		  the text field element and an array of possible autocompleted values:*/
		  var currentFocus;
		  /*execute a function when someone writes in the text field:*/
		  inp.addEventListener("input", function(e) {
		      var a, b, i, val = this.value;
		      /*close any already open lists of autocompleted values*/
		      closeAllLists();
		      if (!val) { return false;}
		      currentFocus = -1;
		      /*create a DIV element that will contain the items (values):*/
		      a = document.createElement("DIV");
		      a.setAttribute("id", this.id + "autocomplete-list");
		      a.setAttribute("class", "autocomplete-items");
		      /*append the DIV element as a child of the autocomplete container:*/
		      this.parentNode.appendChild(a);
		      /*for each item in the array...*/
		      for (i = 0; i < arr.length; i++) {
		        /*check if the item starts with the same letters as the text field value:*/
		        if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
		          /*create a DIV element for each matching element:*/
		          b = document.createElement("DIV");
		          /*make the matching letters bold:*/
		          b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
		          b.innerHTML += arr[i].substr(val.length);
		          /*insert a input field that will hold the current array item's value:*/
		          b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
		          /*execute a function when someone clicks on the item value (DIV element):*/
		              b.addEventListener("click", function(e) {
		              /*insert the value for the autocomplete text field:*/
		              inp.value = this.getElementsByTagName("input")[0].value;
		              /*close the list of autocompleted values,
		              (or any other open lists of autocompleted values:*/
		              closeAllLists();
		          });
		          a.appendChild(b);
		        }
		      }
		  });
		  /*execute a function presses a key on the keyboard:*/
		  inp.addEventListener("keydown", function(e) {
		      var x = document.getElementById(this.id + "autocomplete-list");
		      if (x) x = x.getElementsByTagName("div");
		      if (e.keyCode == 40) {
		        /*If the arrow DOWN key is pressed,
		        increase the currentFocus variable:*/
		        currentFocus++;
		        /*and and make the current item more visible:*/
		        addActive(x);
		      } else if (e.keyCode == 38) { //up
		        /*If the arrow UP key is pressed,
		        decrease the currentFocus variable:*/
		        currentFocus--;
		        /*and and make the current item more visible:*/
		        addActive(x);
		      } else if (e.keyCode == 13) {
		        /*If the ENTER key is pressed, prevent the form from being submitted,*/
		        e.preventDefault();
		        if (currentFocus > -1) {
		          /*and simulate a click on the "active" item:*/
		          if (x) x[currentFocus].click();
		        }
		      }
		  });
		  function addActive(x) {
		    /*a function to classify an item as "active":*/
		    if (!x) return false;
		    /*start by removing the "active" class on all items:*/
		    removeActive(x);
		    if (currentFocus >= x.length) currentFocus = 0;
		    if (currentFocus < 0) currentFocus = (x.length - 1);
		    /*add class "autocomplete-active":*/
		    x[currentFocus].classList.add("autocomplete-active");
		  }
		  function removeActive(x) {
		    /*a function to remove the "active" class from all autocomplete items:*/
		    for (var i = 0; i < x.length; i++) {
		      x[i].classList.remove("autocomplete-active");
		    }
		  }
		  function closeAllLists(elmnt) {
		    /*close all autocomplete lists in the document,
		    except the one passed as an argument:*/
		    var x = document.getElementsByClassName("autocomplete-items");
		    for (var i = 0; i < x.length; i++) {
		      if (elmnt != x[i] && elmnt != inp) {
		      x[i].parentNode.removeChild(x[i]);
		    }
		  }
		}
		/*execute a function when someone clicks in the document:*/
		document.addEventListener("click", function (e) {
		    closeAllLists(e.target);
		});
		}
	var countries = ["Zambia", "Madagascar", "Albania"];
	//for(int i=0; i<10; i++;) {
	//	document.getElementById("xyz").value = ${allStudents[i].employee_id};
	//}
 	var data = document.getElementById("xyz").value;
 	var lbracket = data.replace(new RegExp('{', 'g'),'');
 	var rbracket = lbracket.replace(new RegExp('}', 'g'),'');
 	var lsb = rbracket.replace('[','');
 	var rsb = lsb.replace(']','');
 	var name = rsb.replace(new RegExp('EMPLOYEE_ID=', 'g'),'');
 	var arr = name.split(', ');
	autocomplete(document.getElementById("Employee_ID"), arr);
	</script>

</body>
</html>
