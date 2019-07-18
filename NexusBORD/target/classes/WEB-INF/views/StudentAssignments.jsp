<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<!DOCTYPE html>
<html>
<head>
    <title>Assignments</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/nexusbord.css">
</head>
	<style>
	td,th{
	    border: 1px solid black;
	    text-align: left;
	    padding: 8px;
	    color: black;
		}
	</style>
<body>
	<header>
        <div class="navigation">
            <ul class="topnavbar">
	            <li><a class="logout" onclick="confirm('Logout?'); location.href = '/logout.htm';">Logout</a></li>
                <li><a href="Nexus.html">Home</a></li>
                <li><a href="Modules.html">Modules</a></li>
                <li><a class="active" href="InstructorAssignments.html">Assignments</a></li>
                <li><a href="Grades.html">Grades</a></li>
                <li><a href="Classes.html">Classes</a></li>
                <li><a href="InstructorAssignments.html">Swap View</a></li>
                <li class="left"><a class="nexus"><b>Nexus<font color="#04aad0">BORD</font></b></a></li>
            </ul>
        </div>
    </header>
     <fieldset style="width: 90%; margin:auto; height: 520px; background-color: white;">
     <div style ="background-color:#2E2E7F; padding: 2px;">
       <h2 style="color:white; margin: 10px; margin-top: 1%;"> Trainee Assignments</h2>
     </div>
    <table width="100%" class="assignmentTable" >
        <tr>
            <th>Assignment</th>
            <th>Due Date</th>
            <th>Submission Status</th>
            <!--  <th>File Name</th>-->
            <th>Options</th>
        </tr>
        
        <tr>
            <td id= assignmentName>${assignmentName0}</td>
            <td id= dueDate>${dueDate0}</td>
            <td id="submissionStatus">${submissionStatus0}</td>
            <!-- <td id="fileName">${fileName}</td>-->
            <td><a href="SubmitAssignment.html">Upload</a></td>
        </tr>
    	<tr>
            <td id= assignmentName>${assignmentName1}</td>
            <td id= dueDate>${dueDate1}</td>
            <td id="submissionStatus">${submissionStatus1}</td>
            <!-- <td id="fileName">${fileName}</td>-->
            <td><a href="SubmitAssignment.html">Upload</a></td>
        </tr>
        <tr>
            <td id= assignmentName>${assignmentName2}</td>
            <td id= dueDate>${dueDate2}</td>
            <td id="submissionStatus">${submissionStatus2}</td>
            <!-- <td id="fileName">${fileName}</td>-->
            <td><a href="SubmitAssignment.html">Upload</a></td>
        </tr>
         <tr>
            <td id= assignmentName>${assignmentName3}</td>
            <td id= dueDate>${dueDate3}</td>
            <td id="submissionStatus">${submissionStatus3}</td>
            <!-- <td id="fileName">${fileName}</td>-->
            <td><a href="SubmitAssignment.html">Upload</a></td>
        </tr>
    </table>
    </fieldset>
    <footer>
    </footer>
</body>
</html>