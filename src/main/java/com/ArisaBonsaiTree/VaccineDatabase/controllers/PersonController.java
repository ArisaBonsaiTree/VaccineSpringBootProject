package com.ArisaBonsaiTree.VaccineDatabase.controllers;


import com.ArisaBonsaiTree.VaccineDatabase.entities.Person;
import com.ArisaBonsaiTree.VaccineDatabase.services.PersonService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("persons")
@AllArgsConstructor
public class PersonController {

    private PersonService personService;

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
}
