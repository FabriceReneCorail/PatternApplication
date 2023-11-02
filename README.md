# PatternApplication
this project a @SpringBootApplication
 is focused on Back-End Java. using docker for my mysql server and a MVC architecture to handling data 
I want to add Luquibase to handling database and add Swagger on it and also keycloak to handle all the app's connections.

DataManager Module
Actually in this project, i've some api to handle the User datas (Filter, getall getByLastname, getById, etc..) i use the JpaRepository inheritance to build my own methods.
Im also able to create new database and modify everything with Liquibase.
I've created an employee  table and ill create all the back-end element to be able to CRUD and filter my result (next step:EntityManager test)
DataConnectors Module
atm i working on AWS S3 to store datas in buckets.

