package com.ArisaBonsaiTree.VaccineDatabase.mappers;

import com.ArisaBonsaiTree.VaccineDatabase.entities.Person;
import com.ArisaBonsaiTree.VaccineDatabase.model.PersonRequestDto;
import com.ArisaBonsaiTree.VaccineDatabase.model.PersonResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person requestDtoToEntity(PersonRequestDto personRequestDto);

    PersonResponseDto entityToResponseDto(Person person);

    List<PersonResponseDto> entitiesToResponseDtos(List<Person> persons);
}
