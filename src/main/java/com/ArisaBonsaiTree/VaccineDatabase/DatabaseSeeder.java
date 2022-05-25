package com.ArisaBonsaiTree.VaccineDatabase;

import com.ArisaBonsaiTree.VaccineDatabase.entities.Person;
import com.ArisaBonsaiTree.VaccineDatabase.entities.Vaccine;
import com.ArisaBonsaiTree.VaccineDatabase.repositories.PersonRepository;
import com.ArisaBonsaiTree.VaccineDatabase.repositories.VaccineRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private PersonRepository personRepository;
    private VaccineRepository vaccineRepository;

    @Override
    public void run(String... args) throws Exception {

        Vaccine vaccine1 = new Vaccine();
        vaccine1.setName("Morderna");
        vaccineRepository.saveAndFlush(vaccine1);

        Person john = new Person();
        john.setName("John");
        john.setVaccine(vaccine1);
        vaccine1.setPerson(john);

        personRepository.save(john);
        vaccineRepository.saveAndFlush(vaccine1);


        Vaccine vaccine2 = new Vaccine();
        vaccine2.setName("Pfizer");
        vaccineRepository.saveAndFlush(vaccine2);

        Person luke = new Person();
        luke.setName("Luke");
        luke.setVaccine(vaccine2);
        vaccine2.setPerson(luke);

        personRepository.save(luke);
        vaccineRepository.saveAndFlush(vaccine2);


        Vaccine vaccine3 = new Vaccine();
        vaccine3.setName("Morderna");
        vaccineRepository.saveAndFlush(vaccine3);

        Person steve = new Person();
        steve.setName("Steve");
        steve.setVaccine(vaccine3);
        vaccine3.setPerson(steve);

        personRepository.saveAndFlush(steve);
        vaccineRepository.saveAndFlush(vaccine3);

    }
}
