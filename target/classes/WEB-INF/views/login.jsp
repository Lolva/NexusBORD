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
	//User is already logged in
	if(session.getAttribute("username") != null){
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
	    </form>
	</body>
</html>