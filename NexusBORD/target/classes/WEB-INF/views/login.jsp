<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	    <title>Login</title>
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
	    if(request.getAttribute("user") != null && request.getAttribute("user") != ""){ // if user cookie is unassigned, send to login page
	    %>
	    <script>
			window.location.href="/";
	    </script>
	    <% 
	    }
	    %>
	    <form style="text-align: center;" class="box" method=POST>
	        <h1>Nexus<font color="#04aad0">BORD</font></h1>
	        Username <input type="text" id="username" name="username"/>
	        <br>
	        Password <input type="password" id="password" name="password"/>
	        <br>
	        <input type="submit" value="Login" />
	        <div style="color: red">
	        	${error}
	        </div>
	        <!--style="margin-bottom: 10px;"-->
	    </form>
	</body>
</html>