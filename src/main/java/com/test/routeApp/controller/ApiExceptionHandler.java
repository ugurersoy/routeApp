package com.test.routeApp.controller;

import com.test.routeApp.exception.RouteNotFountException;
import com.test.routeApp.model.ErrorMessageResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(RouteNotFountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageResponseDto findError(RouteNotFountException ex)
    {
        ErrorMessageResponseDto result = ErrorMessageResponseDto.builder().build();
        result.setErrorCode("-1");
        result.setErrorMessage(ex.getMessage());
        return  result;
    }


}
