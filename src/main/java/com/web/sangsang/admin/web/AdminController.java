package com.web.sangsang.admin.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kimwonyong on 2017. 1. 25..
 */
@Controller
@RequestMapping(value="/web/admin")
public class AdminController {

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response){

        return "admin/index";
    }

}
