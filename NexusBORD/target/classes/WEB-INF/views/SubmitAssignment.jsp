<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Submit Assignment</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/nexusbord.css">
</head>
<body>
    <header>
        <div class="navigation">
            <ul class="topnavbar">
                <li><a class="logout" onclick="confirm('Logout?');location.href = 'login.html';">Logout</a></li>
                <li><a href="Nexus.html">Home</a></li>
                <li><a href="Modules.html">Modules</a></li>
                <li><a class="active" href="InstructorAssignments.html">Assignments</a></li>
                <li><a href="Grades.html">Grades</a></li>
                <li><a href="Classes.html">Classes</a></li>
                <li class="left"><a class="nexus"><b>Nexus<font color="#04aad0">BORD</font></b></a></li>
            </ul>
        </div>
    </header>
	<fieldset style="width: 90%; margin:auto; height: 500px; background-color: white;">
    	<div style ="background-color:#2E2E7F; padding: 2px;">
        	<h2 style="color:white; margin: 10px; margin-top: 1%;">Upload Assignments</h2>
        </div>
        
	<form style="color: black;" action="InstructorAssignments.html">
	<input type="file" id="uploadFile">
    <button type="submit" id="uploadbtn" onclick="upload">Upload</button>
    <script>
       function upload(uploadFile){
          var x = document.getElementById("uploadFile");
       }
     </script>
     </form>
     </fieldset>
</body>
</html>