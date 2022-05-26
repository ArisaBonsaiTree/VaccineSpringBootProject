package com.ArisaBonsaiTree.VaccineDatabase.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 1123756874591889233L;

    private String message;

}
