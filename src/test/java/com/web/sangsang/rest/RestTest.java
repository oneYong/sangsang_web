package com.web.sangsang.rest;

import com.web.sangsang.cmm.entity.SsPlace;
import com.web.sangsang.cmm.util.CmmUtil;

import java.util.List;

/**
 * Created by pig on 2017. 1. 4..
 */
public class RestTest {
    public static void main(String[] args) {
        RestConnector reader = new RestConnector();
        //
        //SsUser obj = reader.getUser("FACEBOOK", "100200034");
        //System.out.println("REQUEST OBJECT : " + obj);
        //
        //SsUser user = reader.updateUser(obj);
        //System.out.println("REQUEST OBJECT : " + user);
        //
        //SsPlace museum = reader.getMuseum(600L);
        //System.out.println("REQUEST OBJECT : " + museum);
        //
        List<SsPlace> museumList = reader.getMuseum("공주");
        System.out.println("REQUEST OBJECT : " + CmmUtil.toCamelCase("SS_UASE_NMA"));
    }
}
