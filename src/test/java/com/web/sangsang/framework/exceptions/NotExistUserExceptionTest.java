package com.web.sangsang.framework.exceptions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by WYKIM on 2017-01-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class NotExistUserExceptionTest {
    @Autowired
    private NotExistUserException notExistUserException;
    @Test
    public void testValues(){
        try{
            throw notExistUserException;
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
