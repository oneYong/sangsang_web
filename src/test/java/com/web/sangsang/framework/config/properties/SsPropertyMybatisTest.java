package com.web.sangsang.framework.config.properties;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by cloud4u on 2016-04-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SsPropertyMybatisTest {
    @Autowired
    private SsPropertyMybatis ssPropertyMybatis;

    @Test
    public void testProperty() throws Exception{
        System.out.println(ssPropertyMybatis.getConfigPath());

    }
}
