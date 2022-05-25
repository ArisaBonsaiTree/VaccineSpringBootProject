package com.ArisaBonsaiTree.VaccineDatabase.services;

import com.ArisaBonsaiTree.VaccineDatabase.entities.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getAllPeople();

    Person createPerson(Person person);
}
