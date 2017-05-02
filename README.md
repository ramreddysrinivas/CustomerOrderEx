 DB tables
customer(cId number(6) primary key ,cName varchar2(20) not null)
Address(zipcode varchar2(10) primary key,street varchar2(15),area varchar2(15),district varchar2(15) not null)
order(oId number(8) primary key, oName varchar2(25) not null , cId number(6)
foreign key(cId) references customer(cId));


Application information
Created for doing POC using HTML, Angular JS
Repository: GIT
build tool: maven
Technologies: Java 1.8, Spring 4.x with REST controller, spring JDBC, 
DB : MySQL
HTML,ANgular JS

DB details:



Flows: User Registration flow

Access application: URL on web
http://localhost:8080/springangularjsapp/

URL on REST: 
http://localhost:8080/springangularjsapp/resources/customer/save
HTTP POST
REQ Headers: Content-Type:application/json
REQ body:
{"firstName":"firstName",
"lastName":"lastName",
"gender":"Male",
"addresses":[{"area":"chanda nagar","city":"Hyderabad"}	,{"area":"Kharadi","city":"Pune"}]
}