# VaccineSpringBootProject
Decided to give myself more practice with Spring Boot by making a simple backend

======================
__Creating our First Spring Project__
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
__Creating Entities and Generating a Database__
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


=============
__Setting Up Repositories and Populating the Database__
=============  

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
__Setting up the Person Controller and Service__
======================

@RestController --> Tell spring this will be recieiving HTTP request
@RequestMapping("[endpoints]") --> handle endpoints that start with [endpoints]

CONTROLLER SHOULD NOT DIRECTLY INTERACT WITH THE REPOSITORY
Controller will ask the service that will ask the repository which [Control pipeline]

Forward engineering --> Create a method in the controller and make our IDE create the method in the service interface
In our ServiceImpl, we need to add @Service

Person >---|- Vaccine:  
A person has one vaccine  
A vaccine can go to many people[person]

Person.class  
@ManyToOne  
@JoinColumn  
private Vaccine vaccine;  

Vaccine.class  
@OneToMany(mappedBy = "vaccine")  
private List<Person> person;  

VaccineTable:  
id | name  
1  | Morderna  
2  | Pfizer  

PersonTable:  
id | Name | vaccine_id  
1  | John | 1  
2  | Luke | 2  
3  | Smith| 2  

At the moment, we shouldn't link Vaccine -- Person at the moment.


======================
__Adding DTOs and Mappers__
======================

__Apostille:__ To have the project auto reload with Spring-boot on ODEA IntelliJ,
Make sure you have spring-boot-devtools in your pom.xml file
File > Setting > Build, Execution, Deployment > Compiler > [] Build project automatically

Linking Vaccine and Person just required me removing:
Vaccine.java:   
@OneToMany(mappedBy = "vaccine")  
private List<Person> persons;

Person.java:  
@ManyToOne   
@JoinColumn(name = "vaccine_id")   
private Vaccine vaccine;   

{
"id": 3,
"name": "John",
"vaccine": {
"id": 1,
"name": "Morderna"
}
},

DTO: Serves as objects that the client knows. Abstracts them in a way. 

We can create as much DTO as we want. We can have six DTO's go to one entity!

models is the presentation layer, what the client should know

Request is what we are inputting
@NoArgsConstructor
@Data

Response contains the id
We want to let our client know where the object was stored

SAME NAME AS OUR ENTITIES!!!

In our controller, instead of returning a Person object, WE WANT TO RETURN A RESPONSE DTO
In our argumenets, we send REQUEST DTO

REQUEST: Input
RESPONSE: Output

PersonRepository DOES NOT return DTO's. It returns a list of people
We need to map it to convert it to DTO
We will manually map it, then we will automate it

int[] y = {1,2,3,4,5}
for(int x: y)
print(x) --> 1, 2, 3, 4, 5


for(Person person:personRepository.findAll())
For each person entity in personRepository.findAll(),
result.add(new PersonResponseDto())

In our PersonResponseDto --> Add @AllArgsConstructor [Overloaded constructor]

First:   
Create a Person entity object. Which we will map our RequestDto objects to the Person entity.

Save that entity to our repository using saveAndFlush

Now we have a generated ID, then we create a ResponseDto and map it from the Person entity/what was stored in our databased using Repository

Map the ID that our DB generated and other attributes and return it as a ResponseDTO

Give the method PersonRequestDTO -> Map it into a Person object -> saveAndFlush() that
person object which returns an entity with an id -> Map that Person Object into a PersonResponseDTO->
return PersonResponseDto

Request -> What we expect to be given

Response -> What we expect to give to the client


Adding MapStruct/Lombok Spring Boot [In out pom.xml]:   
https://springframework.guru/using-mapstruct-with-project-lombok/


How to clean install Mavern?  
On the top right, where we run our project, click on the dropdown menu and click edit configuration.  
Now add mavern and add "clean install" and we can easily run our project

Now create a mappers package and make an interface "PersonMapper"  
@Mapper(componentModel = "spring")


Person requestDtoToEntity(PersonRequestDto personRequestDto);   
Person requestDtoToEntity(PersonRequestDto personRequestDto);   <- Replaces the following:  
    Person personToSave = new Person();   
    personToSave.setName(personRequestDto.getName());   
    personToSave.setVaccine(personRequestDto.getVaccine());  

PersonResponseDto entityToResponseDto(Person person);   
PersonResponseDto personToPersonResponseDto(Person person);   
    return new PersonResponseDto(savedPerson.getId(), savedPerson.getName(), savedPerson.getVaccine());

List<PersonResponseDto> entitiesToResponseDtos(List<Person> persons);   
List<PersonResponseDto> entitiesToResponseDtos(List<Person> persons);   
    for(Person person:personRepository.findAll()){
        result.add(new PersonResponseDto(
                person.getId(),
                person.getName(),
                person.getVaccine()
        ));
    }

IntelliJ Idea mapstruct java: Internal error in the mapping processor: java.lang.NullPointerException?   
    You can also add -Djps.track.ap.dependencies=false at File | Settings (Preferences on macOS) | Build, Execution, Deployment | Compiler | Build process VM options as a workaround.  
    -Djps.track.ap.dependencies=false

If you change your DTO/Entity you need to rebuild your project! [STOP THE PROJECT AND RUN THE MAVEN BUILD]

======================
__Basic Exception Handling with HTTP Status Codes__
======================

In our Controllers, we wrap our return type with ResponseEntity<RETURN_TYPE>


getPersonById --> throws an exception --> Which is why we implement a derived query in our Person repository   
Derived query will make JpaRepository generate SQL methods based off the name

JpaRepository wants to use Optional<>. Prevents null and   
Optional<Person> findById(Long id);

Now we can use isEmpty() instead of null when working with optional --> isPresent() NOT isEmpty()


If the optional object is not null, we can call .get()

We are changing our Dto from primitive to wrapper types:   
double --> Double :: Now we can check if something is null [A person didn't post this info]


======================
__Creating & Handling our own Custom Exceptions__
======================

Create two new packages: exceptions and advice under the controller package

Create our custom exceptions in our exceptions package

In each of the exception files we created --> extends RuntimeException

InteliJ won't generate one without some help

private static final long serialVersionUID = [PLACE CURSOR HERE]; <-- Red error line, place cursor on it and hit ALT + Enter

Now add private String message and include @AllArgsConstructor & @Getter / @Setter

Now we need to create an error DTO


Now we go back to our PersonControllerAdvice and create ExceptionsHandler: It will look for a certain Exception

Add @ResponseBody --> Convert Error DTO to json
@RestController --> Controller & ResponseController


Now we do not need to wrap our controllers with "ResponseEntity"

Now we can just throw our own custom exceptions when we want

If we want to throw a successful response code --> In PersonController.java --> Under @PostMapping    
@ResponseStatus(HttpStatus.CREATED)

Format our code -->  CTRL + ALT + L   
Remove unused imports --> CTRL + ALT + O   
Switch to a different window file --> ALT + [LEFT ARROW] || [RIGHT ARROW]
Close a file --> CTRL + F4

Git FAQ:   
If we are working on a side branch, how do we merge to main?

git branch [name] --> Create a new branch   
git checkout [name] --> git add * --> git commit -m "sads"   
git checkout main --> git merge [name]   
git push   

Merge Conflict???    
Go to the file that has the conflict


git status --> See a file you want to go back?

git restore *


Delete a local branch  
git branch -d <local-branch>


Create a branch from master    
git checkout -b [NAME_OF_BRANCH] master


CTRL + SHIFT + UP_ARROW TO EASILY MOVE METHODS AROUND!



