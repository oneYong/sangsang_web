package com.web.sangsang.framework.exceptions.advice;

import com.web.sangsang.framework.exceptions.EmptyTokenException;
import com.web.sangsang.framework.exceptions.vo.RestErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by WYKIM on 2017-01-10.
 */
@ControllerAdvice
@RestController
public class ExceptionHandlerController {
    private static final Logger log = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @Autowired
    private HttpServletRequest request;

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    public String requestHandlingNoHanderFound(NoHandlerFoundException exception){
        log.error("uri : {}, method : {}, error : {}", request.getRequestURI(), request.getMethod(), exception.getMessage());
        RestErrorInfo restErrorInfo = new RestErrorInfo(HttpStatus.NOT_FOUND.value(),exception.getMessage());
        return restErrorInfo.toString();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(EmptyTokenException.class)
    public String notValidTokenException(EmptyTokenException exception) {
        log.error("uri : {}, method : {}, error : {}", request.getRequestURI(), request.getMethod(), exception.toString());
        return exception.toString();
    }
}
