package com.web.sangsang.framework.exceptions.advice;

import com.web.sangsang.framework.exceptions.EmptyTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(EmptyTokenException.class)
    public String notValidTokenException(EmptyTokenException exception) {
        return exception.toString();
    }
}
