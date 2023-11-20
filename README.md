# PatternApplication

this project a @SpringBootApplication
 is focused on Back-End Java. using docker for my mysql server and a MVC architecture to handling data 
 I added different component:Docker, Liquibase to handling database,Swagger on it and soon i hope :) keycloak to handle all the app's connections.

"The DataManager Module" 
Actually in this module have some api to handle the User datas (Filter, getall getByLastname, getById, etc..) i use the JpaRepository inheritance to build my own methods.

-Im also able to create new tables and alter everything with Liquibase. For big Data i would love to use a csv file with 2K User's lines for exemple and add them into the rights tables with a bulk but i need to think about it.
-I've created an employee table and create all the back-end element to be able to CRUD and filter my result (next step:EntityManager test for the table's relationship)



"The DataConnectors Module"
This module is as you understood help my app to store data on cloud (AWS S3 in progress , Excel CsvFile)
atm i working on AWS S3 to store datas in buckets.
For Excel Csv file im able to read it and now im gonna push parse datas try to create table H2 to mapp datas with the table i already have.

"The DataBroker Module"
https://www.rabbitmq.com/download.html
for windows
docker run -d --name rabbitmq --ulimit nofile=1024:4096 --ulimit nproc=1024:2048 -p 5672:5672 -p 15672:15672 rabbitmq:3.9-management
for macOs
docker run -d --hostname my-rabbit -p 15672:15672 -p 5672:5672 --name some-rabbit rabbitmq:3.8-management 

This module will use RabbitMq: The controller reserve a command to fill a Queue.
And Some services need some message from the queue to proceed.
On my way to launche the server and test if my queue is filled :) 
 http://localhost:15672/#/ to have a look on the queue

for swagger test

{
  "name": "Support Technique",
  "messages": [
    "Premier message",
    "Deuxième message",
    "Troisième message",
    "Quatrième message",
    "Cinquième message",
    "Sixième message",
    "Septième message",
    "Huitième message",
    "Neuvième message",
    "Dixième message",
    "Onzième message",
    "Douzième message",
    "Treizième message",
    "Quatorzième message",
    "Quinzième message",
    "Seizième message",
    "Dix-septième message",
    "Dix-huitième message",
    "Dix-neuvième message",
    "Vingtième message",
    "Vingt et unième message",
    "Vingt-deuxième message",
    "Vingt-troisième message",
    "Vingt-quatrième message",
    "Vingt-cinquième message",
    "Vingt-sixième message",
    "Vingt-septième message",
    "Vingt-huitième message",
    "Vingt-neuvième message",
    "Trentième message",
    "Trente et unième message",
    "Trente-deuxième message",
    "Trente-troisième message",
    "Trente-quatrième message",
    "Trente-cinquième message",
    "Trente-sixième message",
    "Trente-septième message",
    "Trente-huitième message",
    "Trente-neuvième message",
    "Quarantième message",
    "Quarante et unième message",
    "Quarante-deuxième message",
    "Quarante-troisième message",
    "Quarante-quatrième message",
    "Quarante-cinquième message",
    "Quarante-sixième message",
    "Quarante-septième message",
    "Quarante-huitième message",
    "Quarante-neuvième message",
    "Cinquantième message",
    "Cinquante et unième message",
    "Cinquante-deuxième message",
    "Cinquante-troisième message",
    "Cinquante-quatrième message",
    "Cinquante-cinquième message",
    "Cinquante-sixième message",
    "Cinquante-septième message",
    "Cinquante-huitième message",
    "Cinquante-neuvième message",
    "Soixantième message",
    "Soixante et unième message",
    "Soixante-deuxième message",
    "Soixante-troisième message",
    "Soixante-quatrième message",
    "Soixante-cinquième message",
    "Soixante-sixième message",
    "Soixante-septième message",
    "Soixante-huitième message",
    "Soixante-neuvième message",
    "Soixante-dixième message",
    "Soixante et onzième message",
    "Soixante-douzième message",
    "Soixante-treizième message",
    "Soixante-quatorzième message",
    "Soixante-quinzième message",
    "Soixante-seizième message",
    "Soixante-dix-septième message",
    "Soixante-dix-huitième message",
    "Soixante-dix-neuvième message",
    "Quatre-vingtième message",
    "Quatre-vingt et unième message",
    "Quatre-vingt-deuxième message",
    "Quatre-vingt-troisième message",
    "Quatre-vingt-quatrième message",
    "Quatre-vingt-cinquième message",
    "Quatre-vingt-sixième message",
    "Quatre-vingt-septième message",
    "Quatre-vingt-huitième message",
    "Quatre-vingt-neuvième message",
    "Quatre-vingt-dixième message",
    "Quatre-vingt-onzième message",
    "Quatre-vingt-douzième message",
    "Quatre-vingt-treizième message",
    "Quatre-vingt-quatorzième message",
    "Quatre-vingt-quinzième message",
    "Quatre-vingt-seizième message",
    "Quatre-vingt-dix-septième message",
    "Quatre-vingt-dix-huitième message",
    "Quatre-vingt-dix-neuvième message",
    "Centième message"
  ]
}


