Spring course app 
===============================


- mvn clean package -DskipTests=true
- mvn tomcat7:run-war
- http://localhost:8090/

###To check pdf:

- http://localhost:8090/getTicketsForEventPdf?eventName=The%20revenant&auditorium=Yellow%20hall&dateEvent=2016-02-05T21:18:00
- accept=application/pdf

### Security:

- login url: http://localhost:8090/login
- admin url: http://localhost:8090/admin
- any url for authenticated user: / or /welcome
