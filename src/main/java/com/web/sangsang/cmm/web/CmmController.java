package com.web.sangsang.cmm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WYKIM on 2017-01-04.
 */
@Controller
@RestController
@RequestMapping(value="/")
public class CmmController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return "Hello SangSang App";
    }
}
