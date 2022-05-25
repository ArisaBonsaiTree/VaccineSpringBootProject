# VaccineSpringBootProject
Decided to give myself more practice with Spring Boot by making a simple backend

======================
Creating our First Spring Project
======================
https://start.spring.io
Mavern Project/Java/2.7.0/Jar/11
Dependencies: Spring Web, Spring Boot DevTools, Lombok, Spring Data JPA, PostgreSQL Driver

resources folder --> application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/[NameOfDatabase]
spring.datasource.username=[PostgreSQL_Username]
spring.datasource.password=[PostgreSQL_Password

spring.jpa.hibernate.ddl-auto=create-drop // update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true

server.port=1111

For IntelliJ, you don't need to configure your IDE for Lombok


======================
Creating Entities and Generating a Database
======================
