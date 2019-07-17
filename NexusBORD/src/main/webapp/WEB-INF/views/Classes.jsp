<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		<c:forEach items="${classIds}" var="o">
			<button value="button" class="accordion">${o.class_id} </button>
			<div class="panel">
			<c:forEach items="${allStudents}" var="j">
				<c:choose>
		    		<c:when test="${o.class_id==j.class_id}">
		    			<table>
							<tr>
								<td style="color:black;">${j.class_id}</td>
								<td style="color:black;">${j.first_name}</td>
								<td style="color:black;">${j.last_name}</td>
								<td style="color:black;">${j.email}</td>
							</tr>
						</table>
		    		</c:when>    
		    		<c:otherwise>
		        	 
		    		</c:otherwise>
				</c:choose>
			</c:forEach>
			</div>
		</c:forEach>

   	
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
</body>
</html>
