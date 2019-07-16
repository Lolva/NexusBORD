Here's the base Spring Boot Maven Web App -

A few things to keep in mind:
	-In order to launch the Spring Boot App properly, you need to include 	ojdbc14.jar
	1. After importing the project to STS; right click the project and go to properties -> Java Buildpath -> Libraries.
		1a. If the ojdbc14.jar file is already there, highlight and delete the jar.
	2. Import an External Jar.
		2a. ojdbc14.jar is located in NexusBORD/src
	3. Run the as -> Spring Boot App and access the website at http://localhost:8085