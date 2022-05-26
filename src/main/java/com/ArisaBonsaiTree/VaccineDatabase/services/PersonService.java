package com.ArisaBonsaiTree.VaccineDatabase.services;

import com.ArisaBonsaiTree.VaccineDatabase.entities.Person;
import com.ArisaBonsaiTree.VaccineDatabase.model.PersonRequestDto;
import com.ArisaBonsaiTree.VaccineDatabase.model.PersonResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {
    List<PersonResponseDto> getAllPeople();

    PersonResponseDto getPersonById(Long id);
    PersonResponseDto createPerson(PersonRequestDto personRequestDto);


}
