<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
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
   	<a href="Classes.html">Back to Classes</a>

<form:form modelAttribute="ClassBean" action="ConfirmClass.html" method="post">
        <h2>Class To Be Added</h2>
        
        <table border="1">
               <tr>
                <th>CLASS ID</th>
                <th>STREAM ID</th>
                <th>START DATE</th>
                  <th>END DATE</th>
                  <th>ACTION</th>
               </tr>
             <tr>
              <td>${ClassBean.class_Id}</td>
              <td>${ClassBean.stream_Id}</td>
              <td>${ClassBean.start_date }</td>
              <td>${ClassBean.end_date }</td>
        
              <th><a href="CreateClass.htm"><button id="submitclassbtn" path="submit" type="submit" value="Submit" >Edit</a></button>
                 <a href="CreateClass.htm"> <button id="deleteclassbtn" path="delete" type="delete" value="Delete" >Delete</a></button></th>
              
             </tr>
        </table>
  
 
 
</form:form>
</fieldset>
</body>
</html>
