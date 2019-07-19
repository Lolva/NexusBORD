<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Class</title>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/nexusbord.css">
    <script type="text/javascript" src="/resources/js/nexusbord.js"></script>
    
    
</head>

<!-- Dynamically create nav bar based on current page and role -->
<body onload="navBar(this, 'classes', 'student')">
  <header>
        <!-- div for nav bar to be created in -->
        <div id="navDiv" class="navigation">
        </div>
    </header>
    <fieldset style="width: 90%; margin:auto; height: 520px; background-color: white;">
   	<a href="Classes.html">Back to Classes</a>
   	<form action="Classes.html">
   		Class ID:<input type="text" id="classid" placeholder="Enter Class ID">
   		<br>
   		Course ID:<input type="text" id="courseid" placeholder="Enter Course ID">
   		<br>
   		Capacity:<input type="text" id="capacity" placeholder="Enter Capacity">
   		<br>
   		<button id="addclassbtn" type="submit" >Submit</button>
   		<button type="reset">Clear Form</button>
   	
	
   	</form>
   	</fieldset>

</body>
</html>