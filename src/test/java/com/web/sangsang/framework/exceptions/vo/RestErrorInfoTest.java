package com.web.sangsang.framework.exceptions.vo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by WYKIM on 2017-01-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RestErrorInfoTest {
    @Test
    public void test(){
        RestErrorInfo restErrorInfo = new RestErrorInfo(1,"nice");
        System.out.println(restErrorInfo);

    }
}
