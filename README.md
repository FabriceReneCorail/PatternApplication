# PatternApplication

this project a @SpringBootApplication
 is focused on Back-End Java. using docker for my mysql server and a MVC architecture to handling data 
 I added different component:Docker, Liquibase to handling database,Swagger on it and soon i hope :) keycloak to handle all the app's connections.

"The DataManager Module" 
Actually in this module have some api to handle the User datas (Filter, getall getByLastname, getById, etc..) i use the JpaRepository inheritance to build my own methods.

-Im also able to create new tables and alter everything with Liquibase. For big Data i would love to use a csv file with 2K User's lines for exemple and add them into the rights tables with a bulk but i need to think about it.
-I've created an employee table and create all the back-end element to be able to CRUD and filter my result (next step:EntityManager test for the table's relationship)



"The DataConnectors Module"
This module is as you understood help my app to store data on cloud (AWS S3 in progress)
atm i working on AWS S3 to store datas in buckets.

