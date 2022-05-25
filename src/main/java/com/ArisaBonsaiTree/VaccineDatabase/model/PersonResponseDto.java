package com.ArisaBonsaiTree.VaccineDatabase.model;

import com.ArisaBonsaiTree.VaccineDatabase.entities.Vaccine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonResponseDto {

    private Long id;

    private String name;

    private Vaccine vaccine;
}
