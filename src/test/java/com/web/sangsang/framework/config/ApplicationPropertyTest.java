package com.web.sangsang.framework.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kimwonyong on 2017. 1. 2..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationPropertyTest {
    @Autowired
    private ApplicationProperty applicationProperty;

    @Test
    public void testApplicationProperty(){

        System.out.println("driverClassName : " + applicationProperty.getDataSource().getDriverClassName());
        System.out.println("url : " + applicationProperty.getDataSource().getUrl());
        System.out.println("userName : " + applicationProperty.getDataSource().getUserName());
        System.out.println("password : " + applicationProperty.getDataSource().getPassword());
    }
}
