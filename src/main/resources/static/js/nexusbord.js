var roleId = null;
var classId  = null;
var moduleId = null;
function navBar(currentPage, activePage, role ){
	console.log(role);
	if(role == "1"){
	currentPage.document.getElementById("navDiv").innerHTML = "<ul class='topnavbar'>" +
		"<li><a class='logout' id='logout' data-toggle='modal' data-target='#logoutModal'><font color=white>Logout</font></a></li>" +
		"<li><a id = 'home' href='Nexus'>Home</a></li>" +
		"<li><a id='modules' href='Modules'>Modules</a></li>" +
		"<li><a id='assignments' href='Assignments'>Assignments</a></li>" +
		"<li><a id='classes' href='Classes'>Classes</a></li>" +
		"<li class='left'><a class='nexus'><b><font color=white>Nexus</font><font color='#04aad0'>BORD</font></b></a></li>" +
		"</ul>";
	} else {
		currentPage.document.getElementById("navDiv").innerHTML = "<ul class='topnavbar'>" +
		"<li><a class='logout' id='logout' data-toggle='modal' data-target='#logoutModal'><font color=white>Logout</font></a></li>" +
		"<li><a id = 'home' href='Nexus'>Home</a></li>" +
		"<li><a id='modules' href='Modules'>Modules</a></li>" +
		"<li><a id='assignments' href='Assignments'>Assignments</a></li>" +
		"<li class='left'><a class='nexus'><b><font color=white>Nexus</font><font color='#04aad0'>BORD</font></b></a></li>" +
		"</ul>";
	}
	currentPage.document.getElementById("LogoutModalDiv").innerHTML = 
		"<div class='modal fade' id='logoutModal' tabindex='-1' role='dialog' aria-labelledby='LogoutModalTitle' aria-hidden='true'>" +
			"<div class='modal-dialog modal-dialog-centered' role='document'>" + 
				"<div class='modal-content'>" +
					"<div class='modal-header'>" +
						"<h5 class='modal-title' id='LogoutModalTitle'>Logout</h5>" +
						"<button type='button' class='close' data-dismiss='modal' aria-label='Close'>" +
							"<span aria-hidden='true'>&times;</span>" +
						"</button>" + 
					"</div>" +
					"<div class='modal-body'>" +
						"<p>Are you sure you want to log out?</p>" +
					"</div>" +
					"<div class='modal-footer' style=\"color: white;\">" +
						"<a class='inactiveButtons' data-dismiss='modal'>Cancel</button>" +
						"<a class='submissionButtons' onclick=\"window.location.href='/logout';\">Logout</button>" + 
					"</div>" +
				"</div>" +
			"</div>" +

		"</div>";
	 
		currentPage.document.getElementById(activePage).className = "active";
	}