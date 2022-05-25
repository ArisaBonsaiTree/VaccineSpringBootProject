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

@Entity --> Tells Spring this is an entity 
@NoArgsCOnstructor/@Getter/@Setter - Lombok code to reduce boilerplace
If we have a tablename that is a SQL reserve word --> In the database, different name
@Table(name="order_table")

Only if we have 1:M/N:M relationships

Doing this creates joined columns instead of joined tables

Lemonade.class
@ManyToOne
@JoinColumn
private Order order; <-- order is the field

Order.class
@OneToMany(mappedBy = "order")
mappedBy = "[NAME OF THE FIELD]"

======================
Setting Up Repositories and Populating the Database
======================
Spring will generate a repository that is located at JpaRepository.class
    saveAll(), getOne(), and ...
    CTRL + Click on JpaRepository to view the methods JpaRepository will generate for us
    
A benefit of using JpaRepository is that we decouple from PostgreSQL, meaning we can use MySQL/Oracle
Since this is an interface that Spring will generate based off the Drivers

CommandLineRunner: Take care of anything we want before our application starts
CommandLineRunner will run after Spring starts up

@Component tells Spring they will manage it
@Repository is a child of Componenet that helps us convert an entity to database table

@DatabaseSeeder
private PersonRepository personRepository;
@AllArgsConstructor will make Spring create this object first --> Spring has to pass a PersonRepository object

Ctrl + Alt + L --> Format the code properly

save() vs saveAndFlush()
    save(): May or may not write your changes to the DB straight away
    saveAndFlush() ENFORCING THE SYNCHRONIZATION


======================
HTTP & REST
======================


