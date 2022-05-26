package com.ArisaBonsaiTree.VaccineDatabase.controllers.advice;

import com.ArisaBonsaiTree.VaccineDatabase.exceptions.BadRequestException;
import com.ArisaBonsaiTree.VaccineDatabase.exceptions.NotFoundException;
import com.ArisaBonsaiTree.VaccineDatabase.model.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackages = {"com.ArisaBonsaiTree.VaccineDatabase.controllers"})
@ResponseBody
public class PersonControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorDto handleBadRequestException(HttpServletRequest request, BadRequestException badRequestException) {
        return new ErrorDto(badRequestException.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorDto handleNotfoundException(HttpServletRequest request, NotFoundException notFoundException) {
        return new ErrorDto(notFoundException.getMessage());
    }
}
