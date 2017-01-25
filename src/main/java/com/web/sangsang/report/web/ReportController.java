package com.web.sangsang.report.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kimwonyong on 2017. 1. 25..
 */
@Controller
@RequestMapping(value="/web/report")
public class ReportController {

    @RequestMapping(value="/document1", method = RequestMethod.GET)
    public String document1(){
        return "/report/document1";
    }
}
