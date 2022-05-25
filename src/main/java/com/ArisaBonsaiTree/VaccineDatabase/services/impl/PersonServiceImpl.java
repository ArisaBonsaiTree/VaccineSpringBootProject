package com.ArisaBonsaiTree.VaccineDatabase.services.impl;

import com.ArisaBonsaiTree.VaccineDatabase.entities.Person;
import com.ArisaBonsaiTree.VaccineDatabase.model.PersonRequestDto;
import com.ArisaBonsaiTree.VaccineDatabase.model.PersonResponseDto;
import com.ArisaBonsaiTree.VaccineDatabase.repositories.PersonRepository;
import com.ArisaBonsaiTree.VaccineDatabase.repositories.VaccineRepository;
import com.ArisaBonsaiTree.VaccineDatabase.services.PersonService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Override
    public List<PersonResponseDto> getAllPeople() {
        List<PersonResponseDto> result = new ArrayList<PersonResponseDto>();
        for(Person person:personRepository.findAll()){
            result.add(new PersonResponseDto(
                    person.getId(),
                    person.getName(),
                    person.getVaccine()
            ));
        }

        return result;
    }

    @Override
    public PersonResponseDto createPerson(PersonRequestDto personRequestDto) {

        // Map personRequestDto to a Person entity
        Person personToSave = new Person();

        personToSave.setName(personRequestDto.getName());
        personToSave.setVaccine(personRequestDto.getVaccine());

        // Save the Person entity, mapped to requestDto, to our database --> Generates the id
        Person savedPerson = personRepository.saveAndFlush(personToSave);

        // Create a new Response DTO object and get from the entity everything stored
        return new PersonResponseDto(savedPerson.getId(), savedPerson.getName(), savedPerson.getVaccine());
    }
}
