package com.ArisaBonsaiTree.VaccineDatabase.controllers;


import com.ArisaBonsaiTree.VaccineDatabase.model.PersonRequestDto;
import com.ArisaBonsaiTree.VaccineDatabase.model.PersonResponseDto;
import com.ArisaBonsaiTree.VaccineDatabase.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
@AllArgsConstructor
public class PersonController {

    private PersonService personService;

    @GetMapping
    public List<PersonResponseDto> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping("/{id}")
    public PersonResponseDto getPersonById(@PathVariable Long id){
        return personService.getPersonById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponseDto createPerson(@RequestBody PersonRequestDto personRequestDto){
        return personService.createPerson(personRequestDto);
    }
}
