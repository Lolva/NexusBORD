var roleId = null;
var classId  = null;
var moduleId = null;

function navBar(currentPage, activePage, student ){
	currentPage.document.getElementById("navDiv").innerHTML = "<ul class='topnavbar'>" +
			"<li><a class='logout' id ='logout' href='logout' onclick=\"return confirm('Logout?');\">Logout</a></li>" +
			"<li><a id = 'home' href='Nexus'>Home</a></li>" +
			"<li><a id='modules' href='Modules'>Modules</a></li>" +
			"<li><a id='assignments' href='InstructorAssignments'>Assignments</a></li>" +
			"<li><a id='classes' href='Classes'>Classes</a></li>" +
			"<li class='left'><a class='nexus'><b><font color=white>Nexus</font><font color='#04aad0'>BORD</font></b></a></li>" +
			"</ul>";
	
	currentPage.document.getElementById(activePage).className = "active";
}
