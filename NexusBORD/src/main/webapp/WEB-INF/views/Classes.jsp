<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Classes</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/nexusbord.css">
    <script src="/resources/js/app.js"></script>
    <script type="text/javascript">
        function ex() {
            var vals = document.getElementById("val");
            var win = window.open('', 'window', 'resizable=yes,scrollbars=no,status=yes');
            win.document.write()
            win.document.write("<table id='vals'><tr>Student 1<br></tr><tr>Student 2<br></tr>\n\
                       <tr>Student 3<br></tr></table>");
            win.document.write("<br><br><input type='button' value='Add More'>");
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
                <li><a href="Assignments.html">Assignments</a></li>
                <li><a href="Grades.html">Grades</a></li>
                <li><a class="active" href="Classes.html">Classes</a></li>
                <li class="left" onClick="returnToMain()"><a class="nexus"><b>Nexus<font color="#04aad0">BORD</font></b></a></li>
            </ul>
        </div>
    </header>
    <table>
        <tr><input type="button" id="course1" value="Course 1/Name" onclick="ex()"><br><br></tr>
        <tr><input type="button" id="course2" value="Course 2/Name" onclick="ex()"><br><br></tr>
        <tr><input type="button" id="course3" value="Course 3/Name" onclick="ex()"><br><br></tr>
        <tr><input type="button" id="course4" value="Course 4/Name" onclick="ex()"><br><br></tr>
    </table>
    <footer>
        <p>Footer</p>
    </footer>
</body>
</html>
