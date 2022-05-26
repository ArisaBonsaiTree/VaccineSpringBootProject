package com.ArisaBonsaiTree.VaccineDatabase.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -483626947948052680L;

    private String message;
}
