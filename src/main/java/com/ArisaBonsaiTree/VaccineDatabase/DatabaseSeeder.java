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

        Vaccine morderna = new Vaccine();
        morderna.setName("Morderna");

        Vaccine pfizer = new Vaccine();
        pfizer.setName("Pfizer");

        vaccineRepository.saveAll(Arrays.asList(new Vaccine[]{morderna, pfizer}));

        Person person1 = new Person();
        person1.setName("John");
        //person1.setVaccine(morderna);

        Person person2 = new Person();
        person2.setName("Luke");
        // person2.setVaccine(pfizer);

        Person person3 = new Person();
        person3.setName("Smith");
        // person3.setVaccine(pfizer);

        personRepository.saveAll(Arrays.asList(new Person[]{person1, person2, person3}));
    }
}
