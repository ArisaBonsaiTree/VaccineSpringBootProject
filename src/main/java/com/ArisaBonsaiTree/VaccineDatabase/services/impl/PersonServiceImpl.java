package com.ArisaBonsaiTree.VaccineDatabase.services.impl;

import com.ArisaBonsaiTree.VaccineDatabase.entities.Person;
import com.ArisaBonsaiTree.VaccineDatabase.mappers.PersonMapper;
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

    private PersonMapper personMapper;

    @Override
    public List<PersonResponseDto> getAllPeople() {
        // Give it a list from the database findAll() into personReponseDto
        return personMapper.entitiesToResponseDtos(personRepository.findAll());
    }

    @Override
    public PersonResponseDto createPerson(PersonRequestDto personRequestDto) {

        Person personToSave = personMapper.requestDtoToEntity(personRequestDto);

        return personMapper.entityToResponseDto(personRepository.saveAndFlush(personToSave));
    }
}
