<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/nexusbord.css">
</head>
	<body>
		<%
	    Cookie cookie = null;
	    Cookie[] cookies = null;
	    cookies = request.getCookies();
	    if(cookies != null) { // check to make sure the user has cookies
	        for (int i = 0; i < cookies.length; i++){ // if so, iterate through until you get username
	            if(cookies[i].getName().equals("username"))
	                request.setAttribute("user", cookies[i].getValue()); // you can access this attribute with ${user}
	        }
	   	}
	    if(request.getAttribute("user") == null || request.getAttribute("user") == ""){ // if user cookie is unassigned, send to login page
	    %>
	    <script>
			window.location.href="/login";
	    </script>
	    <% 
	    } else { // otherwise, display the page normally, here will be the normal body of the page:
	   	%>
	   	<header>
	        <div class="navigation">
	            <ul class="topnavbar">
	                <li><a class="logout" onclick="confirm('Logout?'); location.href = '/logout.htm';">Logout</a></li>
	                <li><a class="active" href="Nexus.htm">Home</a></li>
	                <li><a href="Modules.htm">Modules</a></li>
	                <li><a href="Assignments.htm">Assignments</a></li>
	                <li><a href="Grades.htm">Grades</a></li>
	                <li><a href="Classes.htm">Classes</a></li>
	                <li class="left"><a class="nexus"><b>Nexus<font color="#04aad0">BORD</font></b></a></li>
	            </ul>
	        </div>
	    </header>
	
	    <footer>
	        <p>footer</p>
	        <p>${user}</p>
	    </footer>
	   	<%
	    } // don't forget to close the if-else statement
	    %>
	</body>
</html>