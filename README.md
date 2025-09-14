# Campus Event Management Application

Project Overview:
This project is a backend implementation of an Event Management Application, accompanied by a basic front-end wireframe. The application allows for managing students, colleges, and events, as well as generating event-related reports. Key reports include the total number of events, registered students, and attendance tracking for each event.

The backend exposes RESTful APIs supporting POST, GET, PUT, PATCH, and DELETE operations for managing students, colleges, and events. Additional functionalities include student registration for events, attendance marking, and report generation.

Key Features:

1.Add, update, delete, and retrieve student information

2.Register students for events

3.Add, update, and delete college information

4.Create and manage events

5.Track and monitor event attendance

6.Generate reports detailing:
* Number of students registered for an event

* Number of students who attended

* Overall feedback

Technologies Used:

* Java 17

* Spring Boot 3.5

* Spring Data JPA / Hibernate

* MySQL 8

* HTML, JavaScript

* RESTful APIs

* Maven

Setup Instructions:

1.Clone the repository.

2.Create a database named CampusEvent.

3.Configure application.properties with your database username and password. Ensure that the database exists in MySQL.

4.Open the front-end HTML pages: index.html, from which you can navigate to admin.html and student.html.

5.For testing all backend functionalities, use Postman or any API client with sample input data.

Note:
The front-end is minimal and partially implemented. Full functionality of the application can be tested using the provided APIs.
