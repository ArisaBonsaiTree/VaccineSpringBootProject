package com.ArisaBonsaiTree.VaccineDatabase.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Vaccine {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

//    @OneToMany(mappedBy = "vaccine")
//    private List<Person> persons;

}
