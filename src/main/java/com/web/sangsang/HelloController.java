package com.web.sangsang;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WYKIM on 2017-01-04.
 */
@RestController
@RequestMapping(value="/")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return "Hello SangSang Web";
    }
}
