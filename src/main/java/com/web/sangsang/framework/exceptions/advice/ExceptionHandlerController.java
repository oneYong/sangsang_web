package com.web.sangsang.framework.exceptions.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created by WYKIM on 2017-01-10.
 */
@ControllerAdvice
@RestController
public class ExceptionHandlerController {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    public String requestHandlingNoHanderFound(){
        return "error! ";
    }
}
