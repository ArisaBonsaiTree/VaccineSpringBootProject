package com.ArisaBonsaiTree.VaccineDatabase.repositories;

import com.ArisaBonsaiTree.VaccineDatabase.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findById(Long id);
}
