package com.web.sangsang.framework.exceptions.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WYKIM on 2017-01-10.
 */
@ControllerAdvice
@RestController
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    public String requestHandlingNoHanderFound(){
        return "error! ";
    }
}
