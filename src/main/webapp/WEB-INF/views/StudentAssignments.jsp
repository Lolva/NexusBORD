<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Assignments</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="/resources/css/nexusbord.css">
    <script>
        // This is for the table data
    </script>
</head>
<body>
    <header>
        <div class="navigation">
            <ul class="topnavbar">
                <li><a class="logout" onclick="confirm('Logout?');location.href = 'login.html';">Logout</a></li>
                <li><a href="Nexus.html">Home</a></li>
                <li><a href="Modules.html">Modules</a></li>
                <li><a class="active" href="Assignments.html">Assignments</a></li>
                <li><a  href="Grades.html">Grades</a></li>
                <li><a href="Classes.html">Classes</a></li>
                <li><a href="Assignments.html">Swap View</a></li>
                <li class="left"><a class="nexus"><b>Nexus<font color="#04aad0">BORD</font></b></a></li>
            </ul>
        </div>
        
    </header>
        <div id="student">
                <fieldset style="width: 90%; margin:auto; height: 500px; background-color: white;">
                        <div style ="background-color:#2E2E7F; padding: 2px;">
                            <h2 style="color:white; margin: 10px; margin-top: 1%;">Trainee Assignments</h2>
                        </div>
                        <table border="1" style="column-count: 3; column-fill: auto; border-collapse: collapse; color:black; margin-left: 5%; width: 50%; margin: 10px;" >
                            <thead style="border-bottom: black;">
                                <th>Assignment Name</th>
                                <th>Status</th>
                                <th>Due Date</th>                        
                            </thead>
                            <tbody>
                                <tr >
                                    <td id = title> </td>
                                    <td id= status> </td> 
                                    <td id= due_date> </td> 
                                 </tr>
                            </tbody>
                        </table>
                        <a style="text-decoration: none; margin-left: 10px;" href = "Upload.html">Upload New Assignment</a>
                    </fieldset>
        </div>

</body>
</html>


