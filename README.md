# mondiaAssignment

SpringBoot Hibernate and RestAPI Application
Introduction: 
A RESTful API Application built on Springboot Framework, Hibernate and In-Memory Database (H2). When running this application, we can perform CRUD operation with Employee Data by sending a Rest API in order to populate the in-memory SQL database with entries from a Query Parameter (Approached way). The resource of RESTful API is Employee, which will response JSON structure data based on endpoints.
Technologies Stack:
•	Language: Java
•	Development Kit: Java SDK 8
•	Framework: SpringBoot
•	Build Automation Tool: Maven
•	Database: H2 (In-Memory)
•	ORM: Hibernate
•	Service API: REST API
•	IDE: STS 3.9.2
Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
Local Installation
Prerequisites
Required
•	Java SDK 8
•	Java IDE (SpringToolSuite recommended or Eclipse)


ER Diagram and Architecture:-
ER Diagram. 
Application Architecture:- 
Installing and Running Application
Please follow carefully step by step instructions below in order to get the app up and running locally.
1.	Copy the Shared (zip) file into your local System and Extract the File.
2.	Import the file as Existing Maven Project into your Eclipse or STS.
3.	Clean and Install the Maven dependency – in case of any errors in POM file, please do a force update of the project.
4.	Go to SpringHibernateCrud main class and Run the Project as Java Application

API Documentation
Localhost base URL: http://localhost:7070/employee
Note: 
•	Windows: In order to test RESTful API Endpoints you need to use an HTTP Client Tool, such as postman.
•	Ubuntu/Linux: In order to test RESTful API Endpoints you may need either a HTTP client tool such as Postman or we can also use terminal to hit CURL command (commands given later in this document).
Create Employee
Create new Employee from Query Parameter with values sent in query parameter.
•	URL
  /saveuser
•	Method:
  POST
•	URL Params:-employee/saveuser?empname=Imran%20Abid&city=Chennai&email=imranabid@gmail.com”
Response:
{
    "empid": 1,
    "empname": "Imran Abid",
    "city": "Chennai",
    "email": "imranabid@gmail.com"
}  
Note :- There is also a way to create Employee by passing JSON body with curl request.
Show All Employee
Returns json list of Employee records data
•	URL
/list
•	Method:
GET
•	Response:
{
        "empid": 1,
        "empname": "Imran Abid",
        "city": "Chennai",
        "email": "imranabid@gmail.com"
      },, {...}]

Show Employee by Employee Id
Returns json of a specific Person data based on its empid
•	URL
/fetchuser/{id}
•	URL Params:
Required:
     id=[Long]
•	Method:
GET
•	Response:
 {
    "empid": 2,
    "empname": "Maaz Hurzuk",
    "city": "mumbai",
    "email": "maaz@gmail.com"
}
Note :- if Employee record does not exist then we will get response as “Record Does not Exist”.

Update Employee Data
Updates the values sent as query parameter in url of a specific Employee by its ID, returns updated response Message
URL
/updateuser
•	Method:
     PUT
•	URL Params:
/employee/updateuser?empname=Abid Alam&city=Bangalore&email=abidimran003@gmail.com&empid=1

•	Success Response:
o	{"message": " Record Updated Successfully "}

•	Unsuccessful Response
o	{"message": " Record Does not Exist "}
Delete Employee
Deletes Employee by its ID and returns a message if deleted successfully
•	URL
/deleteuser/id
•	Method:
DELETE
•	URL Params:
Required:
id=[Long]
•	Success Response:
o	{"message": " Record Deleted Successfully "}

•	Unsuccessful Response
o	{"message": " Record Not Found "}
 

Data Source:- 
application.properties

spring.h2.console.enabled=true
spring.h2.console.path=/h2


# Datasource
spring.datasource.url=jdbc:h2:file:~/test
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.show-sql=true
server.port=7070
h2 databaseurl:- http://localhost:7070/h2/










Curl Requests:- 
Creating a new Employee:
•	curl -X POST "http://localhost:7070/employee/saveuser?empname=Shoaib%20Mohd&city=Lucknow&email=someuser@gmail.com"
•	curl -X POST "http://localhost:7070/employee/saveuser?empname=Abid%20Imran&city=Delhi&email=someuser@gmail.com"
•	curl -X POST "http://localhost:7070/employee/saveuser?empname=Maaz%20Hurzuk&city=Mumbai&email=maaz.hurzuk@gmail.com"
•	curl -X POST "http://localhost:7070/employee/saveuser?empname=Imran%20Alam&city=Bhopal&email=imran.alam@gmail.com"
Fetching all Employees:
•	curl -X GET "http://localhost:7070/employee/list"
Fetching particular Employee by ID:
•	curl -X GET "http://localhost:7070/employee/fetchuser/1"
•	curl -X GET "http://localhost:7070/employee/fetchuser/2"

If record does not exists:
•	curl -X GET "http://localhost:7070/employee/fetchuser/8"
            Response: Record Does not Exist



Updating an existing Employee:
•	curl -X PUT "http://localhost:7070/employee/updateuser?empname=Abid%20Alam&city=Bangalore&email=abidimran003@gmail.com&empid=2"
Response: Record Updated Successfully
If record does not exists:
•	curl -X PUT "http://localhost:7070/employee/updateuser?empname=Abid%20Alam&city=Bangalore&email=abidimran003@gmail.com&empid=8"
Response:  Record Does not Exist

Delete an existing Employee:
•	curl -X DELETE  "http://localhost:7070/employee/deleteuser/2"
Response: Record Deleted Successfully
If record does not exists:
•	curl -X DELETE  "http://localhost:7070/employee/deleteuser/9"
Response: Record Not Found



