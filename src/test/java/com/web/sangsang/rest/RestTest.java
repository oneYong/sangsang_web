package com.web.sangsang.rest;

import com.web.sangsang.cmm.entity.SsMuseum;
import com.web.sangsang.cmm.entity.SsUser;

import java.util.List;

/**
 * Created by pig on 2017. 1. 4..
 */
public class RestTest {
    public static void main(String[] args) {
        RestConnector reader = new RestConnector();
        //
        SsUser obj = reader.getUser("FACEBOOK", "1234567890");
        System.out.println("REQUEST OBJECT : " + obj);
        //
        SsMuseum museum = reader.getMuseum(1234567890L);
        System.out.println("REQUEST OBJECT : " + museum);
        //
        List<SsMuseum> museumList = reader.getMuseum("공주");
        System.out.println("REQUEST OBJECT : " + museumList);
    }
}
