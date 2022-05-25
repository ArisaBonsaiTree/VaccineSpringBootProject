package com.ArisaBonsaiTree.VaccineDatabase.services.impl;

import com.ArisaBonsaiTree.VaccineDatabase.entities.Person;
import com.ArisaBonsaiTree.VaccineDatabase.repositories.PersonRepository;
import com.ArisaBonsaiTree.VaccineDatabase.repositories.VaccineRepository;
import com.ArisaBonsaiTree.VaccineDatabase.services.PersonService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public Person createPerson(Person person) {
        person.setId(null);
        person.setName(person.getName());
        return personRepository.saveAndFlush(person);
    }
}
