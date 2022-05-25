package com.ArisaBonsaiTree.VaccineDatabase.model;

import com.ArisaBonsaiTree.VaccineDatabase.entities.Vaccine;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PersonRequestDto {

    private String name;

    private Vaccine vaccine;
}
