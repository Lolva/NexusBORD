<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Instructor Assignments</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/resources/css/nexusbord.css">

<script type="text/javascript" src="/resources/js/nexusbord.js"></script>
<style>
td, th {
	border: 1px solid black;
	text-align: left;
	padding: 8px;
	color: black;
}
</style>
<script js>$("ul.nav-tabs a").click(function (e) {
	  e.preventDefault();  
	    $(this).tab('show');
	});
</script>
</head>

<!-- Dynamically create nav bar based on current page and role -->
<body onload="navBar(this, 'assignments', 'student')">
	<%
	//User is not logged in
		if (session.getAttribute("username") == null) {
	%>
	<script>
		window.location.href = "/login";
	</script>
	<%
		}
	%>
	<header>
		<!-- div for nav bar to be created in -->
        <div id="navDiv" class="navigation">
        </div>
	</header>
    <fieldset style="width: 90%; margin:auto; height: 100%; background-color: white;">
	<div class="tabbable boxed parentTabs p-4">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#instructor" class="nav-link">My Class</a>
        </li>
        <li><a href="#class1" class="nav-link">Java</a>
        </li>
        <li><a href="#class2" class="nav-link">HTML</a>
        </li>
    </ul>
    <div class="tab-content">
        <div class="tab-pane fade active in" id="instructor">
            <div class="tabbable">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#sub11" class="nav-link">To Grade</a>
                    </li>
                    <li><a href="#sub12" class="nav-link">Overdue</a>
                    </li>
                    <li><a href="#sub13" class="nav-link">All Assignments</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane fade active in" id="sub11">
                        <p>Table of to grade assignments</p>
                    </div>
                    <div class="tab-pane fade" id="sub12">
                        <p>List of Overdue Assignments, by EmployeeID</p>
                    </div>
                    <div class="tab-pane fade" id="sub13">
                        <p>All Assignments, by Status</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="tab-pane fade" id="class1">
            <div class="tabbable">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#sub21" class="nav-link">To Do</a>
                    </li>
                    <li><a href="#sub22" class="nav-link">All Assignments</a>
                    </li>
                    <li><a href="#sub23" class="nav-link">Grades</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane fade active in" id="sub21">
                        <p>Assignments overdue or due within the week</p>
                    </div>
                    <div class="tab-pane fade" id="sub22">
                        <p>All currently active or completed assignments</p>
                    </div>
                    <div class="tab-pane fade" id="sub23">
                        <p>All submitted assignments and their Grade</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="tab-pane fade" id="class2">
            <div class="tabbable">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#sub31" class="nav-link">To Do</a>
                    </li>
                    <li><a href="#sub32" class="nav-link">All Assignments</a>
                    </li>
                    <li><a href="#sub33" class="nav-link">Grades</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane fade active in" id="sub31">
                        <p>Assignments overdue or due within the week</p>
                    </div>
                    <div class="tab-pane fade" id="sub32">
                        <p>All currently active or completed assignments</p>
                    </div>
                    <div class="tab-pane fade" id="sub33">
                        <p>All submitted assignments and their Grade</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</fieldset>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
</html>
