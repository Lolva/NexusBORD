<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Modules</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/nexusbord.css">

<style>
.accordion {
	background-color: #eee;
	color: #444;
	cursor: pointer;
	padding: 18px;
	width: 100%;
	text-align: center;
	border: none;
	outline: none;
	transition: 0.4s;
	font-family: sans-serif;
	font-size: 25px;
}

/* Add a background color to the button if it is clicked on (add the .active class with JS), and when you move the mouse over it (hover) */
.active, .accordion:hover {
	background-color: #ccc;
}

/* Style the accordion panel. Note: hidden by default */
.panel {
	padding: 0 18px;
	background-color: white;
	display: none;
	overflow: hidden;
}

div.panel p {
	text-color: black;
}

table {
	column-count: 3;
	column-fill: auto;
	border-collapse: collapse;
	border-spacing: 0px;
	color: black;
	margin-left: 5%;
	width: 100%;
	margin: 10px;
	"
}

td a {
	text-decoration: none;
}

td {
  border: solid 0;
  text-align: center;
}
th {
border: solid 0;
  text-align: center;

}
</style>
</head>

<body>
	<header>
		<div class="navigation">
			<ul class="topnavbar">
				<li><a class="logout"
					onclick="confirm('Logout?'); location.href = '/logout.htm';">Logout</a></li>
				<li><a href="Nexus.html">Home</a></li>
				<li><a class="active" href="Modules.html">Modules</a></li>
				<li><a href="InstructorAssignments.html">Assignments</a></li>
				<li><a href="Grades.html">Grades</a></li>
				<li><a href="Classes.html">Classes</a></li>
				<li class="left"><a class="nexus"><b>Nexus<font
							color="#04aad0">BORD</font></b></a></li>
			</ul>
		</div>
	</header>
	<fieldset
		style="width: 90%; margin: auto; padding: 0px; height: 520px; background-color: white; border: none">
		<div style="background-color: #2E2E7F; padding: 2px;">
			<h2 style="color: white; margin: 10px; margin-top: 1%; opacity: 1">
				Modules</h2>
		</div>
        
        <input type="button" value="Generate ACCORDION" onclick="generateAccordion(1)"/>
        <div id="accordion"></div>
        
		       <div>
		
			<button class="accordion">Module1</button>
			<div class="panel">

				<!-- dynamic table -->
				<input type="button" value="Generate Table" onclick="GenerateTable()" />
				<div id="dvTable"></div>
	
			</div>

			<button class="accordion">Module2</button>
			<div class="panel">
				<!-- dynamic table -->
				<input type="button" value="Generate Table" onclick="GenerateTable()" />
				<div id="dvTable2"></div>
			</div>

			<button class="accordion">Module 3</button>
			<div class="panel">
				<!-- dynamic table -->
				<input type="button" value="Generate Table" onclick="GenerateTable()" />
				<div id="dvTable3"></div>

			</div>
			 -->
		</div>
	</fieldset>
	<script>
		var acc = document.getElementsByClassName("accordion");
		var i;

		for (i = 0; i < acc.length; i++) {
			acc[i].addEventListener("click", function() {
				/* Toggle between adding and removing the "active" class,
				to highlight the button that controls the panel */
				this.classList.toggle("active");

				/* Toggle between hiding and showing the active panel */
				var panel = this.nextElementSibling;
				if (panel.style.display === "block") {
					panel.style.display = "none";
				} else {
					panel.style.display = "block";
				}
			});

		}
	</script>

	<div id="module"></div>
	<script type="text/javascript">
		function GenerateTable() {
			//Build an array containing Customer records.
			var modules = new Array();
			// this is just so the link is only appended to "Assignment."
			//can be changed later to see if it's an assignment_name variable?
			var re = /Assignment/
			modules.push([ "", "Name", "Due Date", "Submitted" ]);
			modules.push([ "", "Assignment 1", "7/18/19", "Submitted" ]);
			modules.push([ "", "Assignment 2", "7/18/19", "Submitted" ]);
			modules.push([ "", "Assignment 3", "7/18/19", "Not Submitted" ]);

			//Create a HTML Table element.
			var table = document.createElement("TABLE");
			table.border = "1";

			//Get the count of columns.
			var columnCount = modules[0].length;

			//Add the header row.
			var row = table.insertRow(-1);
			for (var i = 0; i < columnCount; i++) {
				var headerCell = document.createElement("TH");
				headerCell.innerHTML = modules[0][i];
				row.appendChild(headerCell);
			}

			//Add the data rows.
			for (var i = 1; i < modules.length; i++) {
				row = table.insertRow(-1);
				for (var j = 0; j < columnCount; j++) {
					var cell = row.insertCell(-1);
					if (re.test(modules[i][j])) {
						cell.innerHTML = "<a href=http://localhost:8085/InstructorAssignments.html>"
								+ modules[i][j] + "</a>";
					} else {
						cell.innerHTML = modules[i][j];
					}
				}
			}
            
			<!--this is why it's only working once-->
			<!--this is how you connect it to something -->
			var dvTable = document.getElementById("dvTable");
			dvTable.innerHTML = "";
			dvTable.appendChild(table);
		}
	</script>
	
	<script type = "text/javascript">
	 function generateAccordion(number_of_modules){
		 
		 <!--the div need-->
		 <!--
		 var table_div = document.createElement('div');
		 table_div.id = 'dvTable'
		 var accordion = document.getElementById("accordion");
		 var new_accordion = document.createElement('button');
		 var panel_div = document.createElement('div');
		 new_accordion.className = "accordion";
		 accordion.innerHTML = "";
		 accordion.appendChild(table_div);
		 accordion.addEventListener('click',GenerateTable(),false);
		 -->
		 
		 var table_div = document.createElement('div');
		 table_div.id = 'dvTable'
		 var accordion = document.getElementById("accordion");
		 var new_accordion = document.createElement('button');
		 new_accordion.className = "accordion";
		 var panel_div = document.createElement('div');
		 panel_div.className = 'panel';
		 new_accordion.innerHTML = "";
		 new_accordion.appendChild(panel_div)
		 panel_div.innerHTML = "";
		 panel_div.appendChild(table_div);
		 <!--there needs to be a second event listen to make the accordion-->
		 <!--should see accordion first, then table, not table right away-->
		 panel_div.addEventListener('click',GenerateTable(),false);
		 
		 	
	 }
	
	</script>
	<script>
	function test() {
		window.alert("success")
	}
	</script>
	<footer>
		<p>Footer</p>
	</footer>
</body>
</html>
