package com.web.sangsang.cmm.util;


import com.web.sangsang.framework.config.properties.SsPropertyMybatis;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by cloud4u on 2016-04-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CmmSqlUtilsTest {

    private CmmSqlUtils cmmSqlUtils;

    @Before
    public void init(){
        cmmSqlUtils = new CmmSqlUtils();
    }

    @Test
    public void testGetTableColumInfo() throws Exception{
        System.out.println(cmmSqlUtils.getTableColumInfo("SS_MUSEUM"));

    }
}
