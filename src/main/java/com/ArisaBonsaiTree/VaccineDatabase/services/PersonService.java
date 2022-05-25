package com.ArisaBonsaiTree.VaccineDatabase.services;

import com.ArisaBonsaiTree.VaccineDatabase.entities.Person;
import com.ArisaBonsaiTree.VaccineDatabase.model.PersonRequestDto;
import com.ArisaBonsaiTree.VaccineDatabase.model.PersonResponseDto;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<PersonResponseDto> getAllPeople();

    PersonResponseDto createPerson(PersonRequestDto personRequestDto);
}
