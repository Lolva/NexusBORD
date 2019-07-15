<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Assignments</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/nexusbord.css">
    <script src="/resources/js/app.js"></script>
    <script>
        function swap() {
            var teacher = document.getElementById("teacher");
            var student = document.getElementById("student");
            if (teacher.style.visibility == "hidden") {
                student.style.visibility = "hidden";
                teacher.style.visibility = "visible";
            }
            else {
                student.style.visibility = "visible";
                teacher.style.visibility = "hidden";
            }
        }
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
                <li><a href="Grades.html">Grades</a></li>
                <li><a href="Classes.html">Classes</a></li>
                <li class="left" onClick="returnToMain()"><a class="nexus"><b>Nexus<font color="#04aad0">BORD</font></b></a></li>
                <li class="left"><a onclick="return swap()">Swap View</a></li>
            </ul>
        </div>
    </header>
    <div id="teacher" style="visibility: hidden;">
        <table noborder="true">
            <tr>
                <td>Assignment Name</td>
                <td>Status</td>
                <td>Due Date</td>
                <td style="padding: 40px;"><input type="button" value="Grade"></td>
            </tr>
        </table>
    </div>
    <div id="student">
        <h2>Assignments Turn in</h2>
        <table noborder="true">
            <tr>
                <td>Assignment Name</td>
                <td>Status</td>
                <td>Due Date</td>
                <td><input id="submit" type="submit" value="Submit"></td>
            </tr>
        </table><br>
        <br>
    </div>

    <footer>
        <p>Footer</p>
    </footer>
</body>
</html>
